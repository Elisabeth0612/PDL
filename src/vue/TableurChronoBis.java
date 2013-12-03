/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableurChrono.java
 *
 * Created on 2 déc. 2013, 15:07:10
 */
package vue;

import controleur.Controleur;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 13008360
 */
public class TableurChronoBis extends javax.swing.JFrame implements MaFenetre {
private Controleur control;
    
    /** Creates new form TableurChrono */
    public TableurChronoBis(Controleur c) {
        control=c;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "N° Tour", "N° Voiture", "Pilote", "Temps", "Relai", "Etat", "Heure", "Commentaire"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   


    @Override
    public void afficher() {
        this.setVisible(true);
    }

    @Override
    public void masquer() {
        this.setVisible(true);
    
    }

    @Override
    public void fermer() {
        dispose();
    }

    @Override
    public MaFenetre getPrecedent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void vider() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void raffraichir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    public void ajouterLigne(String[] ligneTable) {
        DefaultTableModel modele3 = (DefaultTableModel)jTable1.getModel();   
        modele3.addRow(ligneTable); 
        jTable1.setModel(modele3); 
        jTable1.repaint(); 
    }
    
    public DefaultTableModel getTable(){
        return (DefaultTableModel)jTable1.getModel();
    } 

   
}
