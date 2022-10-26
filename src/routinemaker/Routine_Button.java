package routinemaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Routine_Button extends javax.swing.JFrame {
    Connection conn;
    private JButton t[] = new JButton[30];
    ArrayList<String>courses = new ArrayList<>();
    DefaultTableModel tm1 = null;
    DefaultTableModel tm2 = null;
    
    
    public Routine_Button()  {
        this.setResizable(false);
        this.setTitle("Routine Maker");
        
         
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Routine_Button.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Routine_Button.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Routine_Button.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Routine_Button.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tm1 = (DefaultTableModel)teacherScheduleTable.getModel();
        tm2 = (DefaultTableModel)roomScheduleTable.getModel();
        tm1.setRowCount(0);
        tm2.setRowCount(0);
        
        conn = JConnection.ConnecrDb();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT term FROM terms ORDER BY term ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                termsCmb.addItem(s);
            }
        }catch(Exception e){}
        
        teachersCmb.addItem("ALL");
        roomsCmb.addItem("ALL");
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT name FROM faculties ORDER BY name ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                teachersCmb.addItem(s);
            }
        }catch(Exception e){}
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT room FROM rooms ORDER BY room ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                roomsCmb.addItem(s);
            }
        }catch(Exception e){}
        
        for(int i=1; i<=15; i++){
            levelsCmb.addItem(i+"");
            if(i>4) continue;
            char c = (char)(i+64);
            secsCmb.addItem(c+"");
        }
        
        t[0]=p0;
        t[1]=p1;
        t[2]=p2;
        t[3]=p3;
        t[4]=p4;
        t[5]=p5;
        t[6]=p6;
        t[7]=p7;
        
        t[8]=p8;
        t[9]=p9;
        t[10]=p10;
        t[11]=p11;
        t[12]=p12;
        t[13]=p13;
        t[14]=p14;
        t[15]=p15;
        
        t[16]=p16;
        t[17]=p17;
        t[18]=p18;
        t[19]=p19;
        t[20]=p20;
        t[21]=p21;
       
        t[22]=p22;
        t[23]=p23;
        t[24]=p24;
        t[25]=p25;
        t[26]=p26;
        t[27]=p27;
        t[28]=p28;
        t[29]=p29;
        
        secsCmb.setSelectedIndex(0);
        teachersCmb.setSelectedIndex(1);
        roomsCmb.setSelectedIndex(0);
        remainingEdt.setEditable(false);
        
        JFrame frame = this;
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                Menu m = new Menu();
                m.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
    
    void loadTable(DefaultTableModel tm){
        for(int i=0; i<=6; i++) tm.addRow(ScheduleFinder.o[i]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p0 = new javax.swing.JButton();
        p1 = new javax.swing.JButton();
        p2 = new javax.swing.JButton();
        p3 = new javax.swing.JButton();
        p4 = new javax.swing.JButton();
        p5 = new javax.swing.JButton();
        p6 = new javax.swing.JButton();
        p7 = new javax.swing.JButton();
        p8 = new javax.swing.JButton();
        p9 = new javax.swing.JButton();
        p10 = new javax.swing.JButton();
        p11 = new javax.swing.JButton();
        p12 = new javax.swing.JButton();
        p13 = new javax.swing.JButton();
        p14 = new javax.swing.JButton();
        p15 = new javax.swing.JButton();
        p16 = new javax.swing.JButton();
        p17 = new javax.swing.JButton();
        p18 = new javax.swing.JButton();
        p19 = new javax.swing.JButton();
        p20 = new javax.swing.JButton();
        p21 = new javax.swing.JButton();
        p22 = new javax.swing.JButton();
        p23 = new javax.swing.JButton();
        p24 = new javax.swing.JButton();
        p25 = new javax.swing.JButton();
        p26 = new javax.swing.JButton();
        p27 = new javax.swing.JButton();
        p28 = new javax.swing.JButton();
        p29 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        termsCmb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        secsCmb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        levelsCmb = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        remainingEdt = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomScheduleTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherScheduleTable = new javax.swing.JTable();
        teachersCmb = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        teacherEdt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        roomsCmb = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        roomEdt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("MON");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("TUE");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("WED");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("THU");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("SUN");

        p0.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p0ActionPerformed(evt);
            }
        });

        p1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });

        p2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });

        p3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p3ActionPerformed(evt);
            }
        });

        p4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p4ActionPerformed(evt);
            }
        });

        p5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p5ActionPerformed(evt);
            }
        });

        p6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p6ActionPerformed(evt);
            }
        });

        p7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p7ActionPerformed(evt);
            }
        });

        p8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p8ActionPerformed(evt);
            }
        });

        p9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p9ActionPerformed(evt);
            }
        });

        p10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p10ActionPerformed(evt);
            }
        });

        p11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p11ActionPerformed(evt);
            }
        });

        p12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p12ActionPerformed(evt);
            }
        });

        p13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p13ActionPerformed(evt);
            }
        });

        p14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p14ActionPerformed(evt);
            }
        });

        p15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p15ActionPerformed(evt);
            }
        });

        p16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p16ActionPerformed(evt);
            }
        });

        p17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p17ActionPerformed(evt);
            }
        });

        p18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p18ActionPerformed(evt);
            }
        });

        p19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p19ActionPerformed(evt);
            }
        });

        p20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p20ActionPerformed(evt);
            }
        });

        p21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p21ActionPerformed(evt);
            }
        });

        p22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p22ActionPerformed(evt);
            }
        });

        p23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p23ActionPerformed(evt);
            }
        });

        p24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p24ActionPerformed(evt);
            }
        });

        p25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p25ActionPerformed(evt);
            }
        });

        p26.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p26ActionPerformed(evt);
            }
        });

        p27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p27ActionPerformed(evt);
            }
        });

        p28.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p28ActionPerformed(evt);
            }
        });

        p29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        p29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p29ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("2");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("1");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("3");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("4");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("5");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("6");

        jButton5.setText("VIEW COMMON SCHEDULE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CLEAR TEACHER TABLE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("CLEAR ROOM TABLE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("SHOW REMAINING COURSES");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p0, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p24, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p25, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p22, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p23, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(p27, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p28, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p29, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel10)
                .addGap(94, 94, 94)
                .addComponent(jLabel11)
                .addGap(84, 84, 84)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(94, 94, 94)
                .addComponent(jLabel14)
                .addGap(84, 84, 84)
                .addComponent(jLabel15)
                .addGap(59, 59, 59))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(261, Short.MAX_VALUE))
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel5)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel7)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p0, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("TERM");

        termsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        termsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termsCmbActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("SECTION");

        secsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secsCmbActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("LEVEL");

        levelsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        levelsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelsCmbActionPerformed(evt);
            }
        });

        remainingEdt.setColumns(20);
        remainingEdt.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        remainingEdt.setRows(5);
        jScrollPane3.setViewportView(remainingEdt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(termsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(levelsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(termsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(secsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(levelsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane3)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roomScheduleTable.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        roomScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "P1", "P2", "P3", "P4", "P5", "P6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(roomScheduleTable);

        teacherScheduleTable.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        teacherScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "P1", "P2", "P3", "P4", "P5", "P6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(teacherScheduleTable);

        teachersCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        teachersCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersCmbActionPerformed(evt);
            }
        });

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        teacherEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherEdtActionPerformed(evt);
            }
        });

        jButton2.setText("SEARCH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        roomsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsCmbActionPerformed(evt);
            }
        });

        jButton3.setText("SEARCH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        roomEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomEdtActionPerformed(evt);
            }
        });

        jButton4.setText("SEARCH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(teacherEdt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(teachersCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, 657, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(roomEdt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomsCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, 653, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(teachersCmb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherEdt)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomsCmb, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomEdt)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p0ActionPerformed
        setCourse(0); 
    }//GEN-LAST:event_p0ActionPerformed

    private void termsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termsCmbActionPerformed
        load();
    }//GEN-LAST:event_termsCmbActionPerformed

    private void levelsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelsCmbActionPerformed
        load();
    }//GEN-LAST:event_levelsCmbActionPerformed

    private void secsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secsCmbActionPerformed
        load();
    }//GEN-LAST:event_secsCmbActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        // TODO add your handling code here:
        setCourse(1);
    }//GEN-LAST:event_p1ActionPerformed

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        // TODO add your handling code here:
        setCourse(2);
    }//GEN-LAST:event_p2ActionPerformed

    private void p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p3ActionPerformed
        // TODO add your handling code here:
        setCourse(3);
    }//GEN-LAST:event_p3ActionPerformed

    private void p4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p4ActionPerformed
        // TODO add your handling code here:
        setCourse(4);
    }//GEN-LAST:event_p4ActionPerformed

    private void p5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p5ActionPerformed
        // TODO add your handling code here:
        setCourse(5);
    }//GEN-LAST:event_p5ActionPerformed

    private void p6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p6ActionPerformed
        // TODO add your handling code here:
        setCourse(6);
    }//GEN-LAST:event_p6ActionPerformed

    private void p7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p7ActionPerformed
        // TODO add your handling code here:
        setCourse(7);
    }//GEN-LAST:event_p7ActionPerformed

    private void p8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p8ActionPerformed
        // TODO add your handling code here:
        setCourse(8);
    }//GEN-LAST:event_p8ActionPerformed

    private void p9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p9ActionPerformed
        // TODO add your handling code here:
        setCourse(9);
    }//GEN-LAST:event_p9ActionPerformed

    private void p10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p10ActionPerformed
        // TODO add your handling code here:
        setCourse(10);
    }//GEN-LAST:event_p10ActionPerformed

    private void p11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p11ActionPerformed
        // TODO add your handling code here:
        setCourse(11);
    }//GEN-LAST:event_p11ActionPerformed

    private void p12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p12ActionPerformed
        // TODO add your handling code here:
        setCourse(12);
    }//GEN-LAST:event_p12ActionPerformed

    private void p13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p13ActionPerformed
        // TODO add your handling code here:
        setCourse(13);
    }//GEN-LAST:event_p13ActionPerformed

    private void p14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p14ActionPerformed
        // TODO add your handling code here:
        setCourse(14);
    }//GEN-LAST:event_p14ActionPerformed

    private void p15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p15ActionPerformed
        // TODO add your handling code here:
        setCourse(15);
    }//GEN-LAST:event_p15ActionPerformed

    private void p16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p16ActionPerformed
        // TODO add your handling code here:
        setCourse(16);
    }//GEN-LAST:event_p16ActionPerformed

    private void p17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p17ActionPerformed
        // TODO add your handling code here:
        setCourse(17);
    }//GEN-LAST:event_p17ActionPerformed

    private void p18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p18ActionPerformed
        // TODO add your handling code here:
        setCourse(18);
    }//GEN-LAST:event_p18ActionPerformed

    private void p19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p19ActionPerformed
        // TODO add your handling code here:
        setCourse(19);
    }//GEN-LAST:event_p19ActionPerformed

    private void p20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p20ActionPerformed
        // TODO add your handling code here:
        setCourse(20);
    }//GEN-LAST:event_p20ActionPerformed

    private void p21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p21ActionPerformed
        // TODO add your handling code here:
        setCourse(21);
    }//GEN-LAST:event_p21ActionPerformed

    private void p22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p22ActionPerformed
        // TODO add your handling code here:
        setCourse(22);
    }//GEN-LAST:event_p22ActionPerformed

    private void p23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p23ActionPerformed
        // TODO add your handling code here:
        setCourse(23);
    }//GEN-LAST:event_p23ActionPerformed

    private void p24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p24ActionPerformed
        // TODO add your handling code here:
        setCourse(24);
    }//GEN-LAST:event_p24ActionPerformed

    private void p25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p25ActionPerformed
        // TODO add your handling code here:
        setCourse(25);
    }//GEN-LAST:event_p25ActionPerformed

    private void p26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p26ActionPerformed
        // TODO add your handling code here:
        setCourse(26);
    }//GEN-LAST:event_p26ActionPerformed

    private void p27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p27ActionPerformed
        // TODO add your handling code here:
        setCourse(27);
    }//GEN-LAST:event_p27ActionPerformed

    private void p28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p28ActionPerformed
        // TODO add your handling code here:
        setCourse(28);
    }//GEN-LAST:event_p28ActionPerformed

    private void p29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p29ActionPerformed
        // TODO add your handling code here:
        setCourse(29);
    }//GEN-LAST:event_p29ActionPerformed

    private void teachersCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teachersCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teachersCmbActionPerformed

    private void roomsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomsCmbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String term = termsCmb.getSelectedItem().toString();
        String name = teachersCmb.getSelectedItem().toString();
        ///tm1.setRowCount(0);
        if(name.equals("ALL")){
            for(int i=2; i<teachersCmb.getItemCount(); i++){
                String n = teachersCmb.getItemAt(i) + "";
                System.out.println("Name: " + n);
                ScheduleFinder.findSchedule(term, n, 8);
                loadTable(tm1);
            }
            return;
        }
        ScheduleFinder.findSchedule(term, name, 8);
        loadTable(tm1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CommonSchedule c = new CommonSchedule();
        c.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    void textActionTeacher(){
        String name = teacherEdt.getText().toString().trim().toUpperCase();
        int flag = 0;
        for(int i=2; i<teachersCmb.getItemCount(); i++){
            String s = teachersCmb.getItemAt(i) + "";
            if(s.equals(name)){
                flag = 1;
                break;
            }
        }
        if(flag==0){
            JOptionPane.showMessageDialog(null, name + " not found!", "Sorry!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ScheduleFinder.findSchedule(termsCmb.getSelectedItem().toString(), name, 8);
        loadTable(tm1);
    }
    
    void textActionRoom(){
        String name = roomEdt.getText().toString().trim().toUpperCase();
        int flag = 0;
        for(int i=1; i<roomsCmb.getItemCount(); i++){
            String s = roomsCmb.getItemAt(i) + "";
            if(s.equals(name)){
                flag = 1;
                break;
            }
        }
        
        if(flag==0){
            JOptionPane.showMessageDialog(null, name + " not found!", "Sorry!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ScheduleFinder.findSchedule(termsCmb.getSelectedItem().toString(), name, 2);
        loadTable(tm2);

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        textActionTeacher();
        teacherEdt.setText("");
        teacherEdt.requestFocusInWindow();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void teacherEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherEdtActionPerformed
        textActionTeacher();
        teacherEdt.setText("");
        teacherEdt.requestFocusInWindow();
    }//GEN-LAST:event_teacherEdtActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tm1.setRowCount(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        tm2.setRowCount(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setRemaining();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String term = termsCmb.getSelectedItem().toString();
        String name = roomsCmb.getSelectedItem().toString();
        ///tm1.setRowCount(0);
        if(name.equals("ALL")){
            for(int i=1; i<roomsCmb.getItemCount(); i++){
                String n = roomsCmb.getItemAt(i) + "";
                System.out.println("Name: " + n);
                ScheduleFinder.findSchedule(term, n, 2);
                loadTable(tm2);
            }
            return;
        }
        ScheduleFinder.findSchedule(term, name, 2);
        loadTable(tm2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void roomEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomEdtActionPerformed
        textActionRoom();
        roomEdt.setText("");
        roomEdt.requestFocusInWindow();
    }//GEN-LAST:event_roomEdtActionPerformed

    int used(int code){
        String cd = code + "";
        int cnt = 0;
        for(int i=0; i<30; i++){
            String s = t[i].getText();
            if(s.equals(cd)) cnt++;
        }
        return cnt;
    }
    
    void setRemaining(){
        remainingEdt.setText("");
        String term = termsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(levelsCmb.getSelectedItem().toString());
        int section = secsCmb.getSelectedIndex();
        String s = "";
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT code, cnt FROM courses where term=? AND level=? AND section=?");
            ps.setString(1, term);
            ps.setInt(2, level);
            ps.setInt(3, section);
            ResultSet rs = ps.executeQuery();
            int i = 1;
            int diff = 0;
            int c = 0;
            while(rs.next()){
                int code = rs.getInt(1);
                int cnt = rs.getInt(2);
                diff = cnt - used(code);
                String msg = "";
                c = -diff;
                if(diff>=0) msg = "(" + diff + ")";
                else    msg = "(Extra-" + c + ")";
                s = s+ i + ". " + code + msg + "\n";
                i++;
                
                ///if(c > 0) JOptionPane.showMessageDialog(null, code+ " is added " + c + " times extra!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            
            ps.close();
            rs.close();
            remainingEdt.setText(s);
        }catch(Exception e){
            System.out.println("Error Set Remaining Function-1");
        }
    }
    
    void set(){
        if(termsCmb.getItemCount()*levelsCmb.getItemCount()*secsCmb.getItemCount()==0)  return;
        String term = termsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(levelsCmb.getSelectedItem().toString());
        char s = secsCmb.getSelectedItem().toString().charAt(0);
        int sec = (int)s - 65;
        ArrayList<Integer>colors = new ArrayList<>();
        ArrayList<String>codes = new ArrayList<>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("SELECT color, code FROM routine WHERE term=? AND level=? AND sec=?");
            ps.setString(1, term);
            ps.setInt(2, level);
            ps.setInt(3, sec);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int color = rs.getInt(1);
                int code = rs.getInt(2);
                
                colors.add(color);
                codes.add(code+"");   
            }
            
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Hello Set");
            return;
        }
        for(int i=0; i<colors.size(); i++){
            int p = colors.get(i);
            String q = codes.get(i);
            try{t[p].setText(q);}catch(Exception e){}
        }
    }
    
    void load(){
        remainingEdt.setText("");
        if(termsCmb.getItemCount()*levelsCmb.getItemCount()*secsCmb.getItemCount()==0)  return;
        try{for(int i=0; i<30; i++) t[i].setText("X");}catch(Exception e){}
        String c = "";
        String term = termsCmb.getSelectedItem().toString();
        c = levelsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(c);
        c = secsCmb.getSelectedItem().toString();
        int sec = (int)(c.charAt(0)) - 65;
        
        
        courses = new ArrayList<>();
        courses.add("X");
        
        
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT code FROM courses WHERE term=? AND level=? AND section=?");
            ps.setString(1, term);
            ps.setInt(2, level);
            ps.setInt(3, sec);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getInt(1) + "";
                courses.add(s);
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Load Catch 1");
        }
        
        
        set();
        
    }
    
    int isMatching(String t, ArrayList<String>a){
        for(int i=0; i<a.size(); i++){
            if(a.get(i).equals(t))  return 1;
        }
        return 0;
    }
    
    void setCourse(int index){       
        String term = termsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(levelsCmb.getSelectedItem().toString());
        char s = secsCmb.getSelectedItem().toString().charAt(0);
        int sec = (int)s - 65;
        String days[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY", "THURSDAY"};
        String periods[]={"1ST","2ND","3RD","4TH","5TH","6TH"};
        
        String pCode = t[index].getText();  //pCode = current course code
        int len = courses.size();  //All courses
        String[] options = new String[len];
        for(int i=0; i<len; i++)    options[i]=courses.get(i);
        String d = days[index/6];
        String p = periods[index%6];
        int response = JOptionPane.showOptionDialog(null,d + " "+p+" PERIOD", "LEVEL: " + level + " ~ SEC: " +s,
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options, options[0]);
        String cCode = options[response]; //cCode = selected course code
        
        if(cCode.equals(pCode)) return;
        
        
        
        

        ///System.out.println("Set Course: " + (index+1) + " " + t[index].getSelectedItem().toString());
        if(response==0){
            try{
                PreparedStatement ps = conn.prepareStatement("DELETE FROM routine WHERE term=? AND level=? AND sec=? AND color=?");
                ps.setString(1, term);
                ps.setInt(2, level);
                ps.setInt(3, sec);
                ps.setInt(4, index);
                ps.execute();
                ps.close();
                t[index].setText("X");
                setRemaining();
                return;
            }catch(Exception e){
                System.out.println("Set Course Delete Error 1");
                return;
            }
        }
        
        int curCode = Integer.parseInt(cCode);  //curCode = selected course code from option
        ArrayList<String> curTeachers = new ArrayList<>();
        ArrayList<String> curRooms = new ArrayList<>();
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT t1,t2,t3,t4,t5,t6,t7,t8,r1,r2 FROM courses WHERE term=? AND level=? AND section=? AND code=?");
            ps.setString(1, term);
            ps.setInt(2, level);
            ps.setInt(3, sec);
            ps.setInt(4, curCode);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                for(int i=1; i<=8; i++){
                    String t = rs.getString(i);
                    if(t.equals("N/A")) continue;
                    curTeachers.add(t);
                }
                curRooms.add(rs.getString(9));
                curRooms.add(rs.getString(10));
            }
            
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 2");
            return;
        }
        
        /*for(int i=0; i<curTeachers.size(); i++){
            System.out.println(curTeachers.get(i));
        }*/
        
        
        ///Current level, sec charra jesob course ache
        ArrayList<Integer>levels = new ArrayList<Integer>();
        ArrayList<Integer>secs = new ArrayList<>();
        ArrayList<Integer>codes = new ArrayList<>();
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT level,sec,code FROM routine WHERE term=? AND color=?");
            ps.setString(1, term);
            ps.setInt(2, index);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int l = rs.getInt(1);
                int se = rs.getInt(2);
                int c = rs.getInt(3);
                
                if(l==level && se==sec) continue;
                levels.add(l);
                secs.add(se);
                codes.add(c);
                ///System.out.println(c + "");
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 3");
            return;
        }
        
        
        String log = "";
        ArrayList<String>xx = new ArrayList<>();
        ArrayList<String>yy = new ArrayList<>();
        try{
            PreparedStatement ps=conn.prepareStatement("SELECT t1,t2,t3,t4,t5,t6,t7,t8,r1,r2 FROM courses WHERE term=? AND level=? AND section=? AND code=?");
            for(int i=0; i<codes.size(); i++){
                int l = levels.get(i);
                int se = secs.get(i);
                int c = codes.get(i);
                
                ps.setString(1, term);
                ps.setInt(2, l);
                ps.setInt(3, se);
                ps.setInt(4, c);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    for(int j=1; j<=8; j++){
                        String t = rs.getString(j);
                        if(t.equals("N/A")) continue;
                        xx.add(t);
                        if(isMatching(t,curTeachers)==1)    log=log+t+" conflicts with "+c+" Level: "+l+" ~ Sec: "+se+ "\n";
                    }
                    
                    for(int j=9; j<=10; j++){
                        String r = rs.getString(j);
                        if(r.equals("N/A")) continue;
                        yy.add(r);
                        if(isMatching(r,curRooms)==1)    log=log+r+" conflicts with "+c+" Level: "+l+" ~ Sec: "+se+ "\n";
                    }
                }
            }
            ps.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 4");
            return;
        }
        ///System.out.println("Other Subjects");
        ///for(int i=0; i<xx.size(); i++)  System.out.println(xx.get(i));
        
        
        if(log.length()>2){
            try{
                t[index].setText(pCode);
                JOptionPane.showMessageDialog(null, log, "Conflict!", JOptionPane.ERROR_MESSAGE);
                return;
            }catch(Exception e){
                System.out.println("Set Course Delete Error 5");
                return;
            }
        }
        
        t[index].setText(cCode);
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM routine WHERE term=? AND level=? AND sec=? AND color=?");
            ps.setString(1, term);
            ps.setInt(2, level);
            ps.setInt(3, sec);
            ps.setInt(4, index);
            ps.execute();
            ps.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 6");
            return;
        }
        
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO routine(term,code,level,sec,color)VALUES(?,?,?,?,?)");
            ps.setString(1, term);
            ps.setInt(2, curCode);
            ps.setInt(3, level);
            ps.setInt(4, sec);
            ps.setInt(5, index);
            ps.execute();
            ps.close();
            
        }catch(Exception e){
            System.out.println("Set Course Delete Error 7");
            return;
        }
        
        setRemaining();
        
    }
    

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
            java.util.logging.Logger.getLogger(Routine_Button.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Routine_Button.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Routine_Button.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Routine_Button.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Routine_Button().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> levelsCmb;
    private javax.swing.JButton p0;
    private javax.swing.JButton p1;
    private javax.swing.JButton p10;
    private javax.swing.JButton p11;
    private javax.swing.JButton p12;
    private javax.swing.JButton p13;
    private javax.swing.JButton p14;
    private javax.swing.JButton p15;
    private javax.swing.JButton p16;
    private javax.swing.JButton p17;
    private javax.swing.JButton p18;
    private javax.swing.JButton p19;
    private javax.swing.JButton p2;
    private javax.swing.JButton p20;
    private javax.swing.JButton p21;
    private javax.swing.JButton p22;
    private javax.swing.JButton p23;
    private javax.swing.JButton p24;
    private javax.swing.JButton p25;
    private javax.swing.JButton p26;
    private javax.swing.JButton p27;
    private javax.swing.JButton p28;
    private javax.swing.JButton p29;
    private javax.swing.JButton p3;
    private javax.swing.JButton p4;
    private javax.swing.JButton p5;
    private javax.swing.JButton p6;
    private javax.swing.JButton p7;
    private javax.swing.JButton p8;
    private javax.swing.JButton p9;
    private javax.swing.JTextArea remainingEdt;
    private javax.swing.JTextField roomEdt;
    private javax.swing.JTable roomScheduleTable;
    private javax.swing.JComboBox<String> roomsCmb;
    private javax.swing.JComboBox<String> secsCmb;
    private javax.swing.JTextField teacherEdt;
    private javax.swing.JTable teacherScheduleTable;
    private javax.swing.JComboBox<String> teachersCmb;
    private javax.swing.JComboBox<String> termsCmb;
    // End of variables declaration//GEN-END:variables
}
