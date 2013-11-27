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
    
}
