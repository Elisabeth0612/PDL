/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xml;


import java.io.*;
import javax.xml.*;
import modele.EvenementSportif;
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
        
        Element nomE = new Element("Nom_Evenement");
        nomE.addContent(evtS.getNomEvt());
        racine.addContent(nomE);
        
        Element nomC = new Element("Nom_Circuit");
        nomC.addContent(evtS.getNomCircuit());
        racine.addContent(nomC);
        
        Element longC = new Element("Longueur_Circuit");
        longC.addContent(Integer.toString(evtS.getLongueurCircuit()));
        racine.addContent(longC);
        
        /*Element dateE = new Element("Date_Evenement");
        dateE.addContent(evtS.getDateEvt().toString());
        racine.addContent(dateE);*/
        
        afficher();
   }
   /*public void executer()
   {
       System.out.println("on execute enreg");
      //On crée un nouvel Element etudiant et on l'ajoute
      //en tant qu'Element de racine
      Element evenement = new Element("evenement");
      racine.addContent(evenement);

      //On crée un nouvel Attribut classe et on l'ajoute à etudiant
     //grâce à la méthode setAttribute
      Attribute nomEvt = new Attribute("nom","NomE");
      evenement.setAttribute(nomEvt);

      //On crée un nouvel Element nom, on lui assigne du texte
      //et on l'ajoute en tant qu'Element de etudiant
      Element nom = new Element("nom");
      nom.setText("CynO");
      evenement.addContent(nom);

      //Les deux méthodes qui suivent seront définies plus loin dans l'article
      affiche();
      enregistre("evenements.xml");
   }*/
   
   static void afficher()
{
   try
   {
      //On utilise ici un affichage classique avec getPrettyFormat()
      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
      sortie.output(document, System.out);
   }
   catch (java.io.IOException e){}
}

static void enregistre(String fichier)
{
   try
   {
        FileOutputStream fos = new FileOutputStream("./src/xml/evenement.xml");
        OutputStreamWriter out = new OutputStreamWriter(fos, "ISO-8859-1");

      //On utilise ici un affichage classique avec getPrettyFormat()
      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
      //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
      //avec en argument le nom du fichier pour effectuer la sérialisation.
      sortie.output(document, out);
   }
   catch (java.io.IOException e){}
}
}