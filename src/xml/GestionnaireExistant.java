package xml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Course;
import modele.EvenementSportif;
import modele.Pilote;
import modele.Voiture;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class GestionnaireExistant {
    private List<String> lesEvtExistants = new ArrayList<String>();
    private List<Voiture> lesVoituresExistantes=new ArrayList<Voiture>();
    private List<Pilote> lesPilotesExistants = new ArrayList<Pilote>();
    private String path;
    //private List<Course> lesCoursesExistantes;*/
    
     private static final GestionnaireExistant INSTANCE = new GestionnaireExistant();
    
     private GestionnaireExistant() {
         path = System.getProperty("user.dir" );
         //chargerExistants();
         //on va charger ici les données à partir des fichiers xml
     }
     
     /**
     * Créer une instance unique du Gestionnaire de la Sauvegarde : Pattern Singleton
     * @return instance
     */
    public static GestionnaireExistant getInstance() {
        return INSTANCE; // Il n'y a qu'un seul Gestionnaire
     }
     
     /**
     * Genere la liste des existants
     */
    public void chargerExistants(){
         chargerExistantsEvenement();
         chargerExistantsPilote();
         chargerExistantsVoiture();
     }
     

     /**
     * Genere les fichiers des existants
     * @param evtS EvenementSportif
     */
    public void enregistrementFermeture(EvenementSportif evtS){
         genererFichierEvenements(evtS);
         genererFichierPilotes();
         genererFichierVoitures();
         genererFichierUnEvtExistant(evtS);
    }
   
     
     /**
     * Cree le fichier
     * 
     * @param nomFic String
     * @param document Document
     */
    public void creerFichier(String nomFic,Document document){
         try {
             //enregistrement fichier
             FileOutputStream fos = new FileOutputStream(nomFic) ;
             OutputStreamWriter out = new OutputStreamWriter(fos);
             XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
             sortie.output(document, out);
         } catch (IOException ex) {
             Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
         }

     }
     
     /**
     * Gestion fichier un evenement
     * 
     * @param evtS EvenementSportif
     */
    public void genererFichierUnEvtExistant(EvenementSportif evtS){
         //on s'occupe de l'evenement courant
         Element racine = new Element("Evenement"+evtS.getNomEvt());
        Document document = new Document(racine);
        
        Element infE = new Element("Information_Evenement");
            infE.setAttribute("Nom_Evenement",evtS.getNomEvt());
            if(evtS.getDateEvt()!=null){
                infE.setAttribute("Date_Evenement",evtS.getDateEvt().toString());
            }
            else{
                infE.setAttribute("Date_Evenement","Date inconnue");
            }
            infE.setAttribute("Nom_Circuit",evtS.getNomCircuit());
            infE.setAttribute("Longueur_Circuit",Integer.toString(evtS.getLongueurCircuit()));
        racine.addContent(infE);
        
        /*****************************
         * on gère les informations des courses de l'evenement (et les voitures de la course)
         * ***************************/
        Element infCourses = new Element("Les_Courses");
        //pour chaque course
        for(Course c : evtS.getListC()){
            Element course = new Element("Course");
            course.setAttribute("Nom",c.getNomCourse());
            if(c.getHeureDeb()!=null){
                course.setAttribute("Heure_début",c.getHeureDeb().toString());
            }
            else{
                course.setAttribute("Heure_début","heure inconnue");
            }
            if(c.getHeureFin()!=null){
                course.setAttribute("Heure_fin",c.getHeureFin().toString());
            }
            else{
                course.setAttribute("Heure_fin","heure inconnue");
            }
            course.setAttribute("durée_max_pilotage",Integer.toString(c.getDureePilotageMaxParPilote()));
            course.setAttribute("durée_consecutive_pilotage",Integer.toString(c.getDureeConsecutivePilotageMaxParPilote()));
            course.setAttribute("meteo",c.getMeteo());
            course.setAttribute("type_fin",c.getTypeFin());
            course.setAttribute("nb_tours_max",Integer.toString(c.getNbToursMax()));
            
                /*****************************
                 * on gère les informations des voitures de la course (on enregistre seulement le nom des voitures)
                 * ***************************/
                 Element courseVoitures = new Element("les_voitures_course");
                 System.out.println(c.getListV().size());
                 for (Voiture v : c.getListV()){
                    Element voiture = new Element("voiture");
                    voiture.setAttribute("Num_Voiture",Integer.toString(v.getNumVoiture()));
                    courseVoitures.addContent(voiture);
                 }
                 course.addContent(courseVoitures);
                /*****************************
                * on gère les informations des tops de la course
                 * ***************************/
            
            infCourses.addContent(course);
        }
        
        racine.addContent(infCourses);
        
        /*****************************
         * on gère les informations des voitures de l'evenement
         * ***************************/
        Element infVoitures = new Element("Les_Voitures");
        //pour chaque voiture
        for(Voiture v : evtS.getListV()){
            Element voiture = new Element("Voiture");
            voiture.setAttribute("Num_Voiture",Integer.toString(v.getNumVoiture()));
            infVoitures.addContent(voiture);
        }
        racine.addContent(infVoitures);
        
        String fic = ""+path+"/Evenement_"+evtS.getNomEvt()+".xml";
        creerFichier(fic,document);
     }
     
     /**
     * Charge un evenement existant
     * 
     * @param nomEvenement String
     * @return EvenementSportif
     */
    public EvenementSportif chargerUnEvenementExistant(String nomEvenement){
         EvenementSportif evtS = null;
         try {
            
            //on s'occupe de l'evenement
            SAXBuilder builder = new SAXBuilder();
            File fic = new File(path+"/Evenement_"+nomEvenement+".xml");
            if(fic.exists() && fic.length()!=0){
                Document document = builder.build(new File(path+"/Evenement_"+nomEvenement+".xml"));
                Element racine = (Element) document.getRootElement();

                Element infEvt = racine.getChildren().get(0);
                    String nomE = racine.getChildren().get(0).getAttributeValue("Nom_Evenement");
                    String date = racine.getChildren().get(0).getAttributeValue("Date_Evenement");
                    Date dateE = null;
                    if(date.compareTo("Date inconnue")!=0){


                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                        try {
                            dateE = sdf.parse(racine.getChildren().get(0).getAttributeValue("Date_Evenement"));
                        } catch (ParseException ex) {
                            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    String nomCircuit = racine.getChildren().get(0).getAttributeValue("Nom_Circuit");
                    int longueur = Integer.parseInt(racine.getChildren().get(0).getAttributeValue("Longueur_Circuit"));
                    //on crée l'evenement..
                    evtS = new EvenementSportif(nomE,dateE,nomCircuit,longueur);

                Element infCourses = racine.getChildren().get(1);
                List filsCourses = infCourses.getContent();
                Iterator iterator = filsCourses.iterator();
                while (iterator.hasNext()) {
                    Object objetFils = iterator.next();
                    if (objetFils instanceof Element) {
                        Element course = (Element) objetFils;
                        String nomC = course.getAttributeValue("Nom");
                        //modifier ici
                        Date hdeb = null;
                        Date hfin = null;
                        //*******
                        int dureeMP = Integer.parseInt(course.getAttributeValue("durée_max_pilotage"));
                        int dureeCP =  Integer.parseInt(course.getAttributeValue("durée_consecutive_pilotage"));
                        String meteo = course.getAttributeValue("meteo");
                        String fin = course.getAttributeValue("type_fin");
                        int nbTours = Integer.parseInt(course.getAttributeValue("nb_tours_max"));
                        //on crée la course et on l'ajoute à levenement
                        Course c = new Course(nomC,hdeb, hfin, dureeMP, dureeCP, meteo, nbTours, fin);

                        //on s'occupe des voitures de la course
                        Element infVoituresCourse = course.getChildren().get(0);
                        List filsVoitures = infVoituresCourse.getContent();
                        Iterator iterator2 = filsVoitures.iterator();
                        while (iterator2.hasNext()) {
                            Object objetFils2 = iterator2.next();
                            if (objetFils2 instanceof Element) {
                                Element voiture = (Element) objetFils2;
                                int numV = Integer.parseInt(voiture.getAttributeValue("Num_Voiture"));
                                Voiture v =this.getUneVoiture(numV);
                                if(v!=null){
                                    c.addListV(v);
                                }
                            }
                        }

                        evtS.addListC(c);
                    }


                }

                //on recupere la liste des voitures de levenement
                Element infVoituresE = racine.getChildren().get(2);
                List filsVoituresE = infVoituresE.getContent();
                Iterator iterator3 = filsVoituresE.iterator();
                while (iterator3.hasNext()) {
                    Object objetFils3 = iterator3.next();
                    if (objetFils3 instanceof Element) {
                        Element voitE = (Element) objetFils3;
                        int numVE = Integer.parseInt(voitE.getAttributeValue("Num_Voiture"));
                        Voiture v2 = this.getUneVoiture(numVE);
                        if(v2!=null){
                            evtS.addListV(v2);
                        }
                    }
                }
            }
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
         return evtS;
     }
           
     
     /**
     * Gestion de l'existant du fichier Evenement
     * 
     * @param e EvenementSportif
     */
    public void genererFichierEvenements(EvenementSportif e){
         //Test si le fichier est déjà existant ou non
         File f= new File(path+"/listeEvenements.xml");
         if(f.exists()==true){
             try {
                 SAXBuilder builder = new SAXBuilder();
                 Document document = builder.build(new File(path+"/listeEvenements.xml"));
                 Element racine = (Element) document.getRootElement();
                 // Ajouter un nouvel élément
                 Element evt = new Element("Evenement");
                 racine.addContent(evt);
                Element nomE = new Element("Nom_Evenement").setText(e.getNomEvt());
                evt.addContent(nomE);
                 //evt.addContent(new Element("Nom_Evenement").setText(e.getNomEvt()));
                 String fic = path+"/listeEvenements.xml";
                 creerFichier(fic,document);
             } catch (JDOMException ex) {
                 Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }else{
             Element racine = new Element("Evenements");
             Document document = new Document(racine);
             Element evt = new Element("Evenement");
             racine.addContent(evt);
             Element nomE = new Element("Nom_Evenement").setText(e.getNomEvt());
             evt.addContent(nomE);
             String fic = ""+path+"/listeEvenements.xml";
             creerFichier(fic,document);
        }
     }
     
     
     /**
     * Charge les evenements existants
     */
    public void chargerExistantsEvenement(){
        try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            File fic = new File(path+"/listeEvenements.xml");
            if(fic.exists() && fic.length()!=0){
                Document document = builder.build(new File(path+"/listeEvenements.xml"));
                Element racine = (Element) document.getRootElement();

                List fils = racine.getContent();
                Iterator iterator = fils.iterator();
                while (iterator.hasNext()) {
                    //System.out.println("on fait 1 tour");
                    Object objetFils = iterator.next();
                    if (objetFils instanceof Element) {
                        Element elementFils = (Element) objetFils;
                        this.lesEvtExistants.add(elementFils.getChildren().get(0).getText());

                    }
                }
            }
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /**
     * Gestion de l'existant du fichier Voiture
     */
    public void genererFichierVoitures(){
         Element racine = new Element("Voitures");
         Document document = new Document(racine);
         for(Voiture v : this.lesVoituresExistantes){
             Element voiture = new Element("Voiture");
             Element numV = new Element("Num_Voiture").setText(Integer.toString(v.getNumVoiture()));
             voiture.addContent(numV);
             Element couleur = new Element("Couleur_voiture").setText(v.getCouleur());
             voiture.addContent(couleur);
             Element nbTours = new Element("nb_tours_relai").setText(Integer.toString(v.getNbToursParRelai()));
             voiture.addContent(nbTours);
             Element active = new Element("Voiture_active").setText(Boolean.toString(v.getVoitureActive()));
             voiture.addContent(active);
             //test if à enlever
             Element piloteAct;
             if(v.getPiloteActuel()!=null){
                piloteAct = new Element("Pilote_actuel").setText(v.getPiloteActuel().getNom()+"-"+v.getPiloteActuel().getPrenom());
             }
             else{
                 piloteAct = new Element("Pilote_actuel").setText("null");
             }
             voiture.addContent(piloteAct);
             //liste des pilotes
             Element pilotes = new Element("Les_pilotes");
             for(Pilote p : v.getListP()){
                 Element idPilote = new Element("nomP-PrenomP").setText(p.getNom()+"-"+p.getPrenom());
                 pilotes.addContent(idPilote);
             }
             voiture.addContent(pilotes);
             racine.addContent(voiture);
         }
         
         String fic = path+"/listeVoitures.xml";
         creerFichier(fic,document);
     }

     /**
     * Charge les voitures existantes
     */
    public void chargerExistantsVoiture(){
         try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            File fic = new File(path+"listeVoitures.xml");
            if(fic.exists() && fic.length()!=0){
                Document document = builder.build(new File(path+"/listeVoitures.xml"));
                Element racine = (Element) document.getRootElement();

                List fils = racine.getContent();
                Iterator iterator = fils.iterator();
                //pour chaque element <Voiture>
                while (iterator.hasNext()) {
                    Object objetFils = iterator.next();
                    if (objetFils instanceof Element) {
                        Element elementFils = (Element) objetFils;
                        int num = Integer.parseInt(elementFils.getChildren().get(0).getText());
                        String couleur = elementFils.getChildren().get(1).getText();
                        int nb = Integer.parseInt(elementFils.getChildren().get(2).getText());
                        boolean active = Boolean.parseBoolean(elementFils.getChildren().get(3).getText());
                        String piloteAct = elementFils.getChildren().get(4).getText();
                        Pilote p = null;
                        if(piloteAct.compareTo("null")==0){
                            p = null;
                        }
                        else{
                            String nomP = piloteAct.split("-")[0];
                            String prenonP = piloteAct.split("-")[1];
                            p = this.getUnPilote(nomP, prenonP);
                        }

                       Voiture v = new Voiture(num,p,couleur,nb,active);
                       /*
                       *on charge la liste des pilotes associés
                       */
                       List lesPilotes = elementFils.getChildren().get(5).getContent();
                       Iterator iterator2 = lesPilotes.iterator();
                        //pour chaque element <Pilote>
                        while (iterator2.hasNext()) {
                            Object objetFils2 = iterator2.next();
                            if (objetFils2 instanceof Element) {
                                Element unPilote = (Element) objetFils2;
                                //System.out.println(unPilote.getText());
                                String nomP2 = unPilote.getText().split("-")[0];
                                String prenomP2 = unPilote.getText().split("-")[1];
                                Pilote p2 = this.getUnPilote(nomP2, prenomP2);
                                v.addListP(p2);
                            }
                        }
                       this.lesVoituresExistantes.add(v);
                    }
                }
            }
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /**
     * Gestion de l'existant du fichier Pilote
     */
    public void genererFichierPilotes(){
         Element racine = new Element("Pilotes");
         Document document = new Document(racine);
         for(Pilote p : this.lesPilotesExistants){
             Element pilote = new Element("Pilote");
             Element nomP = new Element("Nom_Pilote").setText(p.getNom());
             pilote.addContent(nomP);
             Element prenomP = new Element("Prenom_Pilote").setText(p.getPrenom());
             pilote.addContent(prenomP);
             Element couleur = new Element("Couleur_casque").setText(p.getCouleursCasque());
             pilote.addContent(couleur);
             
             racine.addContent(pilote);
         }
         
         String fic = "listePilotes.xml";
         creerFichier(fic,document);
     }
     
     /**
     * Charge les pilotes existants
     */
    public void chargerExistantsPilote(){
         try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            File fic = new File(path+"/listePilotes.xml");
            if(fic.exists() && fic.length()!=0){
                Document document = builder.build(new File(path+"/listePilotes.xml"));
                Element racine = (Element) document.getRootElement();

                List fils = racine.getContent();
                Iterator iterator = fils.iterator();
                //pour chaque element <Pilote>
                while (iterator.hasNext()) {
                    Object objetFils = iterator.next();
                    if (objetFils instanceof Element) {
                        Element elementFils = (Element) objetFils;
                        String nomP = elementFils.getChildren().get(0).getText();
                        String prenomP = elementFils.getChildren().get(1).getText();
                        String couleur = elementFils.getChildren().get(2).getText();

                       Pilote p  = new Pilote(nomP,prenomP,couleur);
                       /*
                       *ici ajout des pilotes à la liste voiture
                       */

                       this.lesPilotesExistants.add(p);
                    }
                }
            }
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     //les getteurs
    
    /**
     * Retourne la liste des evenements existants
     * @return liste de String contenant les nom des evenements existants
     */
    public List<String> getEvenementsExistants() {
        return this.lesEvtExistants; 
    }
    
    /**
     * Retourne la liste des pilotes existants
     * @return liste de Pilote
     */
    public List<Pilote> getPilotesExistants(){
        return this.lesPilotesExistants;
    }
    
    /**
     * Retourne la liste des voitures existantes
     * @return liste de Voiture
     */
    public List<Voiture> getVoituresExistantes(){
        return this.lesVoituresExistantes;
    }
    
    /**
     * Méthode permettant de récupérer un Pilote existant
     * 
     * @param nom String
     * @param prenom String
     * @return Pilote
     */
    public Pilote getUnPilote(String nom,String prenom){
        for(Pilote p : this.lesPilotesExistants){
            if(p.getNom().compareTo(nom)==0 && p.getPrenom().compareTo(prenom)==0){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Méthode permettant de récupéer une Voiture existante
     * 
     * @param numV int
     * @return Voiture
     */
    public Voiture getUneVoiture(int numV){
        for(Voiture v : this.lesVoituresExistantes){
            if(v.getNumVoiture()==numV){
                return v;
            }
        }
        return null;
    }
    
    //les setteurs
    
    /**
     * Méthode permettant de créer une nouvelle voiture ajoutée à l'existant
     * @param v Voiture
     */
    public void creerNouvelleVoiture(Voiture v){
        this.lesVoituresExistantes.add(v);
    }
    
    /**
     * Méthode permettant de créer un nouveau pilote ajouté à l'existant
     * @param p Pilote
     */
    public void creerNouveauPilote(Pilote p){
        this.lesPilotesExistants.add(p);
    }
    
}
