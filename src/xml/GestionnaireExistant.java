package xml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
 *
 * @author 13008360
 */
public class GestionnaireExistant {
    private List<String> lesEvtExistants = new ArrayList<String>();
    private List<Voiture> lesVoituresExistantes=new ArrayList<Voiture>();
    private List<Pilote> lesPilotesExistants = new ArrayList<Pilote>();
    //private List<Course> lesCoursesExistantes;*/
    
     private static final GestionnaireExistant INSTANCE = new GestionnaireExistant();
    
     private GestionnaireExistant() {
         //chargerExistants();
         //on va charger ici les données à partir des fichiers xml
     }
     public static GestionnaireExistant getInstance() {
        return INSTANCE; // Il n'y a qu'un seul Gestionnaire
     }
     
     //genere la liste des existants
     public void chargerExistants(){
         chargerExistantsEvenement();
         chargerExistantsPilote();
         chargerExistantsVoiture();
     }
     
     //genere les fichiers des existants
     public void enregistrementFermeture(EvenementSportif evtS){
         genererFichierPilotes();
         genererFichierVoitures();
         
         
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
         * on gère les informations des courses de l'evenement
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
                 for (Voiture v : c.getListV()){
                    courseVoitures.setAttribute("Num_Voiture",Integer.toString(v.getNumVoiture()));
                 }
                 course.addContent(courseVoitures);
                /*****************************
                * on gère les informations des tops de la course
                 * ***************************/
            
            infCourses.addContent(course);
        }
        
        racine.addContent(infCourses);
        String fic = "./src/xml/Evenement_"+evtS.getNomEvt()+".xml";
        creerFichier(fic,document);
    }
   
     
     //cree le fichier
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
     
     
     //Gestion Existants Evenement
     public void genererFichierEvenements(EvenementSportif e){
         //Test si le fichier est déjà existant ou non
         File f= new File("./src/xml/listeEvenements.xml");
         if(f.exists()==true){
             try {
                 SAXBuilder builder = new SAXBuilder();
                 Document document = builder.build(new File("./src/xml/listeEvenements.xml"));
                 Element racine = (Element) document.getRootElement();
                 // Ajouter un nouvel élément
                 Element evt = new Element("Evenement");
                 racine.addContent(evt);
                Element nomE = new Element("Nom_Evenement").setText(e.getNomEvt());
                evt.addContent(nomE);
                 //evt.addContent(new Element("Nom_Evenement").setText(e.getNomEvt()));
                 String fic = "./src/xml/listeEvenements.xml";
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
             String fic = "./src/xml/listeEvenements.xml";
             creerFichier(fic,document);
        }
     }
     
     
     public void chargerExistantsEvenement(){
        try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(new File("./src/xml/listeEvenements.xml"));
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
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     //Gestion Existants Voiture
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
         
         String fic = "./src/xml/listeVoitures.xml";
         creerFichier(fic,document);
     }

     public void chargerExistantsVoiture(){
         try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(new File("./src/xml/listeVoitures.xml"));
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
                        String nomP = piloteAct.split("-")[0];
                        String prenonP = piloteAct.split("-")[1];
                        Pilote p = this.getUnPilote(nomP, prenonP);
                   
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
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     //Gestion Existants Pilote
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
         
         String fic = "./src/xml/listePilotes.xml";
         creerFichier(fic,document);
     }
     
     public void chargerExistantsPilote(){
         try {
            
            //on s'occupe de la liste des evenements
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(new File("./src/xml/listePilotes.xml"));
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
        } catch (JDOMException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireExistant.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     //les getteurs
    public List<String> getEvenementsExistants() {
        return this.lesEvtExistants; 
    }
    
    public List<Pilote> getPilotesExistants(){
        return this.lesPilotesExistants;
    }
    
    public List<Voiture> getVoituresExistantes(){
        return this.lesVoituresExistantes;
    }
    
    public Pilote getUnPilote(String nom,String prenom){
        for(Pilote p : this.lesPilotesExistants){
            if(p.getNom().compareTo(nom)==0 && p.getPrenom().compareTo(prenom)==0){
                return p;
            }
        }
        return null;
    }
    
    //les setteurs
    public void creerNouvelleVoiture(Voiture v){
        this.lesVoituresExistantes.add(v);
    }
    
    public void creerNouveauPilote(Pilote p){
        this.lesPilotesExistants.add(p);
    }
    
}
