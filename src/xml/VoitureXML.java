/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
//import static xml.EvenementSportifXML.document;

/**
 *
 * @author Co
 */
public class VoitureXML {
    
    public void executer() {
        Element racine = new Element("html");
        DocType docType = new DocType("html", "-//W3C//DTD XHTML 1.0 Transitional//EN","http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
        Document document = new Document(racine, docType);
    
        afficher(document);
    }
    
    public static void afficher(Document document)
    {
        try
        {
           //On utilise ici un affichage classique avec getPrettyFormat()
           XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
           sortie.output(document, System.out);
        }
        catch (java.io.IOException e){}
     }
    }
