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
    /*private List<Voiture> lesVoituresExistantes;
    private List<Pilote> lesPilotesExistants;
    private List<Course> lesCoursesExistantes;*/
    
     private static final GestionnaireExistant INSTANCE = new GestionnaireExistant();
    
     private GestionnaireExistant() {
         //chargerExistants();
         //on va charger ici les données à partir des fichiers xml
     }
     public static GestionnaireExistant getInstance() {
        return INSTANCE; // Il n'y a qu'un seul Gestionnaire
     }
     
     public void enregistrerNouvelEvenement(EvenementSportif e){
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
     
     
    
         
     
     public void enregistrementFermeture(EvenementSportif evtS){
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
     
     public void chargerExistants(){
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

    public List<String> getEvenementsExistants() {
        return this.lesEvtExistants; 
    }
    
}
