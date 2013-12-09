/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modele.Voiture;

/**
 *
 * @author Co
 */
public class AjouterEnleverVoitureBis extends javax.swing.JFrame implements MaFenetre {

    private Controleur controleur;
    private DefaultListModel<String> model1;
    private DefaultListModel<String> model2;
    private List<Voiture> lesVtemp = new ArrayList<Voiture>();

    /**
     * Creates new form AjouterEnleverVoiture
     */
    public AjouterEnleverVoitureBis(Controleur c) {
        controleur = c;
        initComponents();
        lesVtemp = controleur.getVoituresEvenement();
    }

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
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public int parcoursList(int numV) {
        for (int i = 0; i < lesVtemp.size(); i++) {
            if (lesVtemp.get(i).getNumVoiture() == numV) {
                return i;
            }
        }
        return -1;
    }

    public void charger() {
        List<Voiture> lesV = controleur.getListVoituresExistantes();
        if (lesV.size() != 0) {
            model1 = new DefaultListModel<String>();
            for (Voiture v : lesV) {
                model1.addElement(Integer.toString(v.getNumVoiture()));
            }
            jList1.setModel(model1);
            jList1.setSelectedIndex(0);
            jList1.repaint();
        }

        List<Voiture> lesVE = controleur.getVoituresEvenement();
        if (lesVE.size() != 0) {
            model2 = new DefaultListModel<String>();
            for (Voiture v : lesVE) {
                model2.addElement(Integer.toString(v.getNumVoiture()));
            }
            jList2.setModel(model2);
            jList2.setSelectedIndex(0);
            jList2.repaint();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setSelectionMode(1);
        jList1.setModel(new javax.swing.AbstractListModel() {
            List<Voiture> lesV = new ArrayList<Voiture>();

            public int getSize() {
                return lesV.size();
            }

            public Object getElementAt(int i) {
                return lesV.get(i).getNumVoiture();
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setSelectionMode(1);
        jList2.setModel(new javax.swing.AbstractListModel() {
            List<Voiture> lesVE = new ArrayList<Voiture>();

            public int getSize() {
                return lesVE.size();
            }

            public Object getElementAt(int i) {
                return lesVE.get(i).getNumVoiture();
            }
        });

        jScrollPane2.setViewportView(jList2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Voitures existantes : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Voitures participant à l'évènement :");

        jButton1.setText("Créer une nouvelle voiture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setText("Valider la liste des participants");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Annuler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("<<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton5)
                .addComponent(jButton4))))
                .addContainerGap(237, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 168, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(136, 136, 136))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane2)
                .addComponent(jLabel2)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 434, Short.MAX_VALUE)
                .addComponent(jButton3)))
                .addContainerGap())));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(42, 42, 42))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Annuler"
        controleur.retour();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton ">>" - ajoute VoituresExistantes jList1 à VoituresEvenements Jlist2
        int numV = Integer.valueOf((String) jList1.getSelectedValue());
        if (jList1.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une voiture.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            if (controleur.getVoitureEvenementByNum(numV) != null) {
                JOptionPane.showMessageDialog(this, "La voiture est déjà présente dans l'Evenement.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                Voiture vE = controleur.getVoitureExistante(numV);
                lesVtemp.add(vE);
                model2.addElement(Integer.toString(vE.getNumVoiture()));
                jList2.repaint();
            }
        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "<<" - ajoute VoituresEvenements jList2 à VoituresExistantes JList1
        int numV = Integer.valueOf((String) jList2.getSelectedValue());
        int i = jList2.getSelectedIndex();
        if (jList2.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une voiture.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            int indice = parcoursList(numV);
            if (indice != -1) {
                lesVtemp.remove(indice);
                model2.remove(i);
                jList2.repaint();
            }
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Créer une nouvelle voiture"
        controleur.ouvrirCreerModifierVoiture(null);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Bouton "Valider la liste des participants"
        controleur.setListEvenement(lesVtemp);
        controleur.retour();
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration
}
