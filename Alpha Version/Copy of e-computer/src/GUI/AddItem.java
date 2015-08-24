/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import database.DbConn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tarikul
 */
public class AddItem extends javax.swing.JInternalFrame {

    
      Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    /**
     * Creates new form AddItem
     */
    public AddItem() {
        initComponents();
     con=DbConn.dbConnection();
     
      getData();
       itemName.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      supplierNa.requestFocusInWindow();    
    }
}); 
       supplierNa.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      brandCompany.requestFocusInWindow();    
    }
}); 
       brandCompany.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      openSto.requestFocusInWindow();    
    }
}); 
        openSto.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      purchaseR.requestFocusInWindow();    
    }
}); 
       purchaseR.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      sellR.requestFocusInWindow();    
    }
}); 
          sellR.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      warranty.requestFocusInWindow();    
    }
}); 
      
       warranty.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      reOrder.requestFocusInWindow();    
    }
}); 
         reOrder.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      itemCombo.requestFocusInWindow();    
    }
}); 
      
      
     
      loadCombo();
         loadCombo1();
         loadCombo2();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemCombo = new javax.swing.JComboBox();
        itemcode = new javax.swing.JTextField();
        itemName = new javax.swing.JTextField();
        supplierNa = new javax.swing.JComboBox();
        brandCompany = new javax.swing.JComboBox();
        openSto = new javax.swing.JTextField();
        purchaseR = new javax.swing.JTextField();
        sellR = new javax.swing.JTextField();
        warranty = new javax.swing.JTextField();
        reOrder = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setClosable(true);

        jLabel4.setText("Item Category:");

        jLabel2.setText("Item Code");

        jLabel3.setText("Item Name:");

        jLabel10.setText("Supplier Name:");

        jLabel11.setText("Brand Company:");

        jLabel5.setText("Opening Stock :");

        jLabel6.setText("Purchase Rate:");

        jLabel7.setText("Selling Rate:");

        jLabel8.setText("Warranty:");

        jLabel9.setText("Re-order Notification");

        itemcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemcodeKeyPressed(evt);
            }
        });

        openSto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                openStoKeyTyped(evt);
            }
        });

        purchaseR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                purchaseRKeyTyped(evt);
            }
        });

        sellR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sellRKeyTyped(evt);
            }
        });

        reOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reOrderKeyTyped(evt);
            }
        });

        jLabel12.setText("Search");

        Save.setText("Add");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cancel.setText("Clear");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Get Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openSto)
                    .addComponent(brandCompany, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemcode)
                    .addComponent(itemName)
                    .addComponent(supplierNa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseR)
                    .addComponent(sellR)
                    .addComponent(warranty)
                    .addComponent(reOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierNa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openSto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellR, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warranty, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Save)
                        .addComponent(cancel))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(jButton1)
                        .addComponent(jButton4)))
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Item");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        String sql="Insert into item(item_name,item_category,item_code,selling_rate,purchase_rate,warranty,supplier_name,opening_stock,re_order,brand_company)values(?,?,?,?,?,?,?,?,?,?) ";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, itemName.getText());
            ps.setString(2, itemCombo.getSelectedItem().toString());
            ps.setString(3, itemcode.getText());

            ps.setString(4, sellR.getText());
            ps.setString(5, purchaseR.getText());
            ps.setString(6, warranty.getText());
            ps.setString(7, supplierNa.getSelectedItem().toString());
            ps.setString(8,openSto.getText());
            ps.setString(9,reOrder.getText());
            ps.setString(10,brandCompany.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Added Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data not Added ");
        }
        
        try {
            ps=con.prepareStatement("insert into stock(total_stock,item_category,item_code,item_name,warranty,brand_company,selling_rate,purchase_rate,company_name) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, openSto.getText());
             ps.setString(2, itemCombo.getSelectedItem().toString());
             ps.setString(3, itemcode.getText());
             ps.setString(4, itemName.getText());
              ps.setString(5, warranty.getText());
               ps.setString(6, brandCompany.getSelectedItem().toString());
                 ps.setString(7, sellR.getText());
                  ps.setString(8, purchaseR.getText());
                   ps.setString(9, supplierNa.getSelectedItem().toString());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
        getData();

    }//GEN-LAST:event_SaveActionPerformed

    public void getData(){
         String sql="select item_category as 'ItemCate',item_code as 'ItCode',item_name as 'ItName',supplier_name as 'SuppName',brand_company as 'BrandName',opening_stock as 'OppStock',purchase_rate as 'PurRate',selling_rate as 'SellRate',warranty as 'Warr',re_order as 'ReOrder' from item ";  
         try{
          
         ps=con.prepareStatement(sql);
         
          rs= ps.executeQuery();
         Table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        itemCombo.setSelectedItem("");
        itemcode.setText("");
        itemName.setText("");
        supplierNa.setSelectedItem("");
        brandCompany.setSelectedItem("");
        openSto.setText("");
        purchaseR.setText("");
        sellR.setText("");
        warranty.setText("");
        reOrder.setText("");
        
        
    }//GEN-LAST:event_cancelActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         if (itemcode.getText().length()==0) {
               JOptionPane.showMessageDialog( this, "Please Input  Item Code","Error", JOptionPane.ERROR_MESSAGE);
                itemcode.requestFocus();
                return;

            }
        
        
        String sql="delete from item where item_code=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, itemcode.getText());
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data Delete  Successfully");
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Data not  Delete");
        }
        
           String sqll="delete from stock where item_code=?";
        try {
            ps=con.prepareStatement(sqll);
            ps.setString(1, itemcode.getText());
            ps.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Data Delete  Successfully");
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Data not  Delete");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void itemcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemcodeKeyPressed
        // TODO add your handling code here:
         int kCode=evt.getKeyCode();
        if(kCode==10)
        {
                    String it=itemcode.getText();
                    String sql="select * from item where item_code = ?";
                    
                     try {
                         ps=con.prepareStatement(sql);
                         ps.setString(1, it);
                         rs=ps.executeQuery();
                         if(rs.next())
                         {
                             itemCombo.setSelectedItem(rs.getString("item_category"));
                              itemcode.setText(rs.getString("item_code"));
                             itemName.setText(rs.getString("item_name"));
                             supplierNa.setSelectedItem(rs.getString("supplier_name"));
                               brandCompany.setSelectedItem(rs.getString("brand_company"));
                             openSto.setText(rs.getString("opening_stock"));
                              purchaseR.setText(rs.getString("purchase_rate"));
                             
                             sellR.setText(rs.getString("selling_rate"));
                             
                             warranty.setText(rs.getString("warranty"));  
                             reOrder.setText(rs.getString("re_order"));
                             
                         }else
                         {
                             JOptionPane.showMessageDialog(null, "Item not found!");
                             itemcode.setCursor(null);
                         }

                     } catch (Exception e) {
                     }
        }
        
        
    }//GEN-LAST:event_itemcodeKeyPressed

   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
        ItemTable i=new ItemTable();
        i.setVisible(true);
        i.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void openStoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openStoKeyTyped
          char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_openStoKeyTyped

    private void purchaseRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseRKeyTyped
        char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_purchaseRKeyTyped

    private void sellRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellRKeyTyped
       char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_sellRKeyTyped

    private void reOrderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reOrderKeyTyped
         char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_reOrderKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
         if (itemcode.getText().length()==0) {
               JOptionPane.showMessageDialog( this, "Please Input  Item Code","Error", JOptionPane.ERROR_MESSAGE);
                itemcode.requestFocus();
                return;

            }
        
        
        String sql="update item set item_name=?,item_category=?,selling_rate=?,purchase_rate=?,warranty=?,supplier_name=?,opening_stock=?,re_order=?,brand_company=?  where item_code=?";
        try {
             ps=con.prepareStatement(sql);
        ps.setString(1,itemName.getText());
         ps.setString(2,itemCombo.getSelectedItem().toString());
         
          ps.setString(3,sellR.getText());
          ps.setString(4,purchaseR.getText());
          ps.setString(5,warranty.getText());
           ps.setString(6,supplierNa.getSelectedItem().toString());
            ps.setString(7,openSto.getText());
           ps.setString(8, reOrder.getText());
            ps.setString(9,brandCompany.getSelectedItem().toString());
             ps.setString(10,itemcode.getText());
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
         String sqll="update stock set total_stock=?,item_category=?,item_name=?,warranty=?,brand_company=?,selling_rate=?,purchase_rate=?,company_name=?  where item_code=?";
        try {
             ps=con.prepareStatement(sqll);
        ps.setString(1, openSto.getText());
             ps.setString(2, itemCombo.getSelectedItem().toString());
            
             ps.setString(3, itemName.getText());
              ps.setString(4, warranty.getText());
               ps.setString(5, brandCompany.getSelectedItem().toString());
                 ps.setString(6, sellR.getText());
                  ps.setString(7, purchaseR.getText());
                   ps.setString(8, supplierNa.getSelectedItem().toString());
                    ps.setString(9, itemcode.getText());
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
          try{
              ResultSet rs2;
            PreparedStatement ps2;
            Connection con;
             
             
            con=DbConn.dbConnection();
            int row=Table.getSelectedRow();
            String table_click=Table.getModel().getValueAt(row, 1).toString();
              
            String sql= "select item_name,item_category,item_code,selling_rate,purchase_rate,warranty,supplier_name,opening_stock,re_order,brand_company from item where item_code like '" + table_click + "'";
            ps2=con.prepareStatement(sql);
            rs2=  ps2.executeQuery();
            if(rs2.next()){
                String add1=rs2.getString("item_name");
                itemName.setText(add1);
                String add2=rs2.getString("item_category");
                itemCombo.setSelectedItem(add2);
                String add3=rs2.getString("item_code");
                itemcode.setText(add3);
                String add4=rs2.getString("selling_rate");
                sellR.setText(add4);
                 String add5=rs2.getString("purchase_rate");
                purchaseR.setText(add5);
                  String add6=rs2.getString("warranty");
                 warranty.setText(add6);
                 String add7=rs2.getString("supplier_name");
                supplierNa.setSelectedItem(add7);
                String add8=rs2.getString("opening_stock");
                openSto.setText(add8);
                 String add9=rs2.getString("re_order");
                 reOrder.setText(add9);
                 String add10=rs2.getString("brand_company");
                 brandCompany.setSelectedItem(add10);
               
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JTable Table;
    private javax.swing.JComboBox brandCompany;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox itemCombo;
    private javax.swing.JTextField itemName;
    private javax.swing.JTextField itemcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField openSto;
    private javax.swing.JTextField purchaseR;
    private javax.swing.JTextField reOrder;
    private javax.swing.JTextField sellR;
    private javax.swing.JComboBox supplierNa;
    private javax.swing.JTextField warranty;
    // End of variables declaration//GEN-END:variables


    public void loadCombo(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(company_name) from company order by company_name");
            while(rs.next()){
            plist.add(rs.getString("company_name"));
             
            
            }
            supplierNa.setModel(new DefaultComboBoxModel(plist.toArray()));
            supplierNa.insertItemAt("Select Company",0);
            supplierNa.setSelectedIndex(0);
            
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }

    }
    
    public void loadCombo2(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(brand_name) from brand order by brand_name");
            while(rs.next()){
            plist.add(rs.getString("brand_name"));
             
            
            }
            brandCompany.setModel(new DefaultComboBoxModel(plist.toArray()));
            brandCompany.insertItemAt("Select Brand",0);
            brandCompany.setSelectedIndex(0);
            
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }

    }
     public void loadCombo1(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(category_name) from category order by category_name");
            while(rs.next()){
            plist.add(rs.getString("category_name"));
             
            
            }
            itemCombo.setModel(new DefaultComboBoxModel(plist.toArray()));
            itemCombo.insertItemAt("Select Category",0);
             itemCombo.setSelectedIndex(0);
            
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }

    }

}