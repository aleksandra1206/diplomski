/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.autor;

import domain.Autor;
import forme.knjiga.DodajKnjiguForma;
import javax.swing.JOptionPane;
import modeli.ModelTabeleAutori;

/**
 *
 * @author Korisnik
 */
public class DodajAutora extends javax.swing.JDialog {

    /**
     * Creates new form DodajAutora
     */
    public DodajAutora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        ModelTabeleAutori model = new ModelTabeleAutori();
        Thread thread = new Thread(model);
        thread.start();
        tblIzaberiAutora.setModel(model);
        setTitle("Dodaj autora");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIzaberiAutora = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnIzadji = new javax.swing.JButton();
        txtPretragaAutora = new javax.swing.JTextField();
        btnPrikazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblIzaberiAutora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIzaberiAutora);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pretrazite autora:");

        btnDodaj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDodaj.setText("Dodaj autora");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        txtPretragaAutora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaAutoraKeyReleased(evt);
            }
        });

        btnPrikazi.setText("Prikazi selektovanog autora");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(70, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretragaAutora, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnPrikazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzadji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretragaAutora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrikazi))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        // TODO add your handling code here:
        int row = tblIzaberiAutora.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Niste selektovali autora za dodavanje!");
            return;
        }
        ModelTabeleAutori mt = (ModelTabeleAutori) tblIzaberiAutora.getModel();
        Autor a = mt.vratiAutora(row);
        DodajKnjiguForma dkf = (DodajKnjiguForma) getParent();
        dkf.setModelAutori(a);
        
        this.dispose();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void txtPretragaAutoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaAutoraKeyReleased
        // TODO add your handling code here:
        ModelTabeleAutori mt = (ModelTabeleAutori) tblIzaberiAutora.getModel();
        String parametar = txtPretragaAutora.getText();
        mt.setParametar(parametar);
        mt.refreshTable();
        if (mt.getLista().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ne postoji autor sa tim podacima!");
        }
    }//GEN-LAST:event_txtPretragaAutoraKeyReleased

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        // TODO add your handling code here:
        int row = tblIzaberiAutora.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Niste selektovali autora za prikaz!");
            return;
        }
        
        ModelTabeleAutori mt = (ModelTabeleAutori) tblIzaberiAutora.getModel();
        
        Autor autor = mt.vratiAutora(row);
        
        new AutorForma(null, false, autor).setVisible(true);
    }//GEN-LAST:event_btnPrikaziActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIzaberiAutora;
    private javax.swing.JTextField txtPretragaAutora;
    // End of variables declaration//GEN-END:variables
}
