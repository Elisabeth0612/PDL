/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public interface MaFenetre  {
    public void afficher();
    public void masquer();
    public void fermer();
    public MaFenetre getPrecedent();
    public void vider();
    public void raffraichir();
    //public String getTemps();
    //public void inititialiser();
    
}
