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
import java.sql.SQLException;
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
 * @author Md.Tarikul Islam
 */
public class SaleForm extends javax.swing.JInternalFrame {
  Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    
    /**
     * Creates new form SaleForm
     */
    public SaleForm() {
        initComponents();
        con=DbConn.dbConnection();
         imagePanel1.setImage(new ImageIcon(this.getClass().getResource("page.png")).getImage());
          DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
        Date dat=new Date();
        dateT.setText(dt.format(dat));
         try {
             String str="select invoice_no from sale_invoice order by invoice_no desc";
                ps=con.prepareStatement(str);
                rs=ps.executeQuery();
                
                int invoice=0;
                if(rs.next())
                {
                    invoice=rs.getInt("invoice_no")+1;
                }else
                {
                    invoice=1;
                }
                String str_inv=String.valueOf(invoice);
                invo.setText(str_inv);
        } catch (Exception e) {
        }
         
         loadCombo();
         loadCombo1();
          loadCombo2();
            loadCombo3();
             loadCombo4();
            
                custN.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      mobT.requestFocusInWindow();    
    }
});
     
                
                mobT.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
     Add.requestFocusInWindow();    
    }
});
                 
                Add.addActionListener(new ActionListener() {
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
     disT.requestFocusInWindow();    
    }
});                 
     disT.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
     paid.requestFocusInWindow();    
    }
});  
     
     try {
            String sq="select count(*) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, dateT.getText());
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
            String sq="select sum(grand_total) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(1, dateT.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(grand_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tsale.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        try {
            String sq="select sum(commission_deduction) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, dateT.getText());
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
            String sq="select sum(paid) from e_computer.sale_invoice where date=?  ";
            ps=con.prepareStatement(sq);
           ps.setString(1, dateT.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(paid)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpaid.setText(s);
                 
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mobT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Add = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        StockBTN = new javax.swing.JLabel();
        stockT = new javax.swing.JTextField();
        itemN = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        SellR = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        itemCa = new javax.swing.JComboBox();
        warr = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        itemCo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        purR = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        subT = new javax.swing.JTextField();
        ADDBTN = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        totalP = new javax.swing.JTextField();
        quanTF = new javax.swing.JTextField();
        GtotalPur = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        paid = new javax.swing.JTextField();
        chan = new javax.swing.JTextField();
        disT = new javax.swing.JTextField();
        disDiduc = new javax.swing.JTextField();
        subTotalSum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        GrT = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnupdate = new javax.swing.JButton();
        PrintBTN = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        saveBTN = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        invo = new javax.swing.JTextField();
        dateT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        brandCombo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        custN = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        tinvoice = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tsale = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tcommission = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tpaid = new javax.swing.JTextField();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1185, 634));

        imagePanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                imagePanel1ComponentShown(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Customer Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Mobile No:");

        mobT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobTKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Address:");

        Add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Item Name:");

        StockBTN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StockBTN.setText("Stock:");
        StockBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockBTNMouseClicked(evt);
            }
        });

        stockT.setEditable(false);
        stockT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockTKeyTyped(evt);
            }
        });

        itemN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Item Category:");

        SellR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellRActionPerformed(evt);
            }
        });
        SellR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SellRKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SellRKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Selling Rate:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Quantity:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Warranty:");

        itemCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCaActionPerformed(evt);
            }
        });

        warr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warrActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Item Code:");

        itemCo.setEditable(false);
        itemCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCoActionPerformed(evt);
            }
        });
        itemCo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemCoKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Purchase Rate:");

        purR.setEditable(false);
        purR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purRActionPerformed(evt);
            }
        });
        purR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purRKeyReleased(evt);
            }
        });

        jLabel8.setText("Sub-Total:");

        subT.setEditable(false);
        subT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subTActionPerformed(evt);
            }
        });

        ADDBTN.setBackground(new java.awt.Color(102, 255, 255));
        ADDBTN.setText("ADD TO CART");
        ADDBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDBTNActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Total Purchase:");

        totalP.setEditable(false);
        totalP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPActionPerformed(evt);
            }
        });
        totalP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalPKeyReleased(evt);
            }
        });

        quanTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quanTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quanTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quanTFKeyTyped(evt);
            }
        });

        GtotalPur.setEditable(false);
        GtotalPur.setBackground(new java.awt.Color(255, 255, 255));
        GtotalPur.setForeground(new java.awt.Color(255, 255, 255));
        GtotalPur.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StockBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(GtotalPur, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(warr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemN, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemCa, 0, 167, Short.MAX_VALUE)
                    .addComponent(quanTF)
                    .addComponent(purR)
                    .addComponent(totalP))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(itemCo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ADDBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addComponent(SellR)
                            .addComponent(subT))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addComponent(itemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(StockBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(purR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(warr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(itemCo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SellR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(subT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(GtotalPur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ADDBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        jLabel1.setText("Selling Date:");

        jLabel9.setText("Discount:");

        jLabel4.setText("%");

        jLabel11.setText("Grand Total:");

        jLabel12.setText("Change:");

        paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidActionPerformed(evt);
            }
        });
        paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidKeyReleased(evt);
            }
        });

        chan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chanActionPerformed(evt);
            }
        });
        chan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                chanKeyReleased(evt);
            }
        });

        disT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                disTKeyReleased(evt);
            }
        });

        disDiduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                disDiducKeyReleased(evt);
            }
        });

        subTotalSum.setEditable(false);
        subTotalSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subTotalSumActionPerformed(evt);
            }
        });
        subTotalSum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subTotalSumKeyReleased(evt);
            }
        });

        jLabel10.setText("Total:");

        jLabel17.setText("Paid:");

        GrT.setEditable(false);
        GrT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrTActionPerformed(evt);
            }
        });
        GrT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GrTKeyPressed(evt);
            }
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
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disDiduc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subTotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(disT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(disDiduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chan)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        PrintBTN.setText("Print");
        PrintBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBTNActionPerformed(evt);
            }
        });

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        saveBTN.setText("Sale");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(saveBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancel)
                .addGap(18, 18, 18)
                .addComponent(btnupdate)
                .addGap(18, 18, 18)
                .addComponent(PrintBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SALE FORM");

        jLabel18.setText("Invoice No:");

        invo.setEditable(false);
        invo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoActionPerformed(evt);
            }
        });

        dateT.setEditable(false);
        dateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTActionPerformed(evt);
            }
        });
        dateT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateTKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Brand Name:");

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

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(java.awt.Color.magenta);
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/sale.jpg"))); // NOI18N

        custN.setEditable(true);
        custN.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                custNPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

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

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel26.setBackground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("Total Invoice");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tinvoice.setEditable(false);

        jLabel25.setBackground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Total Sale");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tsale.setEditable(false);

        jLabel24.setBackground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Total Commission");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tcommission.setEditable(false);

        jLabel23.setBackground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Total Paid");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(255, 51, 204)));

        tpaid.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tinvoice)
                    .addComponent(tsale)
                    .addComponent(tcommission)
                    .addComponent(tpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tsale, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcommission, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(imagePanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(imagePanel1Layout.createSequentialGroup()
                                    .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagePanel1Layout.createSequentialGroup()
                                            .addGap(42, 42, 42)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Add))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagePanel1Layout.createSequentialGroup()
                                            .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addGroup(imagePanel1Layout.createSequentialGroup()
                                                    .addGap(32, 32, 32)
                                                    .addComponent(jLabel6)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(mobT)
                                                .addComponent(custN, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(imagePanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(brandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(imagePanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(9, 9, 9)
                                            .addComponent(dateT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagePanel1Layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(invo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(imagePanel1Layout.createSequentialGroup()
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(custN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mobT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(imagePanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(brandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(invo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(dateT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(imagePanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
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

    private void mobTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobTKeyReleased
        //        // TODO add your handling code here:
        //        try {
            //            String sql="select company_name,mobile_no,date,address,item_name,item_category,item_code,stock,quantity,purchase_rate,selling_rate,warranty,sub_total,paid,due from purchase where mobile_no=?";
            //            ps=con.prepareStatement(sql);
            //            ps.setString(1, mobT.getText());
            //            rs=ps.executeQuery();
            //            if(rs.next()){
                //                String add1=rs.getString("company_name");
                //                companyN.setText(add1);
                //                String add2=rs.getString("mobile_number");
                //                mobN.setText(add2);
                //                 String add3=rs.getString("order_number");
                //                ordN.setText(add3);
                //                  String add4=rs.getString("order_date");
                //                ordD.setText(add4);
                //                  String add5=rs.getString("delivery_date");
                //                delD.setText(add5);
                //                  String add6=rs.getString("item_one");
                //                  itemOne.setText(add6);
                //
                //                   String add7=rs.getString("item_two");
                //                  itemTwo.setText(add7);
                //                 String add8=rs.getString("rate_one");
                //                rateOne.setText(add8);
                //                 String add9=rs.getString("quantity_one");
                //                quantOne.setText(add9);
                //
                //                String add10=rs.getString("quantity_two");
                //                quantTwo.setText(add10);
                //
                //                 String add11=rs.getString("total");
                //                total.setText(add11);
                //                 String add12=rs.getString("advance_amount");
                //                advanceA.setText(add12);
                //                 String add13=rs.getString("due_amount");
                //                dueA.setText(add13);
                //                 String add14=rs.getString("rate_two");
                //                rateTwo.setText(add14);
                //                    String add15=rs.getString("fabrics");
                //                fab.setText(add15);
                //
                //
                //
                //
                //
                //
                //            }
            //        } catch (Exception e) {
            //
            //        }

    }//GEN-LAST:event_mobTKeyReleased

    private void AddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_AddKeyReleased

    private void StockBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockBTNMouseClicked
//          
//        try{
//            ps=con.prepareStatement("Select stock,selling_rate From purchase Where item_name=?");
//            ps.setString(1,itemN.getSelectedItem().toString());
//            rs=ps.executeQuery();
//            while(rs.next()){
//                stockT.setText(rs.getString("stock"));
//                 SellR.setText(rs.getString("selling_rate"));
//                //            inStoTF.setText(rs.getString("stock"));
//                //            x=Integer.parseInt(rs.getString("stock"));
//                //            dbl=Double.valueOf(rs.getString("unit_Price"));
//                //            stk=new Stock(x,dbl);
//                //            //System.out.println(dbl);
//            }
//                String str="select invoice_no from sale_invoice order by invoice_no desc";
//                ps=con.prepareStatement(str);
//                rs=ps.executeQuery();
//                
//                int invoice=0;
//                if(rs.next())
//                {
//                    invoice=rs.getInt("invoice_no")+1;
//                }else
//                {
//                    invoice=1;
//                }
//                String str_inv=String.valueOf(invoice);
//                invo.setText(str_inv);
//                
//                
//                
//        
//            // inStoTF.setText(String.valueOf(stk.getStock()));
//        }catch(Exception e){System.out.println(e.getMessage());
//        }
    }//GEN-LAST:event_StockBTNMouseClicked

    private void itemNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNActionPerformed
         String combo=(String)itemN.getSelectedItem();
         
         
          String sql_it="select purchase_rate,selling_rate from item where item_name=?";
        try{
             ps=con.prepareStatement(sql_it);
             ps.setString(1, combo);
             rs=ps.executeQuery();
                if(rs.next())
                {
                       SellR.setText(rs.getString("selling_rate"));
                       purR.setText(rs.getString("purchase_rate"));
                       
                }
                  
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        try{
            ps=con.prepareStatement("Select item_category,item_code, total_stock,selling_rate,purchase_rate,warranty,brand_company From stock Where item_name=?");
            ps.setString(1,combo);
            rs=ps.executeQuery();
            while(rs.next()){
                itemCa.setSelectedItem(rs.getString("item_category"));
                 itemCo.setText(rs.getString("item_code"));
                   stockT.setText(rs.getString("total_stock"));
 
                           warr.setSelectedItem(rs.getString("warranty"));
                              brandCombo.setSelectedItem(rs.getString("brand_company"));  
                //            inStoTF.setText(rs.getString("stock"));
                //            x=Integer.parseInt(rs.getString("stock"));
                //            dbl=Double.valueOf(rs.getString("unit_Price"));
                //            stk=new Stock(x,dbl);
                //            //System.out.println(dbl);
            }
//                String str="select invoice_no from sale_invoice order by invoice_no desc";
//                ps=con.prepareStatement(str);
//                rs=ps.executeQuery();
//                
//                int invoice=0;
//                if(rs.next())
//                {
//                    invoice=rs.getInt("invoice_no")+1;
//                }else
//                {
//                    invoice=1;
//                }
//                String str_inv=String.valueOf(invoice);
//                invo.setText(str_inv);
                
                quanTF.setText("");
                subT.setText("");
                
        
            // inStoTF.setText(String.valueOf(stk.getStock()));
        }catch(Exception e){System.out.println(e.getMessage());
        }        
       
        
    }//GEN-LAST:event_itemNActionPerformed

    private void SellRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellRActionPerformed

    private void SellRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SellRKeyReleased
        String a1 = SellR.getText();
        //String b = quantityShow.getText();

        int c = Integer.parseInt(a1);
        double d = 0;
        String   b =quanTF.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
            d = Integer.parseInt(b);
        }

        //int d = Integer.parseInt(beer);

        double e = c * d;

        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        subT.setText(f1);

    }//GEN-LAST:event_SellRKeyReleased

    private void itemCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCaActionPerformed

    private void warrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warrActionPerformed

    private void subTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subTActionPerformed

    private void subTotalSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subTotalSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subTotalSumActionPerformed

    private void subTotalSumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subTotalSumKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_subTotalSumKeyReleased

    private void paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidActionPerformed

    private void paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidKeyReleased
   String a1 = GrT.getText();
        //String b = quantityShow.getText();
        
        int c =Integer.parseInt(a1);
        int d = 0;
     String   b =paid.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        int e =c-d;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        chan.setText(f1);
        
    }//GEN-LAST:event_paidKeyReleased

    private void chanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chanActionPerformed

    private void chanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_chanKeyReleased

    private void quanTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanTFKeyReleased
        // TODO add your handling code here:
           String a1 = quanTF.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        int d = 0;
     String   b =SellR.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        int e = c * d;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        subT.setText(f1);
        
        
        
          String a2 = quanTF.getText();
        //String b = quantityShow.getText();
        
        int q= Integer.parseInt(a2);
        double d1 = 0;
     String   b1=purR.getText();
        
         
        d1 =Double.parseDouble(b1);
        
        
        //int d = Integer.parseInt(beer);
        
        double e1 = q* d1;
        
        DecimalFormat ff=new DecimalFormat("##.00");
        String f2=ff.format(e1);
        totalP.setText(f2);
        
    }//GEN-LAST:event_quanTFKeyReleased

    private void disTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disTKeyReleased
          String a1 =subTotalSum.getText();
        //String b = quantityShow.getText();
        
        int c = Integer.parseInt(a1);
        int d = 0;
     String   b =disT.getText();
        boolean isNumber = Pattern.matches("[0-9]+", b);
        if(isNumber) {
        d = Integer.parseInt(b);
        }
        
        //int d = Integer.parseInt(beer);
        
        int e =c*d/100;
        
        //String f = String.valueOf(e);
        String f1 = String.valueOf(e);
        disDiduc.setText(f1);
        int g=c-c*d/100;
        String gt=String.valueOf(g);
        GrT.setText(gt);
        
        
    }//GEN-LAST:event_disTKeyReleased

    private void ADDBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDBTNActionPerformed
        // TODO add your handling code here:
         if (custN.getSelectedItem().toString().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Customer Name","Error", JOptionPane.ERROR_MESSAGE);
                custN.requestFocus();
                return;

            }
          if (mobT.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Mobile No","Error", JOptionPane.ERROR_MESSAGE);
                mobT.requestFocus();
                return;

            }
         
               if (itemN.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Item","Error", JOptionPane.ERROR_MESSAGE);
               itemN.requestFocus();
                return;

            }
                
                 if (quanTF.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Quantity","Error", JOptionPane.ERROR_MESSAGE);
                disT.requestFocus();
                return;

            }
        
        
        
         try {
            ps=con.prepareStatement("insert into sale_tem(customer_name,invoice_no,mobile_no,address,date,item_name,item_category,item_code,stock,quantity,selling_rate,purchase_rate,warranty,sub_total,brand_name,total_purchase)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
           ps.setString(1, custN.getSelectedItem().toString());
            ps.setString(2, invo.getText());
            ps.setString(3, mobT.getText());
             ps.setString(4, Add.getText());
             ps.setString(5, dateT.getText());
             ps.setString(6,itemN.getSelectedItem().toString());
           ps.setString(7, itemCa.getSelectedItem().toString());
            ps.setString(8, itemCo.getText());
             ps.setString(9, stockT.getText());
             ps.setString(10, quanTF.getText());
            ps.setString(11, SellR.getText());
            ps.setString(12, purR.getText());
              ps.setString(13, warr.getSelectedItem().toString());
                ps.setString(14, subT.getText());
                ps.setString(15,brandCombo.getSelectedItem().toString());
                 ps.setString(16,totalP.getText());
                
//                  ps.setString(11, disT.getText());
//                    ps.setString(12, total.getText());
//                      ps.setString(13, paid.getText());
                    
                     
                      // ps.setString(14, chan.getText());       
           
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Add to Cart OK");
             
//             ps=con.prepareStatement("insert into sale_invoice(invoice_no,customer_name)values(?,?)");
//             ps.setString(1, invo.getText());
//             ps.setString(2, Cust.getText());
//             ps.executeUpdate();
//             
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data not Inserted");
        }
        
           try {
            ps=con.prepareStatement("insert into sale_sub(customer_name,invoice_no,mobile_no,address,date,item_name,item_category,item_code,stock,quantity,selling_rate,purchase_rate,warranty,sub_total,brand_name,total_purchase)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
           ps.setString(1, custN.getSelectedItem().toString());
            ps.setString(2, invo.getText());
            ps.setString(3, mobT.getText());
             ps.setString(4, Add.getText());
             ps.setString(5, dateT.getText());
             ps.setString(6,itemN.getSelectedItem().toString());
           ps.setString(7, itemCa.getSelectedItem().toString());
            ps.setString(8, itemCo.getText());
             ps.setString(9, stockT.getText());
             ps.setString(10, quanTF.getText());
            ps.setString(11, SellR.getText());
            ps.setString(12, purR.getText());
              ps.setString(13, warr.getSelectedItem().toString());
                ps.setString(14, subT.getText());
                ps.setString(15,brandCombo.getSelectedItem().toString());
                 ps.setString(16,totalP.getText());
                
//                  ps.setString(11, disT.getText());
//                    ps.setString(12, total.getText());
//                      ps.setString(13, paid.getText());
                    
                     
                      // ps.setString(14, chan.getText());       
           
            ps.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Data Added Successfully");
             
//             ps=con.prepareStatement("insert into sale_invoice(invoice_no,customer_name)values(?,?)");
//             ps.setString(1, invo.getText());
//             ps.setString(2, Cust.getText());
//             ps.executeUpdate();
//             
        } catch (Exception e) {
              //JOptionPane.showMessageDialog(null, "Data not Add");
        }
           try {
            String sq="select sum(sub_total) from sale_tem where invoice_no=? ";
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
            try {
            String sq="select sum(total_purchase) from sale_tem where invoice_no=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, invo.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(total_purchase)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                GtotalPur.setText(s);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
        
        
        getData(); 
        
    }//GEN-LAST:event_ADDBTNActionPerformed

    private void paidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidKeyPressed
//        // TODO add your handling code here:
//         String a1 =total.getText();
//        //String b = quantityShow.getText();
//        
//        int c =Integer.parseInt(a1);
//        int d = 0;
//     String   b =paid.getText();
//        boolean isNumber = Pattern.matches("[0-9]+", b);
//        if(isNumber) {
//        d = Integer.parseInt(b);
//        }
//        
//        //int d = Integer.parseInt(beer);
//        
//        int e = c-d;
//        
//        //String f = String.valueOf(e);
//        String f1 = String.valueOf(e);
//        chan.setText(f1);
//        
    }//GEN-LAST:event_paidKeyPressed

    private void PrintBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBTNActionPerformed
        // TODO add your handling code here:
        
         try {
            JasperDesign jasperDesign=JRXmlLoader.load("I:\\Software Back Up\\E-Computer\\Alpha Version\\Copy of e-computer\\src\\report\\print_customer.jrxml");
            String sql="select * from sale_sub join sale_invoice on "
                    + "sale_sub.invoice_no=sale_invoice.invoice_no  "
                    + "where sale_sub.invoice_no='"+invo.getText()+"'";
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jasperDesign.setQuery(newQuery);
            JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         
//         
//         try {
//             String str="select invoice_no from sale_invoice order by invoice_no desc";
//                ps=con.prepareStatement(str);
//                rs=ps.executeQuery();
//                
//                int invoice=0;
//                if(rs.next())
//                {
//                    invoice=rs.getInt("invoice_no")+1;
//                }else
//                {
//                    invoice=1;
//                }
//                String str_inv=String.valueOf(invoice);
//                invo.setText(str_inv);
//        } catch (Exception e) {
//        }
//         try {
//            ps=con.prepareStatement("update sale_tem set discount=?,total=?,paid=? where item_name=?");
//            ps.setString(1, disT.getText());
//            ps.setString(2, subTotalSum.getText());
//            ps.setString(3, paid.getText());
//            ps.executeQuery();
//        } catch (Exception e) {
//            
//        }
         
         
         
        
    }//GEN-LAST:event_PrintBTNActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        
       String sql="update sale_tem set brand_name=?,item_category=?,item_name=?,quantity=?,purchase_rate=?,selling_rate=?,warranty=?,sub_total=?  where item_code=?";
        try {
             ps=con.prepareStatement(sql);
        ps.setString(1,brandCombo.getSelectedItem().toString());
         ps.setString(2,itemCa.getSelectedItem().toString());
          ps.setString(3,itemN.getSelectedItem().toString());
          ps.setString(4,quanTF.getText());
          ps.setString(5,purR.getText());
          ps.setString(6,SellR.getText());
           ps.setString(7,warr.getSelectedItem().toString());
            ps.setString(8,subT.getText());
           ps.setString(9, itemCo.getText());
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
           
        
        String sqlll="update sale_sub set brand_name=?,item_category=?,item_name=?,quantity=?,purchase_rate=?,selling_rate=?,warranty=?,sub_total=?  where item_code=?";
        try {
             ps=con.prepareStatement(sqlll);
        ps.setString(1,brandCombo.getSelectedItem().toString());
         ps.setString(2,itemCa.getSelectedItem().toString());
          ps.setString(3,itemN.getSelectedItem().toString());
          ps.setString(4,quanTF.getText());
          ps.setString(5,purR.getText());
          ps.setString(6,SellR.getText());
           ps.setString(7,warr.getSelectedItem().toString());
            ps.setString(8,subT.getText());
           ps.setString(9, itemCo.getText());
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
           
         try {
            String sq="select sum(sub_total) from sale_tem where invoice_no=? ";
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
        
    }//GEN-LAST:event_btnupdateActionPerformed

    
    
    public void ClearText(){
    custN.setSelectedItem("");
     mobT.setText("");
     Add.setText("");
     stockT.setText("");
     quanTF.setText("");
     SellR.setText("");
       purR.setText("");
       totalP.setText("");
     subT.setText("");
      disT.setText("");
       subTotalSum.setText("");
       paid.setText("");
       chan.setText("");
     GrT.setText("");
     
}
    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        ClearText();
         try {
            String del="delete from sale_tem  ";
            ps=con.prepareStatement(del);
             
           // ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(rootPane, "Delete Failled");
        }
        try {
            String del="delete from sale_sub  where  invoice_no=?";
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
        
        
        
        
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void invoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoActionPerformed
        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_invoActionPerformed

    private void imagePanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_imagePanel1ComponentShown
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_imagePanel1ComponentShown

    private void itemCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCoActionPerformed

    private void itemCoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCoKeyReleased

    private void purRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purRActionPerformed

    private void purRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purRKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_purRKeyReleased

    private void dateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTActionPerformed

    private void dateTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTKeyReleased

    private void disDiducKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disDiducKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_disDiducKeyReleased

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        
         if (custN.getSelectedItem().toString().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Customer Name","Error", JOptionPane.ERROR_MESSAGE);
                custN.requestFocus();
                return;

            }
          if (mobT.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Mobile No","Error", JOptionPane.ERROR_MESSAGE);
                mobT.requestFocus();
                return;

            }
         
               if (itemN.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog( this, "Please Select an Item","Error", JOptionPane.ERROR_MESSAGE);
               itemN.requestFocus();
                return;

            }
                
                 if (quanTF.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Quantity","Error", JOptionPane.ERROR_MESSAGE);
                disT.requestFocus();
                return;

            }
                 if (disT.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Zero(0) in discount field","Error", JOptionPane.ERROR_MESSAGE);
                disT.requestFocus();
                return;

            }
             if (paid.getText().length()==0) {
                JOptionPane.showMessageDialog( this, "Please enter Zero(0) in paid field","Error", JOptionPane.ERROR_MESSAGE);
               paid.requestFocus();
                return;

            }
              btncancel.setEnabled(false);
        btnupdate.setEnabled(false);
             
          try {
            ps=con.prepareStatement("insert into sale_invoice(customer_name,invoice_no,mobile_no,address,date,item_name,item_category,stock,quantity,selling_rate,warranty,purchase_rate,total,discount,grand_total,paid,profit,total_purchase,commission_deduction,bill_balance)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
           ps.setString(1, custN.getSelectedItem().toString());
            ps.setString(2, invo.getText());
            ps.setString(3, mobT.getText());
             ps.setString(4, Add.getText());
             ps.setString(5, dateT.getText());
             ps.setString(6,itemN.getSelectedItem().toString());
           ps.setString(7, itemCa.getSelectedItem().toString());
           // ps.setString(8, itemCo.getText());
             ps.setString(8, stockT.getText());
             ps.setString(9, quanTF.getText());
            ps.setString(10, SellR.getText());
           
              ps.setString(11, warr.getSelectedItem().toString());
               ps.setString(12, purR.getText());
                ps.setString(13, subTotalSum.getText());
                  ps.setString(14, disT.getText());
                     ps.setString(15, GrT.getText());
                    
                        ps.setString(16, paid.getText());
                        
                         
                        int gt=Integer.parseInt(GrT.getText());
                        double tp=Double.parseDouble(GtotalPur.getText());
                        double p0=gt-tp;
                        String profit=String.valueOf(p0);
                        
                        
                         ps.setString(17,profit);
                         ps.setString(18,GtotalPur.getText());
                           ps.setString(19,disDiduc.getText());
                           ps.setString(20,chan.getText());
               
//                  ps.setString(11, disT.getText());
//                    ps.setString(12, total.getText());
//                      ps.setString(13, paid.getText());
                    
                     
                      // ps.setString(14, chan.getText());       
          
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sale Successfully");
             
//             ps=con.prepareStatement("insert into sale_invoice(invoice_no,customer_name)values(?,?)");
//             ps.setString(1, invo.getText());
//             ps.setString(2, Cust.getText());
//             ps.executeUpdate();
//             
        } catch (Exception e) {
             // JOptionPane.showMessageDialog(null, "Data not Inserted");
              System.out.println(e.getMessage());
        }
          
          
          
            String sqll="update customer set balance=balance+"+chan.getText()+" where mobile_no=?";
        
        try {
            ps=con.prepareStatement(sqll);
            
            ps.setString(1, mobT.getText());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
          
          
       try {
            String sq="select count(*) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, dateT.getText());
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
            String sq="select sum(grand_total) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
           ps.setString(1, dateT.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(grand_total)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tsale.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        try {
            String sq="select sum(commission_deduction) from e_computer.sale_invoice where date=? ";
            ps=con.prepareStatement(sq);
            ps.setString(1, dateT.getText());
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
            String sq="select sum(paid) from e_computer.sale_invoice where date=?  ";
            ps=con.prepareStatement(sq);
           ps.setString(1, dateT.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String s=rs.getString("sum(paid)");
                //System.out.println(rs.getString("sum(sub_total)"));
               
                tpaid.setText(s);
                 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
             
          //Sale code
          
          try{

            
            String str="select * from sale_tem where invoice_no = ?";
            ps=con.prepareStatement(str);
            ps.setString(1, invo.getText());
            ResultSet rs2;
            rs2=ps.executeQuery();
            while(rs2.next())
            {
                PreparedStatement ps2;
                String item_code=rs2.getString("item_code");
                Integer qnty=rs2.getInt("quantity");
                ps2=con.prepareStatement("update stock set total_stock=total_stock-"+qnty+" where  item_code="+item_code);
           // ps.setString(1,stockT.getText());
           // ps.setString(1,itemcode.getText());
                ps2.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         
                 
        try {
            String del="delete from sale_tem";
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
            String del="delete from sale_tem";
            ps=con.prepareStatement(del);
             
            //ps.setString(1, invo.getText());
            
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(rootPane, "Delete Successfully");
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(rootPane, "Delete Failled");
        }
          
          
        
    }//GEN-LAST:event_saveBTNActionPerformed

    private void GrTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrTActionPerformed

    private void GrTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrTKeyPressed

    private void GrTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GrTKeyReleased

    private void brandComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboActionPerformed

    private void brandComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandComboKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboKeyReleased

    private void brandComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandComboKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void mobTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobTKeyTyped
      char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_mobTKeyTyped

    private void quanTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanTFKeyTyped

        char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }
      
    }//GEN-LAST:event_quanTFKeyTyped

    private void SellRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SellRKeyTyped
         char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }          
    }//GEN-LAST:event_SellRKeyTyped

    private void stockTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTKeyTyped
        char c=evt.getKeyChar();
      if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
          getToolkit().beep();
          evt.consume();
    }  
      
      
      
      
      
    }//GEN-LAST:event_stockTKeyTyped

    private void quanTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanTFKeyPressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_quanTFKeyPressed

    private void totalPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalPKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPKeyReleased

    private void totalPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPActionPerformed

    private void custNPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_custNPopupMenuWillBecomeInvisible
         String ven=(String)custN.getSelectedItem();
        String sql="select mobile_no,address from customer where customer_name=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, ven);
            rs=ps.executeQuery();
            if(rs.next()){
                String add=rs.getString("mobile_no");
                
                mobT.setText(add);
                  String add1=rs.getString("address");
                 Add.setText(add1);
                 
                 
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_custNPopupMenuWillBecomeInvisible

    private void tablePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePMouseClicked
        try{

            ResultSet rs2;
            PreparedStatement ps2;
            Connection con;
            con=DbConn.dbConnection();
            int row= tableP.getSelectedRow();
            String table_click=tableP.getModel().getValueAt(row, 0).toString();
            String sql= "select  brand_name,item_name,item_category,item_code,quantity,selling_rate,purchase_rate,warranty,sub_total,id from sale_tem where id = '" + table_click + "'";
            ps2=con.prepareStatement(sql);
            rs2=  ps2.executeQuery();
            if(rs2.next()){
                String add1=rs2.getString("brand_name");
                brandCombo.setSelectedItem(add1);
                 String add2=rs2.getString("item_name");
                itemN.setSelectedItem(add2);
                String add3=rs2.getString("item_category");
                itemCa.setSelectedItem(add3);
                String add4=rs2.getString("item_code");
                itemCo.setText(add4);
                
                String add5=rs2.getString("quantity");
                quanTF.setText(add5);
                 String add6=rs2.getString("selling_rate");
                SellR.setText(add6);
                String add7=rs2.getString("purchase_rate");
                purR.setText(add7);
               
                String add8=rs2.getString("warranty");
                warr.setSelectedItem(add8);
                String add9=rs2.getString("sub_total");
                subT.setText(add9);
               

            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        } 
    }//GEN-LAST:event_tablePMouseClicked
 public void getData(){
         String sql="select id as 'ID', invoice_no as 'Invo', item_category as 'ItCate',item_code as 'ItCode',item_name as 'ItName',stock as Stock ,quantity as 'Qnty',selling_rate as 'UnPrice',sub_total as 'STotal' from sale_tem   where invoice_no=?";  
         try{
          
         ps=con.prepareStatement(sql);
         ps.setString(1,invo.getText());
          rs= ps.executeQuery();
         tableP.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDBTN;
    private javax.swing.JTextField Add;
    private javax.swing.JTextField GrT;
    private javax.swing.JTextField GtotalPur;
    private javax.swing.JButton PrintBTN;
    private javax.swing.JTextField SellR;
    private javax.swing.JLabel StockBTN;
    private javax.swing.JComboBox brandCombo;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTextField chan;
    private javax.swing.JComboBox custN;
    private javax.swing.JTextField dateT;
    private javax.swing.JTextField disDiduc;
    private javax.swing.JTextField disT;
    private GUI.ImagePanel imagePanel1;
    public javax.swing.JTextField invo;
    private javax.swing.JComboBox itemCa;
    private javax.swing.JTextField itemCo;
    private javax.swing.JComboBox itemN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField paid;
    private javax.swing.JTextField purR;
    private javax.swing.JTextField quanTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField stockT;
    private javax.swing.JTextField subT;
    private javax.swing.JTextField subTotalSum;
    private javax.swing.JTable tableP;
    private javax.swing.JTextField tcommission;
    private javax.swing.JTextField tinvoice;
    private javax.swing.JTextField totalP;
    private javax.swing.JTextField tpaid;
    private javax.swing.JTextField tsale;
    private javax.swing.JComboBox warr;
    // End of variables declaration//GEN-END:variables

    
    public void loadCombo(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(warranty) from item order by warranty");
            while(rs.next()){
            plist.add(rs.getString("warranty"));
             
            
            }
            warr.setModel(new DefaultComboBoxModel(plist.toArray()));
            warr.insertItemAt("Select warranty", 0);
            warr.setSelectedIndex(0);
            
           
            
            
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
            itemN.insertItemAt("Select Item Name", 0);
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
             
            
            }
            brandCombo.setModel(new DefaultComboBoxModel(plist.toArray()));
            brandCombo.insertItemAt("Select Brand", 0);
            brandCombo.setSelectedIndex(0);
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }
}
 
 public void loadCombo4(){
        try {
            Connection con=DbConn.dbConnection();
            Statement stmt=con.createStatement();
            List plist= new ArrayList();
            ResultSet rs=stmt.executeQuery("select distinct(customer_name) from customer order by customer_name");
            while(rs.next()){
            plist.add(rs.getString("customer_name"));
             
            
            }
            custN.setModel(new DefaultComboBoxModel(plist.toArray()));
             custN.insertItemAt("", 0);
             custN.setSelectedIndex(0);
            
           
            
            
        } catch (Exception e) {
    
            e.printStackTrace();
        }
}
 
}
