package xml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.EvenementSportif;
import org.jdom2.Document;
import org.jdom2.Element;
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
    /*private List<EvenementSportif> lesEvtExistants;
    private List<Voiture> lesVoituresExistantes;
    private List<Pilote> lesPilotesExistants;
    private List<Course> lesCoursesExistantes;*/
    
     private static final GestionnaireExistant INSTANCE = new GestionnaireExistant();
    
     private GestionnaireExistant() {
         //on va charger ici les données à partir des fichiers xml
     }
     public static GestionnaireExistant getInstance() {
        return INSTANCE; // Il n'y a qu'un seul Gestionnaire
     }
     
     public void enregistrerNouvelEvenement(EvenementSportif e){
         //Test si le fichier est déjà existant ou non
         File f= new File("./src/xml/listeEvenements.xml");
         if(f.exists()==true){
             //System.out.println("existe");
            //ton code, car le fichier existe
             //on ajoute à la suite
             
        }else{
             Element racine = new Element("Evenements");
             Document document = new Document(racine);
             Element evt = new Element("Evenement");
             racine.addContent(evt);
             evt.setAttribute("Nom_evenement",e.getNomEvt());
             String fic = "./src/xml/listeEvenements.xml";
             creerFichier(fic,document);
         }
     }
     
     public void enregistrementFermeture(){
         
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
    
}
