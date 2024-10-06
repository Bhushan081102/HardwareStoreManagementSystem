
package hardwarestore;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.dynalink.StandardNamespace;


public class Selling extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst=null;
    ResultSet Rs=null;
    Statement St=null;

   
    
    public Selling() {
        initComponents();
        DisplayItems();
        ShowDate();
        UpdateQty();
    }
    public void bill(){
        
      //Area.setText(Area.getText()+"================================================================================================================\n");
        Area.setText(Area.getText()+"----------------------------------------------------------------------------------------------------------------\n");
        Area.setText(Area.getText()+"  \t\t MAHALAXMI HARDWARE STORE  \n " );
        Date obj = new Date();
        String date = obj.toString();
        
        Area.setText(Area.getText()+"\t\t               \t\t"+date+"\n");
        //Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
        
        String Customer_Name = CustomerName.getText();
        Area.setText(Area.getText()+"Customer Name :-  ");
        Area.setText(Area.getText()+Customer_Name+"\t");

        Area.setText(Area.getText()+"------------------------------------------------------------------------------\n");
        
               
        DefaultTableModel model=(DefaultTableModel)BillTable.getModel();
        Area.setText(Area.getText()+"Item Name"+"\t"+"Price"+"\t"+"Quantity"+"\t"+"\n");
        for(int i=0;i<BillTable.getRowCount();i++){
           // Customer_Name = jTable1.getValueAt(i,0).toString();
            String Item_Name = BillTable.getValueAt(i,2).toString();
            String Unit_Price = BillTable.getValueAt(i,3).toString();
            String Quantity = BillTable.getValueAt(i,4).toString();
           
            Area.setText(Area.getText()+Item_Name+"\t"+Unit_Price+"\t"+ Quantity+"\t"+"\n");
            
          
        }
        Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
        String Total_Price = TotalLbl1.getText();

            Area.setText(Area.getText()+"Total Price\t");
             Area.setText(Area.getText()+Total_Price+"\n");
           
            Area.setText(Area.getText()+"\n");
            Area.setText(Area.getText()+"---------------------------------------------------------------------------------------------------------------\n");
            //Area.setText(Area.getText()+"============================================================================================================\n");
            Area.setText(Area.getText()+"\t\t   Thanks For Visit!!!   \n");
            //Area.setText(Area.getText()+"=============================================\n");

            
        

        
    }
     private void clear(){
        
//        passwordTb.setText("");
//        phoneTb.setText("");
    }
    int SellerId;
    public Selling(String Sname,int SId){
        initComponents();
       // SNameLbl.setText(Sname);
        SellerId=SId;
    }
           
            int BId;
    
    private void CountBills(){
        try {
            St=con.createStatement();
            Rs=St.executeQuery("select Max(Bid) from sellstbl");
            Rs.next();
            int Billid = Rs.getInt(1)+1;
        
          
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void InsertBill(){
        try {
                CountBills();
                //String name = jTextField1.getText(); 
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
                //PreparedStatement pst=con.prepareStatement("insert into sellertbl values(?,?,?,?)");
//                 String query = "INSERT INTO `sellstbl`('SName','BDate','BAmt') VALUES (?,?,?)";
               //String query = "INSERT INTO `sellstbl`(`Sid`, `SName`, `BDate`, `BAmt`) VALUES (?,?,?,?)";
               String query = "INSERT INTO sellstbl VALUES (?,?,?,?,?)";
              // PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
              PreparedStatement pst=con.prepareStatement(query);
               pst.setInt(1,BId);
               pst.setInt(2,1 );
               pst.setString(3,jTextField1.getText());
               pst.setString(4,TodayDate.getText());
               pst.setInt(5,GrdTot);
               int rows= pst.executeUpdate();
               JOptionPane.showMessageDialog(this,"Bill Added");
                
                con.close();
                //DisplaySellers();
                 //clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
    }
    
    private void UpdateQty(){
        
            try {
            int newQty = AvailQty - Integer.valueOf(jTextField3.getText());
            String UpdateQuery="Update itemstbl set ItQty=? where ItId=?";
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
            PreparedStatement ps=con.prepareStatement(UpdateQuery);
            
           // ps.setString(0, "Name");
            ps.setInt(1, newQty);
            ps.setInt(2,key);
           // ps.setString(3,jTextField3.getText());
           //ps.setInt(3,1000);
           ps.executeUpdate();
            if (ps.executeUpdate()==1) {
               
                JOptionPane.showMessageDialog(this,"Items Updated");
                 DisplayItems();
                //clear();
                
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
            
        }
    
     private void DisplayItems(){
        try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardwaredb","root","");
            St=con.createStatement();
            
            Rs=St.executeQuery("select ItId,ItName,ItQty,ItPrice from itemstbl");
            //itemstbl.getModel(DbUtils.resultSetToTableModel(Rs));
            
            while (Rs.next()) {                
                Vector v = new Vector();
                
                v.add(Rs.getInt(1));
                v.add(Rs.getString(2));
                v.add(Rs.getInt(3));
                v.add(Rs.getInt(4));
                //v.add(Rs.getString(5));
                
                dt.addRow(v);
                //DisplayItems();
                //clear();
                
                
            }
            
          
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Addbtn = new javax.swing.JButton();
        Printbtn = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TodayDate = new javax.swing.JLabel();
        TotalLbl1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CustomerName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Area = new javax.swing.JTextArea();
        btnbill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("MAHALAXMI HARDWARE STORE ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/close.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(488, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(465, 465, 465)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/Logout_1.png"))); // NOI18N
        jLabel2.setText("LOGOUT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel2)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/bill.png"))); // NOI18N
        jLabel3.setText("BILLING TABLE");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("NAME");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("PRICE");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("QUANTITY");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        Addbtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Addbtn.setForeground(new java.awt.Color(0, 153, 204));
        Addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/add to cart.png"))); // NOI18N
        Addbtn.setText("ADD TO BILL");
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        Printbtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Printbtn.setForeground(new java.awt.Color(0, 153, 204));
        Printbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/print.png"))); // NOI18N
        Printbtn.setText("PRINT");
        Printbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintbtnMouseClicked(evt);
            }
        });
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });

        Clearbtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Clearbtn.setForeground(new java.awt.Color(0, 153, 204));
        Clearbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/yes.png"))); // NOI18N
        Clearbtn.setText("CLEAR");
        Clearbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearbtnMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ItId", "ItName", "ItQty", "ItPrice"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/report.png"))); // NOI18N
        jLabel8.setText("ITEM STOCK");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardwarestore/generate bill & print.png"))); // NOI18N
        jLabel9.setText("BILLING");

        TodayDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TodayDate.setText("DATE");

        TotalLbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TotalLbl1.setText("TOTAL");
        TotalLbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalLbl1MouseClicked(evt);
            }
        });

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "Name", "Price", "Quantity"
            }
        ));
        BillTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(BillTable);
        if (BillTable.getColumnModel().getColumnCount() > 0) {
            BillTable.getColumnModel().getColumn(0).setMinWidth(0);
            BillTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            BillTable.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("CUSTOMER");

        Area.setColumns(20);
        Area.setRows(5);
        jScrollPane2.setViewportView(Area);

        btnbill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnbill.setText("Bill");
        btnbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(Addbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(TodayDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Printbtn)
                        .addGap(208, 208, 208)
                        .addComponent(Clearbtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TotalLbl1)
                            .addGap(160, 160, 160)
                            .addComponent(btnbill, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addComponent(Addbtn)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TodayDate)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalLbl1)
                            .addComponent(btnbill))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Printbtn)
                            .addComponent(Clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   int GrdTot=0;
    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
     
        String name = CustomerName.getText();
        boolean numeric = true;
        
        try {
            Double num = Double.parseDouble(name);
        } catch (Exception e) {
            numeric = false;
        }
        
        if(numeric){
            JOptionPane.showMessageDialog(this,"Please Enter Valid Name..");
        }
        else if(jTextField1.getText().isEmpty() || jTextField3.getText().isEmpty()){
          JOptionPane.showMessageDialog(this,"Missing infomation..!!");
          
      }else if(AvailQty <= Integer.valueOf(jTextField3.getText())){
          JOptionPane.showMessageDialog(this, "Not Enough In Stock");
      }else{
       
       int Total=Integer.valueOf(jTextField2.getText()) * Integer.valueOf(jTextField3.getText());
       GrdTot=GrdTot+Total;
       TotalLbl1.setText("Rs "+GrdTot);
       DefaultTableModel model=(DefaultTableModel) BillTable.getModel();
       String nextRowId=Integer.toString(model.getRowCount());
       model.addRow(new Object[]{
        Integer.valueOf(nextRowId)+1,
        CustomerName.getText(),   
        jTextField1.getText(),
        jTextField2.getText(),
        jTextField3.getText(),
        
        Total
    });
       UpdateQty();
      }
        
    

    }//GEN-LAST:event_AddbtnMouseClicked

    private void PrintbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintbtnMouseClicked
        // TODO add your handling code here:
        try {
//            BillText.print();
           // InsertBill();
           // jTable1.print();
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(this, e);
        }
       
    }//GEN-LAST:event_PrintbtnMouseClicked

    private void ShowDate(){
        Date d=new Date();
        SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
        TodayDate.setText(s.format(d));
        
        
    }
    private void Clear(){
       // BillText.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        //TodayDate.setText("");
        CustomerName.setText("");
        TotalLbl1.setText("");
        Area.setText("");
        i=0;
        
    }
    private void ClearbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbtnMouseClicked
        // TODO add your handling code here:
       BillTable.setModel(new DefaultTableModel(null,new String[]{"Customer","Name","Price","Quantity"})); 
       Clear();
    }//GEN-LAST:event_ClearbtnMouseClicked
    int key=0;
    int AvailQty;
    int i=0;
    int GrdTotal=0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int myindex=jTable1.getSelectedRow();
        key=Integer.valueOf(model.getValueAt(myindex, 0).toString());
        jTextField1.setText(model.getValueAt(myindex, 1).toString());
        AvailQty=Integer.valueOf(model.getValueAt(myindex,2).toString());
        jTextField2.setText(model.getValueAt(myindex, 3).toString());
        
       // jTextField3.setText(model.getValueAt(myindex, 3).toString());
        UpdateQty();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Items i=new Items();
        JOptionPane.showMessageDialog(this, "Are You sure..!!");
        i.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddbtnActionPerformed

    private void BillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BillTableMouseClicked

    private void TotalLbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalLbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalLbl1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed
        // TODO add your handling code here:
        try{
            Area.print();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

    private void btnbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbillActionPerformed
        // TODO add your handling code here:
        bill();
        //BillTable.setModel(new DefaultTableModel(null,new String[]{"Customer","Name","Price","Quantity"})); 
        //Clear();
//        DefaultTableModel MODEL=(DefaultTableModel) BillTable.getModel();
//        MODEL.setRowCount(0);
    }//GEN-LAST:event_btnbillActionPerformed

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTextArea Area;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JButton Printbtn;
    private javax.swing.JLabel TodayDate;
    private javax.swing.JLabel TotalLbl1;
    private javax.swing.JButton btnbill;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
