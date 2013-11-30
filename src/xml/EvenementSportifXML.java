/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xml;


import java.io.*;
import java.util.Date;
import javax.xml.*;
import modele.Course;
import modele.EvenementSportif;
import modele.Voiture;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
//import org.jdom.*;
//import org.jdom.output.*;
/**
 *
 * @author Co
 */
public class EvenementSportifXML {
    private EvenementSportif evtS;
   //Nous allons commencer notre arborescence en créant la racine XML
   //qui sera ici "evenement".
   //static Element racine = new Element("evenements");

   //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
   private static Document document ;

    public EvenementSportifXML(EvenementSportif e){
        evtS = e;
    }
    
    public void executer(){
        Element racine = new Element("Evenement"+evtS.getNomEvt());
        document = new Document(racine);
        
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
        afficher();
        enregistrer();
   }
   
   
   public void afficher()
{
   try
   {
      //On utilise ici un affichage classique avec getPrettyFormat()
      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
      sortie.output(document, System.out);
   }
   catch (java.io.IOException e){}
}

public void enregistrer()
{
   //String s = evtS.getNomEvt();
   try
   {
        FileOutputStream fos = new FileOutputStream("./src/xml/Evenement_"+evtS.getNomEvt()+".xml");
        OutputStreamWriter out = new OutputStreamWriter(fos);

      //On utilise ici un affichage classique avec getPrettyFormat()
      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
      //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
      //avec en argument le nom du fichier pour effectuer la sérialisation.
      sortie.output(document, out);
   }
   catch (java.io.IOException e){}
}
}