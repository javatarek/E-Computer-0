/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

/**
 *
 * @author Tarikul
 */
public class ADDCompanyD extends javax.swing.JInternalFrame {
private Image img;

    /**
     * Creates new form ADDCompanyD
     */
    public ADDCompanyD() {
        initComponents();
          img =new ImageIcon(getClass().getResource("white.jpg")).getImage();
    desktop = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img,-1, -1, null);
            }
 
    };
       
    
 this.setContentPane(desktop);


        // Make dragging faster by setting drag mode to Outline
        desktop.putClientProperty("JDesktopPane.dragMode", "outline");

       // this.pack();
        this.setVisible(true);

//imagePanel1.setImage(new ImageIcon(this.getClass().getResource("com.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        updateSup = new javax.swing.JMenuItem();
        updateBr = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        deleteS = new javax.swing.JMenuItem();
        deleteB = new javax.swing.JMenuItem();

        setClosable(true);

        desktop.setBackground(new java.awt.Color(204, 204, 255));
        desktop.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jMenu1.setText("ADD");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("ADD Supplier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("ADD Brand");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("UPDATE");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        updateSup.setText("Update Supplier Info");
        updateSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSupActionPerformed(evt);
            }
        });
        jMenu2.add(updateSup);

        updateBr.setText("Update Brand Info");
        updateBr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBrActionPerformed(evt);
            }
        });
        jMenu2.add(updateBr);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("DELETE");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        deleteS.setText("Delete Supplier Info");
        deleteS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSActionPerformed(evt);
            }
        });
        jMenu3.add(deleteS);

        deleteB.setText("Delete Brand Info");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });
        jMenu3.add(deleteB);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AddCompany a=new AddCompany();
        a.setVisible(true);
        desktop.add(a);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ADDBrand b=new ADDBrand();
        b.setVisible(true);
        desktop.add(b);
                
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void updateSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSupActionPerformed
        // TODO add your handling code here:
        UpdateSupplier u=new UpdateSupplier();
        u.setVisible(true);
        desktop.add(u);
        
    }//GEN-LAST:event_updateSupActionPerformed

    private void updateBrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBrActionPerformed
        // TODO add your handling code here:
          UpdateBrand u1=new UpdateBrand();
        u1.setVisible(true);
        desktop.add(u1);
        
    }//GEN-LAST:event_updateBrActionPerformed

    private void deleteSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSActionPerformed
        // TODO add your handling code here:
         DeleteSupplier d=new DeleteSupplier();
        d.setVisible(true);
        desktop.add(d);
        
    }//GEN-LAST:event_deleteSActionPerformed

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        // TODO add your handling code here:
           DeleteBrand d1=new DeleteBrand();
        d1.setVisible(true);
        desktop.add(d1);
        
    }//GEN-LAST:event_deleteBActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        ADDBrand a=new ADDBrand();
        a.setVisible(true);
        desktop.add(a);
        
        
    }//GEN-LAST:event_jMenu1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteB;
    private javax.swing.JMenuItem deleteS;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem updateBr;
    private javax.swing.JMenuItem updateSup;
    // End of variables declaration//GEN-END:variables
}