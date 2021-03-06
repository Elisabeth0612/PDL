/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import graphique.IntegerField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modele.Pilote;
import modele.Voiture;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class ModifierVoitureBis extends javax.swing.JFrame implements MaFenetre {

    private Controleur controleur;
    private DefaultListModel<String> model;
    private Voiture voitureCourante = null;
    private List<Pilote> lesPTemp = new ArrayList<Pilote>();

   
    /**
     * Instanciation
     * @param c Controleur
     */
    public ModifierVoitureBis(Controleur c) {
        controleur = c;
        initComponents();
    }

    /**
     * Méthode pour remplir la liste temporaire avec une autre liste de manière à éviter les problèmes de référence
     * @param depart Liste de Pilote
     */
    public void remplir(List<Pilote> depart) {
        for (Pilote p : depart) {
            lesPTemp.add(p);
        }
    }

    /**
     * Fonction permettant l'ouverture de la fenetre
     */
    public void lancer() {
        setVisible(true);
    }

    @Override
    public void afficher() {
        raffraichir();
        charger();
        //on affiche la fenetre
        setVisible(true);

    }

    @Override
    public void masquer() {
        setVisible(false);
    }

    @Override
    public void fermer() {
        vider();
        dispose();
    }

    @Override
    public void raffraichir() {
        //jPanel2.repaint();
    }

    @Override
    public MaFenetre getPrecedent() {
        return null;
    }

    @Override
    public void vider() {
        lesPTemp = new ArrayList<Pilote>();
        voitureCourante = null;
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jCheckBox1.setSelected(false);
        jList1.removeAll();
    }

    /**
     * Méthode permettant de charger les champs et la liste de la fenetre
     */
    public void charger() {

        if (voitureCourante != null) {

            int numV = voitureCourante.getNumVoiture();
            jTextField4.setText(Integer.toString(numV));
            jTextField1.repaint();

            String couleur = voitureCourante.getCouleur();
            jTextField1.setText(couleur);
            jTextField1.repaint();

            int NbToursRelai = voitureCourante.getNbToursParRelai();
            jTextField2.setText(Integer.toString(NbToursRelai));
            jTextField2.repaint();

            List<Pilote> lesP = new ArrayList<Pilote>();

            if (voitureCourante.existListP()) {
                lesP = voitureCourante.getListP();

                remplir(lesP);
                if (lesP.size() != 0) {
                    model = new DefaultListModel<String>();
                    for (Pilote p : lesP) {
                        model.addElement(p.getNom() + " " + p.getPrenom());
                    }
                    jList1.setModel(model);
                    jList1.setSelectedIndex(0);
                    jList1.repaint();
                }
            } else {
                model = new DefaultListModel<String>();
                jList1.setModel(model);
                jList1.setSelectedIndex(0);
                jList1.repaint();
            }

            Pilote p = voitureCourante.getPiloteActuel();
            if (p != null) {
                Pilote p1 = controleur.getPiloteVoiture(voitureCourante, p.getNom(), p.getPrenom());
                if (p1 != null) {
                    jTextField3.setText(p.getNom() + " " + p.getPrenom());
                    jTextField3.repaint();
                } else {
                    voitureCourante.setPiloteActuel(null);
                    jTextField3.setText("");
                    jTextField3.repaint();
                }
            }

            Boolean voitureActive = voitureCourante.getVoitureActive();
            jCheckBox1.setSelected(voitureActive);
            jCheckBox1.repaint();
        }
    }

    /**
     * Méthode permettant à partir du controleur et de la vue de donnée une valeur à la voiture courante
     * @param v
     */
    public void miseAJour(Voiture v) {
        voitureCourante = v;
    }

    /**
     * Méthode permettant d'avoir l'indice dans la liste temporaire d'un pilote
     * @param nom String
     * @param prenom String
     * @return int - indice
     */
    public int parcoursList(String nom, String prenom) {
        for (int i = 0; i < lesPTemp.size(); i++) {
            if (lesPTemp.get(i).getNom().equals(nom) && lesPTemp.get(i).getPrenom().equals(prenom)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new IntegerField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new IntegerField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Couleur du véhicule :");

        jLabel2.setText("Nombre de tours/relai :");

        jCheckBox1.setText("Voiture en course (active)");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });


        jList1.setSelectionMode(1);
        jList1.setModel(new javax.swing.AbstractListModel() {
            List<Pilote> lesP = new ArrayList<Pilote>();

            public int getSize() {
                return lesP.size();
            }

            public Object getElementAt(int i) {
                return lesP.get(i).getNom() + " " + lesP.get(i).getPrenom();
            }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);



        jLabel3.setText("Liste des pilotes pour la voiture :");

        jButton1.setText("Modifier le pilote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Supprimer le pilote");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton4.setText("Enregistrer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ajouter/Enlever un pilote");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Annuler");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero du véhicule :");

        jLabel4.setText("Pilote principal :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton5)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jCheckBox1)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addComponent(jTextField1)
                .addComponent(jTextField4)))
                .addComponent(jLabel3))
                .addContainerGap(28, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(76, 76, 76)
                .addComponent(jButton6)
                .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addContainerGap(289, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addGap(20, 20, 20))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton6)
                .addContainerGap()))));

        pack();
    }// </editor-fold>

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Checkbox "Voiture en Course (active)"  -- aucune action      
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Supprimer Pilote"
        int i = jList1.getSelectedIndex();
        if (jList1.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une voiture.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String nomPrenomPilote = (String) jList1.getSelectedValue();
            String nomPilote = nomPrenomPilote.substring(0, nomPrenomPilote.lastIndexOf(" "));
            String prenomPilote = nomPrenomPilote.substring(nomPrenomPilote.lastIndexOf(" ") + 1, nomPrenomPilote.length());

            int indice = parcoursList(nomPilote, prenomPilote);
            if (indice != -1) {
                String nomPrenomPiloteActuel = jTextField3.getText();
                String nomPiloteActuel = nomPrenomPiloteActuel.substring(0, nomPrenomPiloteActuel.lastIndexOf(" "));
                String prenomPiloteActuel = nomPrenomPiloteActuel.substring(nomPrenomPiloteActuel.lastIndexOf(" ") + 1, nomPrenomPiloteActuel.length());
                if (nomPilote.equals(nomPiloteActuel) && prenomPilote.equals(prenomPiloteActuel)) {
                    jTextField3.setText("");
                    jTextField3.repaint();
                }
                lesPTemp.remove(indice);
                model.remove(i);
                jList1.repaint();
            }
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Ajouter/Enlever Pilote"
        if (voitureCourante == null) {
            JOptionPane.showMessageDialog(this, "Vous devez enregistrer la voiture avant d'ajouter des pilotes.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            controleur.ouvrirAjouterEnleverPilote(voitureCourante);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Modifier Pilote"
        int i = jList1.getSelectedIndex();

        if (jList1.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un pilote.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String nomPrenomPilote = (String) jList1.getSelectedValue();
            String nomPilote = nomPrenomPilote.substring(0, nomPrenomPilote.lastIndexOf(" "));
            String prenomPilote = nomPrenomPilote.substring(nomPrenomPilote.lastIndexOf(" ") + 1, nomPrenomPilote.length());
            Pilote p = controleur.getPiloteVoiture(voitureCourante, nomPilote, prenomPilote);
            controleur.ouvrirModifierPilote(voitureCourante, p);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton ">>" "Pilote actuel" -- jList1 = Liste des pilotes de la voiture
        int i = jList1.getSelectedIndex();
        if (jList1.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une voiture.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String nomPrenomPilote = (String) jList1.getSelectedValue();
            String nomPilote = nomPrenomPilote.substring(0, nomPrenomPilote.lastIndexOf(" "));
            String prenomPilote = nomPrenomPilote.substring(nomPrenomPilote.lastIndexOf(" ") + 1, nomPrenomPilote.length());

            jTextField3.setText(nomPilote + " " + prenomPilote);
            jTextField3.repaint();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Enregistrer"
        if (voitureCourante == null) {
            JOptionPane.showMessageDialog(this, "Erreur...", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            voitureCourante.setListP(lesPTemp);

            String nomPrenomPilote = jTextField3.getText();
            if (!nomPrenomPilote.equals("")) {
                String nomPilote = nomPrenomPilote.substring(0, nomPrenomPilote.lastIndexOf(" "));
                String prenomPilote = nomPrenomPilote.substring(nomPrenomPilote.lastIndexOf(" ") + 1, nomPrenomPilote.length());
                Pilote p = controleur.getPiloteVoiture(voitureCourante, nomPilote, prenomPilote);

                if (jTextField4.getText().equals("") && jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    voitureCourante.setCouleur(jTextField1.getText());
                    voitureCourante.setNbToursParRelai(Integer.parseInt(jTextField2.getText()));
                    voitureCourante.setVoitureActive(jCheckBox1.isSelected());
                    voitureCourante.setPiloteActuel(p);
                    controleur.modifierVoitureExistante(voitureCourante);
                    controleur.retour();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez choisir un pilote actuel.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Annuler"
        vider();
        controleur.retour();
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private IntegerField jTextField2;
    private javax.swing.JTextField jTextField3;
    private IntegerField jTextField4;
    // End of variables declaration
}
