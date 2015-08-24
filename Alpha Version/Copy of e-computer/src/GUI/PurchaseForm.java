/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import database.DbConn;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tarikul
 */
public class PurchaseForm extends javax.swing.JInternalFrame {

    
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    /**
     * Creates new form PurchaseForm
     */
  
     
    public PurchaseForm() {
         con=DbConn.dbConnection();
        initComponents();
        imagePanel1.setImage(new ImageIcon(this.getClass().getResource("page.png")).getImage());
        loadCombo();
        loadCombo1();
        loadCombo2();
          loadCombo3();
       getData();
        DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
        Date dat=new Date();
        date.setText(dt.format(dat));
        
//        
//        vendorcombo.addActionListener(new ActionListener() {
//   @Override
//    public void actionPerformed(ActionEvent e) {
//      mobT.requestFocusInWindow();    
//    }
//}); 
//         mobT.addActionListener(new ActionListener() {
//   @Override
//    public void actionPerformed(ActionEvent e) {
//      ADD.requestFocusInWindow();    
//    }
////});
//           ADD.addActionListener(new ActionListener() {
//   @Override
//    public void actionPerformed(ActionEvent e) {
//      invo.requestFocusInWindow();    
//    }
//});
           
             invo.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      itemN.requestFocusInWindow();    
    }
});
         
         itemN.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      quanTF.requestFocusInWindow();    
    }
});
         
    quanTF.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      puR.requestFocusInWindow();    
    }
});      
 
  puR.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      sellR.requestFocusInWindow();    
    }
});      
 
  sellR.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      comS.requestFocusInWindow();    
    }
});      
 
  comS.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      paidT.requestFocusInWindow();    
    }
});      
 
   try {
            String sq="select count(*) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("count(*)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tinvoice.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
     
       try {
            String sq="select sum(grand_total) from e_computer.purchase_invoice  where date=?";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(grand_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpurchase.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  
        try {
            String sq="select sum(commission_deduction) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(2, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(commission_deduction)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tcommission.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
       
                try {
            String sq="select sum(paid) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(2, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(paid)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpaid.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                  try {
            String sq="select sum(bill_balance) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(bill_balance)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tbalance.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel1 = new GUI.ImagePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mobT = new javax.swing.JTextField();
        vendorcombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        StockBTN = new javax.swing.JLabel();
        stockT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SubT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        quanTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sellR = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        itemcode = new javax.swing.JTextField();
        itemN = new javax.swing.JComboBox();
        itemCa = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        puR = new javax.swing.JTextField();
        AddBTN = new javax.swing.JButton();
        warr = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        paidT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BillB = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        subTotalSum = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comS = new javax.swing.JTextField();
        ComDS = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        GrT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ADD = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        invo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        SaveBTN = new javax.swing.JButton();
        UpdateBTN = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        date = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        brandCombo = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        tinvoice = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tpurchase = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tcommission = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tpaid = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tbalance = new javax.swing.JTextField();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1185, 634));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase Form");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Address:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Mobile No:");

        mobT.setEditable(false);
        mobT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobTKeyReleased(evt);
            }
        });

        vendorcombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                vendorcomboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        vendorcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorcomboActionPerformed(evt);
            }
        });
        vendorcombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vendorcomboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vendorcomboKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Vendor Name:");

        jPanel1.setBackground(new java.awt.Color(182, 195, 191));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Item Code:");

        StockBTN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StockBTN.setText("Stock:");
        StockBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockBTNMouseClicked(evt);
            }
        });

        stockT.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Item Category:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Item Name:");

        SubT.setEditable(false);
        SubT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubTActionPerformed(evt);
            }
        });
        SubT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SubTKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Purchase Rate:");

        quanTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quanTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quanTFKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Quantity:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Selling Rate:");

        sellR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellRActionPerformed(evt);
            }
        });
        sellR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sellRKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Warranty:");

        itemcode.setEditable(false);
        itemcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemcodeKeyReleased(evt);
            }
        });

        itemN.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                itemNPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        itemN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNActionPerformed(evt);
            }
        });

        itemCa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                itemCaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        itemCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCaActionPerformed(evt);
            }
        });

        jLabel7.setText("Sub-Total:");

        puR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puRActionPerformed(evt);
            }
        });
        puR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                puRKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                puRKeyTyped(evt);
            }
        });

        AddBTN.setBackground(new java.awt.Color(102, 255, 255));
        AddBTN.setText("ADD TO Cart");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });

        warr.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sellR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(StockBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quanTF)
                            .addComponent(warr, 0, 213, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SubT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(puR)
                                .addComponent(itemN, 0, 180, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AddBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(itemcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(StockBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                    .addComponent(SubT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AddBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sellR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(itemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(itemN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(puR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(warr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel9.setText("Paid");

        paidT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidTActionPerformed(evt);
            }
        });
        paidT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidTKeyReleased(evt);
            }
        });

        jLabel10.setText("Bill Balance");

        BillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillBActionPerformed(evt);
            }
        });
        BillB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BillBKeyReleased(evt);
            }
        });

        jLabel18.setText("Total:");

        jLabel21.setText("Commission:");

        comS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comSKeyReleased(evt);
            }
        });

        jLabel22.setText("%");

        jLabel23.setText("Grand Total:");

        GrT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrTActionPerformed(evt);
            }
        });
        GrT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GrTKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTotalSum)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComDS, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paidT)
                            .addComponent(BillB)
                            .addComponent(GrT))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paidT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BillB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel11.setText("Date:");

        ADD.setEditable(false);

        jLabel12.setText("Invoice No:");

        invo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invoKeyTyped(evt);
            }
        });

        SaveBTN.setText("Purchase");
        SaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBTNActionPerformed(evt);
            }
        });

        UpdateBTN.setText("Update");
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(UpdateBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(java.awt.Color.magenta);
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        date.setEditable(false);

        tableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableP);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Brand Name:");

        brandCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandComboActionPerformed(evt);
            }
        });
        brandCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brandComboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brandComboKeyTyped(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/purchase.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel26.setBackground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("Total Invoice");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tinvoice.setEditable(false);

        jLabel25.setBackground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Total Purchase");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tpurchase.setEditable(false);

        jLabel24.setBackground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Total Commission");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tcommission.setEditable(false);

        jLabel19.setBackground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Total Paid");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tpaid.setEditable(false);

        jLabel27.setBackground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("Total Balance");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tbalance.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tinvoice)
                    .addComponent(tpurchase)
                    .addComponent(tcommission)
                    .addComponent(tpaid)
                    .addComponent(tbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcommission, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(imagePanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(imagePanel1Layout.createSequentialGroup()
                                        .addComponent(vendorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(brandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(451, 451, 451))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(imagePanel1Layout.createSequentialGroup()
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vendorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mobT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(invo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vendorcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorcomboActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_vendorcomboActionPerformed

    private void vendorcomboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vendorcomboKeyReleased

      

    }//GEN-LAST:event_vendorcomboKeyReleased

    private void vendorcomboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vendorcomboKeyTyped
         

    }//GEN-LAST:event_vendorcomboKeyTyped

    private void StockBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockBTNMouseClicked
        // TODO add your handling code here:
        try{
            ps=con.prepareStatement("Select stock,item_code From purchase Where item_name=?");
            ps.setString(1,itemN.getSelectedItem().toString());
            rs=ps.executeQuery();
            while(rs.next()){
                stockT.setText(rs.getString("stock"));
                itemcode.setText(rs.getString("item_code"));
                //            inStoTF.setText(rs.getString("stock"));
                //            x=Integer.parseInt(rs.getString("stock"));
                //            dbl=Double.valueOf(rs.getString("unit_Price"));
                //            stk=new Stock(x,dbl);
                //            //System.out.println(dbl);
            }
            // inStoTF.setText(String.valueOf(stk.getStock()));
        }catch(Exception e){System.out.println("Exception!!! Lookup in your Inventory");
        }

    }//GEN-LAST:event_StockBTNMouseClicked

    private void itemNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNActionPerformed
      
        
    }//GEN-LAST:event_itemNActionPerformed

    private void SubTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubTActionPerformed

    private void sellRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellRActionPerformed

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
               if (itemN.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Item","Error", JOptionPane.ERROR_MESSAGE);
               itemN.requestFocus();
                return;

            }
       
                if (vendorcombo.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Vendore Name","Error", JOptionPane.ERROR_MESSAGE);
               vendorcombo.requestFocus();
                return;

            }
                 if (ADD.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please Select Vendor then get Address","Error", JOptionPane.ERROR_MESSAGE);
                ADD.requestFocus();
                return;

            }
                
                if (invo.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Invoice No","Error", JOptionPane.ERROR_MESSAGE);
                invo.requestFocus();
                return;

            }
                   if (quanTF.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Quantity","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
                    if (puR.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Purchase Rate","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
           if (sellR.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Sale Rate","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
           
               
       
        String sql="insert into purchase_tem(vendor_name,brand_name,date,mobile_no,address,invoice_no,item_code,item_category,item_name,stock,quantity,purchase_rate,selling_rate,warranty,sub_total)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, vendorcombo.getSelectedItem().toString());
            ps.setString(2, brandCombo.getSelectedItem().toString());
            ps.setString(3, date.getText());
            ps.setString(4, mobT.getText());
            ps.setString(5, ADD.getText());
            ps.setString(6, invo.getText());
            ps.setString(7, itemcode.getText());
            ps.setString(8, itemCa.getSelectedItem().toString());
            ps.setString(9, itemN.getSelectedItem().toString());
            ps.setString(10, stockT.getText());
            ps.setString(11, quanTF.getText());
            ps.setString(12, puR.getText());
            ps.setString(13, sellR.getText());
            ps.setString(14, warr.getSelectedItem().toString());
            ps.setString(15, SubT.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add To Card OK");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data Not Add");
        }
    
          String sqll="insert into purchase_sub(vendor_name,brand_name,date,mobile_no,address,invoice_no,item_code,item_category,item_name,stock,quantity,purchase_rate,selling_rate,warranty,sub_total)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sqll);
            ps.setString(1, vendorcombo.getSelectedItem().toString());
            ps.setString(2, brandCombo.getSelectedItem().toString());
            ps.setString(3, date.getText());
            ps.setString(4, mobT.getText());
            ps.setString(5, ADD.getText());
            ps.setString(6, invo.getText());
            ps.setString(7, itemcode.getText());
            ps.setString(8, itemCa.getSelectedItem().toString());
            ps.setString(9, itemN.getSelectedItem().toString());
            ps.setString(10, stockT.getText());
            ps.setString(11, quanTF.getText());
            ps.setString(12, puR.getText());
            ps.setString(13, sellR.getText());
            ps.setString(14, warr.getSelectedItem().toString());
            ps.setString(15, SubT.getText());
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data Not Inserted");
        }
        
         try {
            String sqli="select purchase_rate,item_code from item where item_code=?";
             ps=con.prepareStatement(sqli);
             ps.setString(1, itemcode.getText());
             rs=ps.executeQuery();
             rs.next();
             
             Double pr=rs.getDouble("purchase_rate");
               // System.out.println(pr);
             
            
             String sqlii="select total_stock from stock where item_code=?";
             ps=con.prepareStatement(sqlii);
             ps.setString(1, itemcode.getText());
             rs=ps.executeQuery();
             rs.next();
             Double st=rs.getDouble("total_stock"); 
             Double old_total_price=st*pr;
             
            Double pq=Double.parseDouble(quanTF.getText());
              //Double prate=Double.parseDouble( puR.getText());
            Double pt=Double.parseDouble(SubT.getText());
            Double total_purchase_price=pt+old_total_price;
            Double total_qnty=pq+st;
            Double new_pur_rate= total_purchase_price/total_qnty; 
            DecimalFormat ff=new DecimalFormat("##.00");
            String new_pur=ff.format(new_pur_rate);
            
            String sql_up="update item set purchase_rate=? where item_code=?";
            ps=con.prepareStatement(sql_up);
            ps.setString(1, new_pur);
            ps.setString(2, itemcode.getText());
            ps.executeUpdate();
                    
                     
        } catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
        }
         
           try {
            String sq="select sum(sub_total) from purchase_tem where invoice_no=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, invo.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(sub_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                subTotalSum.setText(s);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
           getData();
//         DefaultTableModel model=(DefaultTableModel)tableP.getModel();
//         model.addRow(new Object[]{invo.getText(),itemCa.getSelectedItem().toString(),itemcode.getText(),itemN.getSelectedItem().toString(),quanTF.getText(),puR.getText(),SubT.getText()});
//       
//         
       
//         try{
//
//            int a=Integer.parseInt(stockT.getText());
//            int b=Integer.parseInt(quanTF.getText());
//            int p=a+b;
//            String q=String.valueOf(p);
//            stockT.setText(q);
//
//            ps=con.prepareStatement("update stock set total_stock=? where  item_code=?");
//            ps.setString(1,stockT.getText());
//            ps.setString(2,itemcode.getText());
//            ps.executeUpdate();
//
//        }catch(Exception e){
//            System.out.println("Exception!!! It may be your total_stock field id empty"
//                +"   INPUT A VALID VALUE!!!");
//        }
//        
       

    }//GEN-LAST:event_AddBTNActionPerformed

    public void getData(){
         String sql="select id as 'ID', invoice_no as 'Invo', item_category as 'Item Category',item_code as 'Item Code',item_name as 'Item Name',stock as Stock ,quantity as 'Quantity',purchase_rate as 'Unit Price',sub_total as 'Sub Total' from purchase_tem   where invoice_no=?";  
         try{
          
         ps=con.prepareStatement(sql);
         ps.setString(1,invo.getText());
          rs= ps.executeQuery();
         tableP.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
    
    private void puRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puRActionPerformed

    private void paidTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidTActionPerformed

    private void BillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillBActionPerformed

    private void SaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBTNActionPerformed
        
         if (itemN.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Item","Error", JOptionPane.ERROR_MESSAGE);
               itemN.requestFocus();
                return;

            }
       
                if (vendorcombo.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Vendore Name","Error", JOptionPane.ERROR_MESSAGE);
               vendorcombo.requestFocus();
                return;

            }
                 if (ADD.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please Select Vendor Name then get Address","Error", JOptionPane.ERROR_MESSAGE);
                ADD.requestFocus();
                return;

            }
                if (invo.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Invoice No","Error", JOptionPane.ERROR_MESSAGE);
                invo.requestFocus();
                return;

            }
                   if (quanTF.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Quantity","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
                    if (puR.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Purchase Rate","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
           if (sellR.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Sale Rate","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
           
         if (comS.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Zero(0) in commission field","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
                  if (paidT.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Zero(0) in paid field","Error", JOptionPane.ERROR_MESSAGE);
                quanTF.requestFocus();
                return;

            } 
              
        cancel.setEnabled(false);
        UpdateBTN.setEnabled(false);
        String sql="insert into purchase_invoice(company_name,brand_name,date,mobile_no,address,invoice_no,item_category,item_name,stock,quantity,purchase_rate,selling_rate,warranty,total,commission,grand_total,paid,bill_balance,commission_deduction,item_code)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, vendorcombo.getSelectedItem().toString());
            ps.setString(2, brandCombo.getSelectedItem().toString());
            ps.setString(3, date.getText());
            ps.setString(4, mobT.getText());
            ps.setString(5, ADD.getText());
            ps.setString(6, invo.getText());
           
            ps.setString(7, itemCa.getSelectedItem().toString());
            ps.setString(8, itemN.getSelectedItem().toString());
            ps.setString(9, stockT.getText());
            ps.setString(10, quanTF.getText());
            ps.setString(11, puR.getText());
            ps.setString(12, sellR.getText());
            ps.setString(13, warr.getSelectedItem().toString());
             ps.setString(14, subTotalSum.getText());
              ps.setString(15, comS.getText());
                ps.setString(16, GrT.getText());
                  ps.setString(17, paidT.getText());
                    ps.setString(18, BillB.getText());
                     ps.setString(19, ComDS.getText());
                     ps.setString(20, itemcode.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Added Successfully");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data Not Add");
              return;
        }
        
        String sqll="update company set balance=balance+"+BillB.getText()+" where company_name=?";
        
        try {
            ps=con.prepareStatement(sqll);
            
            ps.setString(1, vendorcombo.getSelectedItem().toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
          try {
            String sq="select count(*) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
          ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("count(*)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tinvoice.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
            try {
            String sq="select sum(grand_total) from e_computer.purchase_invoice where date=?  ";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(grand_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpurchase.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     
             
             try {
            String sq="select sum(commission_deduction) from e_computer.purchase_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(commission_deduction)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tcommission.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
             try {
            String sq="select sum(paid) from e_computer.purchase_invoice where date=?  ";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(paid)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpaid.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
             
             
                try {
            String sq="select sum(bill_balance) from e_computer.purchase_invoice  where date=?";
            ps=con.prepareStatement(sq);
           ps.setString(1, date.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(bill_balance)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tbalance.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
              //Purchase code
                
                
                try{

            
            String str="select * from purchase_tem where invoice_no = ?";
            ps=con.prepareStatement(str);
            ps.setString(1, invo.getText());
            ResultSet rs2;
            rs2=ps.executeQuery();
            while(rs2.next())
            {
                PreparedStatement ps2;
                String item_code=rs2.getString("item_code");
                Integer qnty=rs2.getInt("quantity");
                ps2=con.prepareStatement("update stock set total_stock=total_stock+"+qnty+" where  item_code="+item_code);
           // ps.setString(1,stockT.getText());
           // ps.setString(1,itemcode.getText());
                ps2.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         
                 
        try {
            String del="delete from purchase_tem";
            ps=con.prepareStatement(del);
             
            //ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(rootPane, "Delete Failled");
        }
        
         ClearText();
           DefaultTableModel model=(DefaultTableModel)tableP.getModel();
        while(model.getRowCount()>0){
            for(int i=0;i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
         try {
            String del="delete from purchase_tem";
            ps=con.prepareStatement(del);
             
            //ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(rootPane, "Delete Failled");
        }
                
    }//GEN-LAST:event_SaveBTNActionPerformed

    private void SubTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubTKeyReleased
       String a1 = quanTF.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        double d = 0;
     String   b =SubT.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        double e = c * d;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        puR.setText(f1);
     
        
        
    }//GEN-LAST:event_SubTKeyReleased

    private void BillBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BillBKeyReleased
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_BillBKeyReleased

    private void paidTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidTKeyReleased
        // TODO add your handling code here:
        
         String a1 = GrT.getText();
        //String b = quantityShow.getText();
        
        int c =Integer.parseInt(a1);
        int d = 0;
     String   b =paidT.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        int e =c-d;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        BillB.setText(f1);
        
    }//GEN-LAST:event_paidTKeyReleased
public void ClearText(){
    ADD.setText("");
     itemcode.setText("");
     stockT.setText("");
     quanTF.setText("");
     SubT.setText("");
     sellR.setText("");
     warr.setSelectedItem("");
     puR.setText("");
     paidT.setText("");
     BillB.setText("");
    // invo.setText("");
       vendorcombo.setSelectedItem("");
        itemN.setSelectedItem("");
         itemCa.setSelectedItem("");
         mobT.setText("");
         subTotalSum.setText("");
         comS.setText("");
         ComDS.setText("");
         GrT.setText("");
         paidT.setText("");
         BillB.setText("");
         
}
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        ClearText();
         try {
            String del="delete from purchase_tem  ";
            ps=con.prepareStatement(del);
             
           // ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(rootPane, "Delete Failled");
        }
        try {
            String del="delete from purchase_sub  where  invoice_no=?";
            ps=con.prepareStatement(del);
             
            ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(rootPane, "Delete Failled");
           return;
        }
        
          DefaultTableModel model=(DefaultTableModel)tableP.getModel();
        while(model.getRowCount()>0){
            for(int i=0;i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
        
    }//GEN-LAST:event_cancelActionPerformed

    private void mobTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobTKeyReleased
 
        
        
    }//GEN-LAST:event_mobTKeyReleased

    private void quanTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanTFKeyReleased
        // TODO add your handling code here:
         // TODO add your handling code here:
         String a1 = quanTF.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        double d = 0;
        String   b =puR.getText();
        d = Double.parseDouble(b);

//        boolean isNumber = Pattern.matches("[0-9]+", b);
//        if(isNumber) {
//        }
        
        //int d = Integer.parseInt(beer);
        
        double e = c * d;
        
        DecimalFormat ff=new DecimalFormat("##.00");
        String f1=ff.format(e);
        SubT.setText(f1);
        
    }//GEN-LAST:event_quanTFKeyReleased

    private void itemcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemcodeKeyReleased
     

        
        
    }//GEN-LAST:event_itemcodeKeyReleased

    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
        String sql="update purchase_tem set brand_name=?,item_category=?,item_name=?,quantity=?,purchase_rate=?,selling_rate=?,warranty=?,sub_total=?  where item_code=?";
        try {
             ps=con.prepareStatement(sql);
        ps.setString(1,brandCombo.getSelectedItem().toString());
         ps.setString(2,itemCa.getSelectedItem().toString());
          ps.setString(3,itemN.getSelectedItem().toString());
          ps.setString(4,quanTF.getText());
          ps.setString(5,puR.getText());
          ps.setString(6,sellR.getText());
           ps.setString(7,warr.getSelectedItem().toString());
            ps.setString(8,SubT.getText());
           ps.setString(9, itemcode.getText());
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       String sqll="update purchase_sub set brand_name=?,item_category=?,item_name=?,quantity=?,purchase_rate=?,selling_rate=?,warranty=?,sub_total=?  where item_code=?";
        try {
             ps=con.prepareStatement(sqll);
        ps.setString(1,brandCombo.getSelectedItem().toString());
         ps.setString(2,itemCa.getSelectedItem().toString());
          ps.setString(3,itemN.getSelectedItem().toString());
          ps.setString(4,quanTF.getText());
          ps.setString(5,puR.getText());
          ps.setString(6,sellR.getText());
           ps.setString(7,warr.getSelectedItem().toString());
            ps.setString(8,SubT.getText());
           ps.setString(9, itemcode.getText());
           ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
           try {
            String sq="select sum(sub_total) from purchase_tem where invoice_no=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, invo.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(sub_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                subTotalSum.setText(s);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         getData();
    }//GEN-LAST:event_UpdateBTNActionPerformed

    private void itemNPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_itemNPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
         String combo=(String)itemN.getSelectedItem();
        String sql="select item_category,item_code,total_stock,company_name,warranty,brand_company,purchase_rate,selling_rate from stock where item_name=?";
        String sql_it="select purchase_rate,selling_rate from item where item_name=?";
        try{
             ps=con.prepareStatement(sql_it);
             ps.setString(1, combo);
             rs=ps.executeQuery();
                if(rs.next())
                {
                String add6=rs.getString("purchase_rate");
                puR.setText(add6);
                String add7=rs.getString("selling_rate");
                sellR.setText(add7);      
                }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, combo);
            rs=ps.executeQuery();
            if(rs.next()){
                String add=rs.getString("item_category");
                
                itemCa.setSelectedItem(add);
                  String add1=rs.getString("item_code");
                 itemcode.setText(add1);
                
                 String add2=rs.getString("total_stock");
                 stockT.setText(add2);
                  String add3=rs.getString("company_name");
                
                vendorcombo.setSelectedItem(add3);
                  String add4=rs.getString("warranty");
                 warr.setSelectedItem(add4);
                 
                  String add5=rs.getString("brand_company");
                 brandCombo.setSelectedItem(add5);
        
                 
                 
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        quanTF.setText("");
        SubT.setText("");
       
    }//GEN-LAST:event_itemNPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
                             itemCa.setSelectedItem(rs.getString("item_category"));
                             itemN.setSelectedItem(rs.getString("item_name"));
                             SubT.setText(rs.getString("purchase_rate"));
                             sellR.setText(rs.getString("selling_rate"));
                             puR.setText(rs.getString("selling_rate"));
                             stockT.setText(rs.getString("stock"));  
                             invo.setText(rs.getString("invoice_no"));
                             
                         }else
                         {
                             JOptionPane.showMessageDialog(null, "Item not found!");
                             itemcode.setCursor(null);
                         }

                     } catch (Exception e) {
                     }
        }
    }//GEN-LAST:event_itemcodeKeyPressed

    private void puRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puRKeyReleased
        // TODO add your handling code here:
         String a1 = quanTF.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        double d = 0;
     String   b =puR.getText();
     d = Integer.parseInt(b);
//        boolean isNumber = Pattern.matches("[0-9]+", b);
//        if(isNumber) {
//        
//        }
        
        //int d = Integer.parseInt(beer);
        
        double e = c * d;
        
        //String f = String.valueOf(e);
        DecimalFormat ff=new DecimalFormat("##.00");
        String f1=ff.format(e);
        SubT.setText(f1);
        
    }//GEN-LAST:event_puRKeyReleased

    private void brandComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboActionPerformed

    private void brandComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandComboKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboKeyReleased

    private void brandComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandComboKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboKeyTyped

    private void GrTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrTActionPerformed

    private void GrTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GrTKeyReleased

    private void vendorcomboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vendorcomboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
         String ven=(String)vendorcombo.getSelectedItem();
        String sql="select mobile_no,address from company where company_name=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, ven);
            rs=ps.executeQuery();
            if(rs.next()){
                String add=rs.getString("mobile_no");
                
                mobT.setText(add);
                  String add1=rs.getString("address");
                 ADD.setText(add1);
                 
                 
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_vendorcomboPopupMenuWillBecomeInvisible

    private void comSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comSKeyReleased
        // TODO add your handling code here:
          // TODO add your handling code here:
         String a1 =subTotalSum.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        int d = 0;
     String   b =comS.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        int e =c*d/100;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        ComDS.setText(f1);
        int g=c-c*d/100;
        String gt=String.valueOf(g);
        GrT.setText(gt);
        
        
        
    }//GEN-LAST:event_comSKeyReleased

    private void invoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoKeyTyped
        char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_invoKeyTyped

    private void quanTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanTFKeyTyped
     char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_quanTFKeyTyped

    private void puRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puRKeyTyped
         char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_puRKeyTyped

    private void sellRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellRKeyTyped
        char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_sellRKeyTyped

    private void tablePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePMouseClicked
        try{
             
            int row= tableP.getSelectedRow();
            String table_click=tableP.getModel().getValueAt(row, 0).toString();
            String sql= "select  brand_name,item_code,item_category,item_name,quantity,purchase_rate,selling_rate,warranty,sub_total,id from purchase_tem where id = '" + table_click + "'";
            ps=con.prepareStatement(sql);
            rs=  ps.executeQuery();
            if(rs.next()){
                   String add1=rs.getString("brand_name");
                brandCombo.setSelectedItem(add1);
                String add2=rs.getString("item_category");
                itemCa.setSelectedItem(add2);
                String add3=rs.getString("item_name");
                 itemN.setSelectedItem(add3);
                String add4=rs.getString("quantity");
                quanTF.setText(add4);
                String add5=rs.getString("purchase_rate");
                puR.setText(add5);
                  String add6=rs.getString("selling_rate");
                sellR.setText(add6);
                 String add7=rs.getString("warranty");
                warr.setSelectedItem(add7);
                 String add8=rs.getString("sub_total");
                SubT.setText(add8);
                  String add9=rs.getString("item_code");
                itemcode.setText(add9);
                 
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_tablePMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
            JasperDesign jasperDesign=JRXmlLoader.load("I:\\Software Back Up\\E-Computer\\Alpha Version\\Copy of e-computer\\src\\report\\print_purchase.jrxml");
         String sql="select * from purchase_sub join purchase_invoice on "
                    + "purchase_sub.invoice_no=purchase_invoice.invoice_no  "
                    + "where purchase_sub.invoice_no='"+invo.getText()+"'";
                    
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jasperDesign.setQuery(newQuery);
            JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemCaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_itemCaPopupMenuWillBecomeInvisible
       String combo=(String)itemCa.getSelectedItem();
        String sql="select item_name,item_code,total_stock,company_name,warranty,brand_company,purchase_rate,selling_rate from stock where item_category=?";
        String sql_it="select purchase_rate,selling_rate from item where item_category=?";
        try{
             ps=con.prepareStatement(sql_it);
             ps.setString(1, combo);
             rs=ps.executeQuery();
                if(rs.next())
                {
                String add6=rs.getString("purchase_rate");
                puR.setText(add6);
                String add7=rs.getString("selling_rate");
                sellR.setText(add7);      
                }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, combo);
            rs=ps.executeQuery();
            if(rs.next()){
                String add=rs.getString("item_name");
                
                itemN.setSelectedItem(add);
                  String add1=rs.getString("item_code");
                 itemcode.setText(add1);
                
                 String add2=rs.getString("total_stock");
                 stockT.setText(add2);
                  String add3=rs.getString("company_name");
                
                vendorcombo.setSelectedItem(add3);
                  String add4=rs.getString("warranty");
                 warr.setSelectedItem(add4);
                 
                  String add5=rs.getString("brand_company");
                 brandCombo.setSelectedItem(add5);
        
                 
                 
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        quanTF.setText("");
        SubT.setText("");
    }//GEN-LAST:event_itemCaPopupMenuWillBecomeInvisible

    private void itemCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADD;
    private javax.swing.JButton AddBTN;
    private javax.swing.JTextField BillB;
    private javax.swing.JTextField ComDS;
    private javax.swing.JTextField GrT;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JLabel StockBTN;
    private javax.swing.JTextField SubT;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JComboBox brandCombo;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField comS;
    private javax.swing.JTextField date;
    private GUI.ImagePanel imagePanel1;
    private javax.swing.JTextField invo;
    private javax.swing.JComboBox itemCa;
    private javax.swing.JComboBox itemN;
    private javax.swing.JTextField itemcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mobT;
    private javax.swing.JTextField paidT;
    private javax.swing.JTextField puR;
    private javax.swing.JTextField quanTF;
    private javax.swing.JTextField sellR;
    private javax.swing.JTextField stockT;
    private javax.swing.JTextField subTotalSum;
    private javax.swing.JTable tableP;
    private javax.swing.JTextField tbalance;
    private javax.swing.JTextField tcommission;
    private javax.swing.JTextField tinvoice;
    private javax.swing.JTextField tpaid;
    private javax.swing.JTextField tpurchase;
    private javax.swing.JComboBox vendorcombo;
    private javax.swing.JComboBox warr;
    // End of variables declaration//GEN-END:variables


public void loadCombo(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(supplier_name) from item order by supplier_name");
            while(rs.next()){
            plist.add(rs.getString("supplier_name"));
             
            
            }
            vendorcombo.setModel(new DefaultComboBoxModel(plist.toArray()));
            vendorcombo.insertItemAt("Select", 0);
            vendorcombo.setSelectedIndex(0);
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }
        
        
        
        
  
}

public void loadCombo1(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(item_name) from item order by item_name");
            while(rs.next()){
            plist.add(rs.getString("item_name"));
             
            
            }
            itemN.setModel(new DefaultComboBoxModel(plist.toArray()));
            itemN.insertItemAt("Select Item", 0);
            itemN.setSelectedIndex(0);
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }
}


public void loadCombo2(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(item_category) from item order by item_category");
            while(rs.next()){
            plist.add(rs.getString("item_category"));
             
            
            }
            itemCa.setModel(new DefaultComboBoxModel(plist.toArray()));
            itemCa.insertItemAt("Select Category", 0);
            itemCa.setSelectedIndex(0);
            
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }
}
public void loadCombo3(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(brand_company) from item order by brand_company");
            while(rs.next()){
            plist.add(rs.getString("brand_company"));
               System.out.println(rs.getString("brand_company"));
            
            }
            brandCombo.setModel(new DefaultComboBoxModel(plist.toArray()));
            brandCombo.insertItemAt("Select", 0);
            brandCombo.setSelectedIndex(0);
            
           
            
            
        } catch (Exception e) {
    
            System.out.println(e.getMessage());
        }
        
        
        
        
  
}

    
}
