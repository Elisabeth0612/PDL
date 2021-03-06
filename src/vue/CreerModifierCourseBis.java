/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import controleur.Controleur;
import graphique.IntegerField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modele.Course;
import modele.Voiture;
import org.w3c.dom.NodeList;

/**
 *
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
*/
public class CreerModifierCourseBis extends javax.swing.JFrame implements MaFenetre{
    
    private Controleur controleur;
    private MaFenetre jfPrecedente;
    private Course cModifier;
    private DefaultListModel<String> model1;
    private DefaultListModel<String> model2;
    private List<Voiture> voitures;
    /**
     * Creates new form CreerModifierCourse
     * @param control
     * @param evt
     * @param c
     */
    public CreerModifierCourseBis(Controleur control, EvenementBis evt,Course c) {
        this.controleur=control;
        this.jfPrecedente=evt;
        this.cModifier=c;  
        initComponents(); 
        voitures=new ArrayList<Voiture>();
    }

    /**
     *Methode qui retourne la course a modifier
     * @return Course
     */
    public Course getcModifier() {
        return cModifier;
    }

    /**
     *Modifie la course à modifier
     * @param cModifier
     */
    public void setcModifier(Course cModifier) {
        this.cModifier = cModifier;
    }

    /**
     *Renvoie true si tous les champs ont été rempli
     * @return boolean
     */
    public boolean controleChampsSaisis(){
        boolean ok=true;
        if (jTextField1.getText().isEmpty()) ok=false;
        if (jFormattedTextField1.getText().isEmpty()) ok=false;
        if (jFormattedTextField2.getText().isEmpty()) ok=false;
        if (jTextField2.toString().isEmpty()) ok=false;
        if (jTextField3.toString().isEmpty()) ok=false;
        if (jTextField4.toString().isEmpty()) ok=false;
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) ok=false;
        return ok;
    }

    /**
     * Met à jour la course à modifier
     */
    public void miseAJourCModifier(){
        try {
            cModifier.setNomCourse(jTextField1.getText());
            Date deb = (Date) new SimpleDateFormat("HH:mm").parse(jFormattedTextField1.getText());
            Date fin = (Date) new SimpleDateFormat("HH:mm").parse(jFormattedTextField2.getText());
            cModifier.setHeureDeb(deb);
            cModifier.setHeureFin(fin);
            cModifier.setDureePilotageMaxParPilote(Integer.parseInt(jTextField3.getText()));
            cModifier.setDureeConsecutivePilotageMaxParPilote(Integer.parseInt(jTextField4.getText()));
            cModifier.setMeteo(jTextField7.getText());
            String typeFin;
            if (jRadioButton1.isSelected()){
                typeFin=jRadioButton1.getText();
            }
            else{
                typeFin=jRadioButton2.getText();
            }
            cModifier.setTypeFin(typeFin);
            cModifier.setNbToursMax(Integer.parseInt(jTextField2.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(CreerModifierCourseBis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jTextField2 = new IntegerField();
        jTextField3 = new IntegerField();
        jTextField4 = new IntegerField();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Nom de la course :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Heure de début :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Heure de fin :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("Nombre de tours maximum :");

        jRadioButton1.setText("Nombre de tours");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Temps");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setText("Type de fin :");

        jLabel6.setText("Durée maximum de pilotage d'un pilote :");

        jLabel7.setText("Durée maximum consécutive de pilotage : ");

        jLabel8.setText("Météo :");
        
        jList1.setModel(new javax.swing.AbstractListModel() {
            List<Voiture> lesV = new ArrayList<Voiture>();
            public int getSize() {return lesV.size(); }
            public Object getElementAt(int i) { return lesV.get(i).getNumVoiture(); }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            List<Voiture> lesV = new ArrayList<Voiture>();
            public int getSize() { return lesV.size(); }
            public Object getElementAt(int i) { return lesV.get(i).getNumVoiture();}
        });
        jScrollPane2.setViewportView(jList2);

        jButton1.setText(">>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Enregistrer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Annuler");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel9.setText("Liste des voitures inscrites à l'événement :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel10.setText("Liste des voitures inscrites à la course :");
        
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });
        
        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });
        
        jFormattedTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(37, 37, 37)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(178, 178, 178))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(21, 21, 21))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(361, 361, 361)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(391, 391, 391)
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)))
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) { 
        //Bouton retour
        raffraichir();
        controleur.retour();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {   
        //Bouton enregistrer
        if (!controleChampsSaisis()){
            JOptionPane.showMessageDialog(this,"Veuillez renseigner tous les champs pour créer/modifier la course","Erreur",JOptionPane.ERROR_MESSAGE);
        }else if (cModifier==null){
            try {
                String typeFin;
                if (jRadioButton1.isSelected()){
                    typeFin=jRadioButton1.getText();
                }
                else{
                    typeFin=jRadioButton2.getText();
                }
                Date deb = (Date) new SimpleDateFormat("HH:mm").parse(jFormattedTextField1.getText());
                Date fin = (Date) new SimpleDateFormat("HH:mm").parse(jFormattedTextField2.getText());
                cModifier=new Course(jTextField1.getText(),deb,fin,Integer.parseInt(jTextField2.getText()),Integer.parseInt(jTextField3.getText()),jTextField7.getText(),Integer.parseInt(jTextField4.getText()),typeFin);
                controleur.getCoursesEvenement().add(cModifier);
                cModifier.setListV(voitures);
                raffraichir();
                controleur.retour();
            } catch (ParseException ex) {
                Logger.getLogger(CreerModifierCourseBis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
            miseAJourCModifier();
            raffraichir();
            controleur.retour();
        }
    }                                        

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {       
        //Cocher bouton radio 1
        jRadioButton2.setSelected(!jRadioButton1.isSelected());
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //Cocher bouton radio 2
        jRadioButton1.setSelected(!jRadioButton2.isSelected());
    }                                             

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //Bouton >>
        if (!jList1.isSelectionEmpty()){
            Voiture v= (Voiture) controleur.getVoituresEvenement().get(jList1.getSelectedIndex());
            if (cModifier!=null){
                if (!cModifier.getListV().contains(v)){
                    cModifier.addListV(v);
                    model2.addElement(Integer.toString(v.getNumVoiture()));
                }
            }
            else{
                if (!voitures.contains(v)){
                    voitures.add(v);
                    model2.addElement(Integer.toString(v.getNumVoiture()));
                }
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //Bouton <<
        if (!jList2.isSelectionEmpty()){
            Voiture v=(Voiture) controleur.getVoituresEvenement().get(jList2.getSelectedIndex());
            if (cModifier!=null){
                cModifier.removeListV(v);
                System.out.println(cModifier.getListV().contains(v));
                model2.remove(jList2.getSelectedIndex());
            }
            else{
                voitures.remove(v);
                model2.remove(jList2.getSelectedIndex());
            }
        }
    }
    
   private void formWindowActivated(java.awt.event.WindowEvent evt) { 
       // Sur activation de la fenetre
        if (cModifier!=null){
            jTextField1.setText(cModifier.getNomCourse());
            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
            jFormattedTextField1.setText(sdf.format(cModifier.getHeureDeb()));
            jFormattedTextField2.setText(sdf.format(cModifier.getHeureFin()));
            jTextField2.setText(String.valueOf(cModifier.getNbToursMax()));
            jTextField3.setText(String.valueOf(cModifier.getDureePilotageMaxParPilote()));
            jTextField4.setText(String.valueOf(cModifier.getDureeConsecutivePilotageMaxParPilote()));
            jTextField7.setText(cModifier.getMeteo());
            if (cModifier.getTypeFin().equals(jRadioButton1.getText())){
                jRadioButton1.setSelected(true);
            }
            else{
                jRadioButton2.setSelected(true);
            }
        }
        chargerVoitureCourse();
        chargerVoitureEvenement();
    }  
    
    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }    
    
    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }    
    
    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) { 
        //Sur perte focus de heure debut
        if (!jFormattedTextField1.getText().contains(" ")){
            String[] tab=jFormattedTextField1.getText().split(":");
            if (Integer.parseInt(tab[0])>23 || Integer.parseInt(tab[1])>60){
                jFormattedTextField1.setText(null);
            } 
        }
    }   
    
    private void jFormattedTextField2FocusLost(java.awt.event.FocusEvent evt) {
        //Sur perte focus de heure fin
        if (!jFormattedTextField2.getText().contains(" ")){
            String[] tab=jFormattedTextField2.getText().split(":");
            if (Integer.parseInt(tab[0])>23 || Integer.parseInt(tab[1])>60){
                jFormattedTextField2.setText(null);
            }
        }
    }  
    


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private IntegerField jTextField2;
    private IntegerField jTextField3;
    private IntegerField jTextField4;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration

    /**
     *Masque la fenetre
     */
    @Override
    public void masquer() {
        setVisible(false);
    }
    
    /**
     * Fermer
     */
    @Override
    public void fermer() {
        dispose();
    }

    /**
     *Mais tous les jTextField a null et les bouton radios a false
     */
    @Override
    public void raffraichir() {
        jTextField1.setText(null);
        jFormattedTextField1.setText(null);
        jFormattedTextField2.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField7.setText(null);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
    }

    /**
     * Chargement des donnees voiture de l evenement en cours
     */
    public void chargerVoitureEvenement(){
        List<Voiture> lesV = controleur.getVoituresEvenement();
        if(!lesV.isEmpty()){
            model1 = new DefaultListModel<String>();
            for(Voiture v : lesV){
                model1.addElement(Integer.toString(v.getNumVoiture()));
            }
            jList1.setModel(model1);
            jList1.setSelectedIndex(0);
            jList1.repaint();
       }
    }
    
    /**
     *Chargement des donnees Voiture de la course selectionnee
     */
    public void chargerVoitureCourse(){
        if (cModifier!=null){
            List<Voiture> lesV = cModifier.getListV();
            model2 = new DefaultListModel<String>();
            if(!lesV.isEmpty()){
                for(Voiture v : lesV){
                    model2.addElement(Integer.toString(v.getNumVoiture()));
                }
                jList2.setModel(model2);
                jList2.setSelectedIndex(0);
                jList2.repaint();
            }else{
                model2 = new DefaultListModel<String>();
                jList2.setModel(model2);
                jList2.setSelectedIndex(0);
                jList2.repaint();
            }
        }else{
            List<Voiture> lesV = voitures;
            model2 = new DefaultListModel<String>();
            if(!lesV.isEmpty()){
                for(Voiture v : lesV){
                    model2.addElement(Integer.toString(v.getNumVoiture()));
                }
                jList2.setModel(model2);
                jList2.setSelectedIndex(0);
                jList2.repaint();
            }else{
                model2 = new DefaultListModel<String>();
                jList2.setModel(model2);
                jList2.setSelectedIndex(0);
                jList2.repaint();
            }
        }
    }
    
    /**
     *Retourne la fenetre precedente
     * @return MeFenetre
     */
    @Override
    public MaFenetre getPrecedent() {
       return jfPrecedente; 
    }
    
    @Override
    public void vider() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *Affiche la fenetre
     */
    @Override
    public void afficher() {
        setVisible(true);
    }
}
