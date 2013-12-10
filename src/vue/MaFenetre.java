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
    
    /**
     * Affiche la fenetre
     */
    public void afficher();
    
    /**
     * Masque la fenetre
     */
    public void masquer();
    
    /**
     * Ferme la fenetre
     */
    public void fermer();
    
    /**
     * Retourne la fentre precedente
     * @return MaFenetre
     */
    public MaFenetre getPrecedent();
    
    /**
     * Vide la fenetre de son contenu
     */
    public void vider();
    
    /**
     * Permet de mettre à jour les champs de la fenetre
     */
    public void raffraichir();
    
}
