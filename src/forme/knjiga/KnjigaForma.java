/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.knjiga;

import forme.clan.*;
import controller.ClientController;
import domain.Clan;
import domain.Knjiga;
import forme.MainForm;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class KnjigaForma extends javax.swing.JDialog {
    Knjiga knjiga;

    /**
     * Creates new form ClanForma
     */
    public KnjigaForma(java.awt.Frame parent, boolean modal, Knjiga knjiga) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        txtKnjigaID.setText(String.valueOf(knjiga.getKnjigaID()));
        txtNaziv.setText(knjiga.getNaziv());
        txtProsecnaOcena.setText(String.valueOf(knjiga.getProsecnaOcena()));
        txtKnjigaID.setEditable(false);
        txtProsecnaOcena.setEditable(false);
        this.knjiga = knjiga;
        setTitle("Knjiga - " + knjiga.getNaziv());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKnjigaID = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtProsecnaOcena = new javax.swing.JFormattedTextField();
        btnIzmeni = new javax.swing.JButton();
        btnIzadji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("KnjigaID:");

        jLabel2.setText("Naziv knjige:");

        jLabel4.setText("Prosecna ocena:");

        txtProsecnaOcena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtProsecnaOcena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProsecnaOcenaActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni knjigu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzadji.setText("Izadji");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtKnjigaID, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIzmeni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProsecnaOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIzadji)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKnjigaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProsecnaOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIzmeni)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int opcija = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da izmenite knjigu?", 
                                                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (opcija == JOptionPane.NO_OPTION) {
            return;
        } else if (opcija == JOptionPane.YES_OPTION) {
            if (txtKnjigaID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Naziv knjige moraj biti popunjen!");
                return;
            }

            String naziv = txtNaziv.getText();
            
            knjiga.setNaziv(naziv);

            try {
                ClientController.getInstance().updateKnjiga(knjiga);
                MainForm mf = (MainForm) getParent();
                mf.refresujKnjige();
                JOptionPane.showMessageDialog(this, "Uspesno izmenjena knjiga!");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            }
        

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void txtProsecnaOcenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProsecnaOcenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProsecnaOcenaActionPerformed

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKnjigaID;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JFormattedTextField txtProsecnaOcena;
    // End of variables declaration//GEN-END:variables
}