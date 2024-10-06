package hardwarestore;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.*;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */





/**
 *
 * @author BHUSHAN
 */
public class Items extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst=null;
    ResultSet Rs=null;
    Statement St=null;
    DefaultTableModel model;
   // prepareStatement ps;
    
    public Items() {
        initComponents();
        DisplayItems();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("MAHALAXMI HARDWARE STORE");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/close.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("MAHALAXMI HARDWARE STORE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(449, 449, 449)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 850, 10));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/employee.png"))); // NOI18N
        jLabel1.setText("SELLERS");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/report.png"))); // NOI18N
        jLabel2.setText("DASHBOARD");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/Logout_1.png"))); // NOI18N
        jButton4.setText("LOGOUT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(jLabel2)
                .addGap(152, 152, 152)
                .addComponent(jButton4)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/product.png"))); // NOI18N
        jLabel3.setText("MANAGE ITEMS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("NAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 128, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("QUANTITY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 128, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("PRICE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 128, 50, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("CATEGORIES");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 128, -1, -1));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 168, 126, -1));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 168, 125, -1));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 168, 125, -1));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLUMBING ", "ELECTRICAL" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 168, 125, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ItId", "ItName", "ItQty", "ItPrice", "ItCat"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 1030, 380));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/Add new.png"))); // NOI18N
        jButton1.setText("ADD");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 120, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/update.png"))); // NOI18N
        jButton2.setText("EDIT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 279, 120, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/report.png"))); // NOI18N
        jLabel8.setText("ITEM STOCK");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 337, -1, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 204));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/delete-button.png"))); // NOI18N
        jButton5.setText("DELETE");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 120, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/search.png"))); // NOI18N
        jLabel11.setText("Search ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        txt_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        getContentPane().add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DisplayItems(){
        try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
            St=con.createStatement();
            
            Rs=St.executeQuery("select * from itemstbl");
            //itemstbl.getModel(DbUtils.resultSetToTableModel(Rs));
            
            while (Rs.next()) {                
                Vector v = new Vector();
                
                v.add(Rs.getInt(1));
                v.add(Rs.getString(2));
                v.add(Rs.getInt(3));
                v.add(Rs.getInt(4));
                v.add(Rs.getString(5));
               // v.add(Rs.getInt(6));
                
                dt.addRow(v);
                clear();
                
                
            }
            
          
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void search(String str){
         model =(DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    } 
   
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        if(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jComboBox1.getSelectedIndex()== -1)
        {
           JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
        String name = jTextField1.getText(); 
        int price = Integer.parseInt(jTextField2.getText());
        int qty = Integer.parseInt(jTextField3.getText());
        String cat = (String)jComboBox1.getSelectedItem();
        System.out.println(name +" "+ price+""+qty+""+cat);
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
                //String query="insert into Itemstbl values(?,?,?,?)"; 
                String query = "INSERT INTO `itemstbl`(`ItName`, `ItQty`, `ItPrice`, `ItCat`) VALUES (?,?,?,?)";
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
                
               pst.setString(1,name);
               pst.setInt(2,price);
               pst.setInt(3,qty);
               pst.setString(4,cat);
               pst.executeUpdate();
                con.close();
                DisplayItems();
                clear();
                
                JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
                    System.out.println(e);
                
            }
        }
        
    }//GEN-LAST:event_jButton1MouseClicked
    int key=0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int myindex=jTable1.getSelectedRow();
        key=Integer.valueOf(model.getValueAt(myindex, 0).toString());
        jTextField1.setText(model.getValueAt(myindex, 1).toString());
        jTextField2.setText(model.getValueAt(myindex, 2).toString());
        jTextField3.setText(model.getValueAt(myindex, 3).toString());
        jComboBox1.setSelectedItem(model.getValueAt(myindex, 4).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        if (key==0) {
            JOptionPane.showMessageDialog(this,"Select The Items");
        } else {
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
                String Query="Delete from itemstbl where ItId="+key;
                Statement del = con.createStatement();
                del.executeUpdate(Query);
                JOptionPane.showMessageDialog(this,"Items Deleted");
                clear();
                DisplayItems();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void clear(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
       // jTextField3.setText("");
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        try {
            String UpdateQuery="Update itemstbl set ItName=?,ItQty=?,ItPrice=?,ItCat=? where ItId=?";
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
            PreparedStatement ps=con.prepareStatement(UpdateQuery);
            
            ps.setString(1, jTextField1.getText());
            ps.setInt(2,Integer.valueOf(jTextField2.getText()));
            ps.setInt(3,Integer.valueOf(jTextField3.getText()));
            ps.setString(4, jComboBox1.getSelectedItem().toString());
            ps.setInt(5, key);
            if (ps.executeUpdate()==1) {
                DisplayItems();
                JOptionPane.showMessageDialog(this,"Items Updated");
                
            } else {
               JOptionPane.showMessageDialog(this,"Missing Information"); 
               clear();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Sellers s= new Sellers();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Dashboard d=new Dashboard();
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Are You Shure..!!");
        login l=new login();
        l. setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        String search=txt_search.getText();
        search(search);
    }//GEN-LAST:event_txt_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

    private static class ItName {

        private static void setText(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public ItName() {
        }
    }


}
