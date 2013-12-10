/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jChronoUneVoiture.java
 *
 * Created on 2 déc. 2013, 15:02:15
 */
package vue;

import controleur.Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modele.Pilote;

/**
 *
 * @author 13008360
 */
public class JChronoUneVoitureBis extends javax.swing.JFrame implements MaFenetre {
    //nos variables
    private int numV;
    private Controleur controleur;
    private boolean chronoEnRoute = false;
    private long progressMax;
    private long tempsEcoule=0;
    private Timer chrono;
    private long tempsEcouleTot = 0;
    private long h =0;
    private long m = 0;
    private long s = 0;
    private long ms=0;
    private int axeX;
    private int nbRelai =1;
    
    /** Creates new form jChronoUneVoiture */
    public JChronoUneVoitureBis(Controleur c,int num, int placeX) {
        this.numV = num;
        controleur = c;
        this.axeX = placeX;
        initComponents();
    }

    
                          
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        

        chrono = new Timer(1, new ActionListener(){
            public void actionPerformed (ActionEvent e)
            {	// Cas d'un evenement genere par le bouton
                    tempsEcoule++;
                    ms++;
                    if(ms>999){
                       ms = 0;
                        s++;
                        if(s>59){
                            m++;
                            s=0;
                            if(m>59){
                                h++;
                            }
                        }
                    }
                    jProgressBar1.setString(""+h+":"+m+":"+s+":"+ms);
                    jProgressBar1.setValue((int) tempsEcoule);
                  
            }});
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocation(axeX, 0);
        
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Voiture n°"+numV);

        jLabel2.setText("Pilote actuel : ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.implementerListePilote();
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre de tours par relais :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre de tours restant :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombre de tours effectuée :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText(Integer.toString(controleur.getNbToursMaxCourse()));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText(Integer.toString(controleur.getNbTourRelaiVoiture(numV)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button1.setBackground(new java.awt.Color(204, 0, 0));
        button1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("TOP IN");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(255, 153, 0));
        button2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button2.setLabel("TOP TOUR");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(0, 153, 0));
        button3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("TOP OUT");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        button3.setEnabled(false);

        jProgressBar1.setToolTipText("");
        jProgressBar1.setString("Temps");
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setMinimum(0);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Temps moyen par tour pour la voiture");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Temps écoulé depuis le dernier tour :");

        jProgressBar2.setString("Temps");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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

     private void button1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        if(!this.chronoEnRoute){
            //Boîte du message d'erreur
            JOptionPane jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Vous devez Démarrer la course !", "Erreur", JOptionPane.ERROR_MESSAGE); 
        }
        else{
            if(Integer.parseInt(jLabel10.getText())!=0){
                //on bloque les boutons top in et top tour car la voiture devra forcément ressostir du stand
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(true);
                //on stoppe les chrono quand la voiture est dans le stand
                //on prépare afin de relancer à la sortie du stand
                tempsEcouleTot = tempsEcouleTot + tempsEcoule;
                tempsEcoule = 0;
                chrono.stop();
                //chrono.restart();
                
                String[] ligneTable = new String[8];
                //on incrémente le nombre de tours finis
                int nbTours =Integer.parseInt(jLabel12.getText());
                nbTours++;
                jLabel12.setText(Integer.toString(nbTours));
                //on décrémente nombre de tours effectués
                int nbToursMax =Integer.parseInt(jLabel10.getText());
                nbToursMax--;
                jLabel10.setText(Integer.toString(nbToursMax));

                ligneTable[0] = Integer.toString(nbTours);//num tours
                ligneTable[1] = Integer.toString(numV);//numéro voiture
                ligneTable[2] = jComboBox2.getSelectedItem().toString();//nom - prénom du pilote
                ligneTable[3] ="";//jLabel9.getText() ;//temps
                ligneTable[4] = Integer.toString(this.nbRelai);//nb relai
                ligneTable[5] = "TOP IN";//type de top
                SimpleDateFormat formatter2 = new SimpleDateFormat ("HH:mm" );
                Date currentTime_12 = new Date();
                String heureS = formatter2.format(currentTime_12);
                ligneTable[6] = heureS;//heure systeme
                ligneTable[7] = "";

                controleur.creerUnTop(ligneTable);
                
                //on stoppera la barre de progression
                jProgressBar1.setMaximum((int) (tempsEcouleTot/nbTours));
            }
        }
    }                                       

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
         //on bloque le bouton top out tant que la voiture ne rentre pas dans le stand
                button3.setEnabled(false);
        // TODO add your handling code here:
        if(!this.chronoEnRoute){
            //Boîte du message d'erreur
            JOptionPane jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Vous devez Démarrer la course !", "Erreur", JOptionPane.ERROR_MESSAGE); 
        }
        else{
            if(Integer.parseInt(jLabel10.getText())!=0){
                tempsEcouleTot = tempsEcouleTot + tempsEcoule;
                tempsEcoule = 0;
                h=0;
                s=0;
                m=0;
                ms=0;
                chrono.restart();
                
                
                String[] ligneTable = new String[8];
                //on incrémente le nombre de tours finis
                int nbTours =Integer.parseInt(jLabel12.getText());
                nbTours++;
                jLabel12.setText(Integer.toString(nbTours));
                //on décrémente nombre de tours effectués
                int nbToursMax =Integer.parseInt(jLabel10.getText());
                nbToursMax--;
                jLabel10.setText(Integer.toString(nbToursMax));
                
                
                ligneTable[0] = Integer.toString(nbTours);//num tours
                ligneTable[1] = Integer.toString(numV);//numéro voiture
                ligneTable[2] = jComboBox2.getSelectedItem().toString();//nom - prénom du pilote
                ligneTable[3] ="";//jLabel9.getText() ;//temps
                ligneTable[4] = Integer.toString(this.nbRelai);//nb relai
                ligneTable[5] = "TOP TOUR";//type de top
                SimpleDateFormat formatter2 = new SimpleDateFormat ("HH:mm" );
                Date currentTime_12 = new Date();
                String heureS = formatter2.format(currentTime_12);
                ligneTable[6] = heureS;//heure systeme
                ligneTable[7] = "";
                
                
                //on insere la ligne dans le tableur
                controleur.creerUnTop(ligneTable);
                
                //on mettra à jour les barres de progression
                jProgressBar1.setMaximum((int) (tempsEcouleTot/nbTours));
                //jProgressBar1.
            }
        }
    }                                       

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        if(!this.chronoEnRoute){
            //Boîte du message d'erreur
            JOptionPane jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Vous devez Démarrer la course !", "Erreur", JOptionPane.ERROR_MESSAGE); 
        }
        else{
            if(Integer.parseInt(jLabel10.getText())!=0){
                 //on débloque les boutons top in et top tour car la voiture est sorti du stand et on bloque le top out car elle doit y rerentrer avant
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
                //on sort du stand donc on relance le chorono
                h=0;
                s=0;
                m=0;
                ms=0;
                tempsEcoule=0;
                chrono.restart();
                chrono.start();
                
                String[] ligneTable = new String[8];
                //on incrémente le nombre de tours finis
                int nbTours =Integer.parseInt(jLabel12.getText());
                //nbTours++;
                //jLabel12.setText(Integer.toString(nbTours));
                //on décrémente nombre de tours effectués
                /*int nbToursMax =Integer.parseInt(jLabel10.getText());
                nbToursMax--;
                jLabel10.setText(Integer.toString(nbToursMax));*/

                ligneTable[0] = Integer.toString(nbTours);//num tours
                ligneTable[1] = Integer.toString(numV);//numéro voiture
                ligneTable[2] = jComboBox2.getSelectedItem().toString();//nom - prénom du pilote
                ligneTable[3] ="";//jLabel9.getText() ;//temps
                ligneTable[4] = Integer.toString(this.nbRelai);//nb relai
                ligneTable[5] = "TOP OUT";//type de top
                SimpleDateFormat formatter2 = new SimpleDateFormat ("HH:mm" );
                Date currentTime_12 = new Date();
                String heureS = formatter2.format(currentTime_12);
                ligneTable[6] = heureS;//heure systeme
                ligneTable[7] = "";

                controleur.creerUnTop(ligneTable);
                
                //on relance les barres de progression
            }
 
        }
        
    }  
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.nbRelai++;
    }
    
    // Variables declaration - do not modify                     
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    // End of variables declaration                   


    @Override
    public void afficher() {
       this.setVisible(true);
    }

    @Override
    public void masquer() {
        this.setVisible(false);
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
    
    public void implementerListePilote(){
        jComboBox2.removeAllItems();
            List<Pilote> lesP = controleur.getPilotesVoitureCourante(numV);
            for (Pilote p  : lesP) {  
                jComboBox2.addItem(p.getNom()+" - "+p.getPrenom());
            }
    }
    
    public void setEtatChrono(){
        if(chronoEnRoute){
            chronoEnRoute = false;
            chrono.stop();
        }
        else{
            chronoEnRoute=true;
            chrono.start();
        }
    }

    
}

