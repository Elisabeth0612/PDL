/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.Controleur;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modele.*;



/**
 *
 * @author Corinne Bechepois & Coralie Gendrier & Elisabeth Recule
 */
public class EvenementBis extends JFrame implements MaFenetre {
    
    //nos variables
    //private EvenementSportif evtS;
     private Controleur controleur;
     
     private DefaultListModel<String> model1;
     private DefaultListModel<String> model2;
    /**
     * Creates new form Evt
     */
    public EvenementBis(Controleur c) {
        super("Gestion de l'evenement");
        controleur = c;
        initComponents();
        //this.setVisible(true);
    }

    public void lancer(){
        //jLabel3.setText(controleur.getNomEvt());
        setVisible(true);
    }
    
    @Override
    public void afficher() {
        
        
        //on affiche la fenetre
        setVisible(true);
        raffraichir();
        setVisible(true);
        //jPanel2.updateUI();
        //jPanel2.
    }

    @Override
    public void masquer() {
        setVisible(false);
    }

    @Override
    public void fermer() {
        dispose();
    }
    
    @Override
    public void raffraichir() {
        
        /*if(controleur.getDateEvt()!=null){
            jLabel3.setText("Evenement : "+controleur.getNomEvt()+" - "+controleur.getDateEvt().toString()+" - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());
        }
        else{
            jLabel3.setText("Evenement : "+controleur.getNomEvt()+" - ?? - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());  
        }*/
        
        //jPanel2.revalidate();
        jPanel2.repaint();
        //jLabel3.revalidate();
        jLabel3.repaint();
        //jList1.revalidate();
        jList1.repaint();
        charger();
        
    }
    
    public void charger(){
        List<Course> lesC = controleur.getCoursesEvenement();
        if(lesC.size()!=0){
            model1 = new DefaultListModel<String>();
            for(Course c : lesC){
                model1.addElement(c.getNomCourse());
            }
            jList1.setModel(model1);
            jList1.setSelectedIndex(0);
            jList1.repaint();
       }
        
        List<Voiture> lesV = controleur.getVoituresEvenement();
        if(lesV.size()!=0){
            model2 = new DefaultListModel<String>();
            for(Voiture v : lesV){
                model2.addElement(Integer.toString(v.getNumVoiture()));
            }
            jList2.setModel(model2);
            jList2.setSelectedIndex(0);
            jList2.repaint();
       }
    }
   

    @Override
    public MaFenetre getPrecedent() {
       return null; 
    }
    
    @Override
    public void vider() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
   
   
    private void initComponents() {
        
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e){
                   int reponse = JOptionPane.showConfirmDialog(null,
                                        "Voulez-vous quitter l'application",
                                        "Confirmation",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE);
                   if (reponse==JOptionPane.YES_OPTION){
                       controleur.enregistrer();
                       //controleur.fermerApplication();
                       dispose();
                   }
             }
        });
        setResizable(false);
        /*addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                repaint();
                jPanel2.repaint();
                System.out.println("focus on");
            }
        });*/
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Courses :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Voitures inscrites :");
        jList1.setSelectionMode(1);
        //implémentation de la liste des courses // on peut aussi utiliser hashtable pour les listes
        jList1.setModel(new javax.swing.AbstractListModel() {
            List<Course> lesC = new ArrayList<Course>();
            //String[] strings = {lesC.get(0).getNomCourse(),lesC.get(1).getNomCourse()};
            public int getSize() { return lesC.size(); }
            public Object getElementAt(int i) { return lesC.get(i).getNomCourse(); }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);
        
        
        
        jList2.setModel(new javax.swing.AbstractListModel() {
            List<Voiture> lesV = new ArrayList<Voiture>();
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return lesV.size(); }
            public Object getElementAt(int i) { return lesV.get(i).getNumVoiture(); }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        jButton1.setText("Créer Nouvelle course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modifier la course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Supprimer la course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ajouter/enlever une voiture");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Modifier la voiture");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Supprimer la voiture");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Lancer la course");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Annuler");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        
        if(controleur.getDateEvt()!=null){
            //System.out.println("Evenement : "+controleur.getNomEvt()+" - "+controleur.getDateEvt().toString()+" - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());
            jLabel3.setText("Evenement : "+controleur.getNomEvt()+" - "+controleur.getDateEvt().toString()+" - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());
        }
        else{
            //System.out.println("Evenement : "+controleur.getNomEvt()+" - ?? - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());
            jLabel3.setText("Evenement : "+controleur.getNomEvt()+" - ?? - "+controleur.getNomCircuit()+" - "+controleur.getLongueurCircuit());  
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6)
                                    .addComponent(jButton5)
                                    .addComponent(jButton4))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(95, 95, 95))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(390, Short.MAX_VALUE)
                    .addComponent(jButton8)
                    .addGap(15, 15, 15)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addGap(34, 34, 34)
                .addComponent(jButton7)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(377, Short.MAX_VALUE)
                    .addComponent(jButton8)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        
        
        
        pack();
    }// </editor-fold>                        


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Creer nouvelle course"
        controleur.ouvrirCreerModifierCourse(null);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Modifier la course"
        if (!jList1.isSelectionEmpty()){
            controleur.ouvrirCreerModifierCourse((Course) controleur.getCoursesEvenement().get(jList1.getSelectedIndex()));
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez sélectionner la course que vous souhaitez modifier.","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Supprimer la course"
        if (!jList1.isSelectionEmpty()){
            controleur.getCoursesEvenement().remove(jList1.getSelectedIndex());
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez sélectionner la course que vous souhaitez supprimer.","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Ajouter/Enlever Voiture"
        controleur.ouvrirAjouterEnleverVoiture();
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Modifier Voiture"
        Object oV = jList2.getSelectedValue();
        if(oV == null){
             //Boîte du message d'erreur
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner une voiture !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }else{
            String voiture = jList2.getSelectedValue().toString();
            int numV = Integer.parseInt(voiture);
            
            controleur.ouvrirCreerModifierVoiture((Voiture) controleur.getVoitureEvenementByNum(numV));
            
        }
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Supprimer Voiture"
       if (!jList2.isSelectionEmpty()){
            int numV = Integer.parseInt((String)jList2.getSelectedValue());
            int i = jList2.getSelectedIndex();
            controleur.supprimerVoituresEvenement(numV);
            jList2.removeSelectionInterval(i-1, i);
            jList2.repaint();
        }
        else{
            JOptionPane.showMessageDialog(this,"Veuillez sélectionner la voiture que vous souhaitez supprimer.","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Bouton pour démarrer la course sélectionnée
        String course = (String)jList1.getSelectedValue();
        //System.out.println("course = "+course);
        if(course == null){
            //Boîte du message d'erreur
            JOptionPane jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Vous devez sélectionner une course !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(controleur.nbVoituresInscritesCourses(course)==0){
                JOptionPane.showMessageDialog(null, "Aucune voiture n'est inscrite à cette course !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else{
                controleur.demarrerCourse(course);
            }
        }
        
    } 
    
     

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Bouton "Annuler"
        controleur.retour();
    }                                        

    

   
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration

    
    

    


    
}
