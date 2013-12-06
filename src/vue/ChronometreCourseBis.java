/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChronometreCourse.java
 *
 * Created on 2 déc. 2013, 15:08:54
 */
package vue;

import controleur.Controleur;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modele.Voiture;
import vue_defaut.JChronoUneVoiture;

/**
 *
 * @author 13008360
 */
public class ChronometreCourseBis extends javax.swing.JFrame implements MaFenetre {

    //nos variables
    private Controleur control;
    private Timer chronometre;
    private int timeCount = 0;
    private long h = 0;
    private long m = 0;
    private long s = 0;
    private Hashtable<Integer, JChronoUneVoitureBis> lesFenetresVoitures;

    /**
     * Creates new form ChronometreCourse
     */
    public ChronometreCourseBis(Controleur c) {
        control = c;
        initComponents();
    }

    private void initComponents() {
        chronometre = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {	// Cas d'un evenement genere par le bouton
                timeCount++;
                if (timeCount > 999) {
                    timeCount = 0;
                    s++;
                    if (s > 59) {
                        m++;
                        s = 0;
                        if (m > 59) {
                            h++;
                        }
                    }
                }

                jLabel9.setText("" + h + ":" + m + ":" + s + ":" + timeCount);
            }
        }
        );

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        
        this.setPreferredSize(new Dimension(300, 239));
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int reponse = JOptionPane.showConfirmDialog(null,
                        "Voulez-vous quitter la course?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (reponse == JOptionPane.YES_OPTION) {
                    control.fermerChronoCourse();
                    //controleur.fermerApplication();
                    fermer();
                }

            }
        });
        setResizable(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Démarrer/Arrêter la course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Voitures actuellement en course :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TEMPS DE COURSE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)))
                        .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        boolean prevenir = false;
        if (!chronometre.isRunning()) {
            chronometre.start();
            prevenir = true;
        } else {
            int reponse = JOptionPane.showConfirmDialog(null,
                    "Voulez-vous arreter la course (définitivement)?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (reponse == JOptionPane.YES_OPTION) {
                chronometre.stop();
                jButton1.setEnabled(false);
                prevenir = true;
                //on enregistre les temps de course
                //control.enregistrerLesTops();
            }
        }

        if (prevenir == true) {
            Enumeration e = this.lesFenetresVoitures.elements();
            //Parourir les valeurs
            while (e.hasMoreElements()) {
                ((JChronoUneVoitureBis) e.nextElement()).setEtatChrono();
            }
        }
    }

    private void jCheckBoxActionPerformed(ActionEvent evt) {
        JCheckBox check = (JCheckBox) evt.getSource();
        String num = check.getText();
        int numV = Integer.parseInt(num);
        if (!check.isSelected()) {
            this.lesFenetresVoitures.get(numV).masquer();
            //fermer une fenetre voiture

        } else {
            //activer une fenetre voiture
            this.lesFenetresVoitures.get(numV).afficher();
        }
    }

    

    // Variables declaration - do not modify                  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration      

    @Override
    public void afficher() {
        this.implementerListeCheckBox();
        setVisible(true);
    }

    @Override
    public void masquer() {
        setVisible(false);
    }

    @Override
    public void fermer() {
        Enumeration e = this.lesFenetresVoitures.elements();
        //Parourir les valeurs
        while (e.hasMoreElements()) {
            ((JChronoUneVoitureBis) e.nextElement()).fermer();
        }
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

    public void implementerListeCheckBox() {
        //jPanel2.add(jLabel6);
        //variable de placement des fenetres filles
        int locationX = 0;
        
        JCheckBox jcb = new JCheckBox();
        JChronoUneVoitureBis newVoiture;
        List<Voiture> lesV = control.getVoituresCourse();
        this.lesFenetresVoitures = new Hashtable<Integer, JChronoUneVoitureBis>();
        for (Voiture v : lesV) {
            //jComboBox1.addItem(v.getNumVoiture());
            jcb = new JCheckBox();
            jcb.setSelected(true);
            jcb.setText(Integer.toString(v.getNumVoiture()));
            jPanel2.add(jcb);
            jcb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBoxActionPerformed(evt);
                }

            });
            //on initialise une fenetre propriete voiture course
            if(locationX+250< Toolkit.getDefaultToolkit().getScreenSize().getWidth()){
                locationX = locationX + 250;
            }
            int placeX = ((int) this.getLocation().getX())+locationX;
            newVoiture = new JChronoUneVoitureBis(control, v.getNumVoiture(),placeX);
            newVoiture.afficher();
            this.lesFenetresVoitures.put(v.getNumVoiture(), newVoiture);
            //this.lesProprietesVoiture.add(newVoiture);

        }
    }

    public String getTemps() {
        return jLabel9.getText();
    }

}
