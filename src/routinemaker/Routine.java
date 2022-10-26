package routinemaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Routine extends javax.swing.JFrame {
    Connection conn;
    int FLAG = 0;
    private JComboBox t[] = new JComboBox[30];
    ArrayList<Integer>slots = new ArrayList<>();
    
    
    public Routine()  {
        this.setResizable(false);
        this.setTitle("CREATE NEW TERM");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn = JConnection.ConnecrDb();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT term FROM terms ORDER BY term ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                termsCmb.addItem(s);
            }
        }catch(Exception e){}
        
        for(int i=1; i<=9; i++){
            levelsCmb.addItem(i+"");
            if(i>4) continue;
            char c = (char)(i+64);
            secsCmb.addItem(c+"");
        }
        
        for(int i=0; i<30; i++) slots.add(0);
        
        t[0]=t0;
        t[1]=t1;
        t[2]=t2;
        t[3]=t3;
        t[4]=t4;
        t[5]=t5;
        t[6]=t6;
        t[7]=t7;
        
        t[8]=t8;
        t[9]=t9;
        t[10]=t10;
        t[11]=t11;
        t[12]=t12;
        t[13]=t13;
        t[14]=t14;
        t[15]=t15;
        
        t[16]=t16;
        t[17]=t17;
        t[18]=t18;
        t[19]=t19;
        t[20]=t20;
        t[21]=t21;
        
        t[22]=t22;
        t[23]=t23;
        t[24]=t24;
        t[25]=t25;
        t[26]=t26;
        t[27]=t27;
        t[28]=t28;
        t[29]=t29;        
        
        termsCmb.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        termsCmb = new javax.swing.JComboBox<>();
        levelsCmb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        secsCmb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t0 = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JComboBox<>();
        t2 = new javax.swing.JComboBox<>();
        t3 = new javax.swing.JComboBox<>();
        t4 = new javax.swing.JComboBox<>();
        t5 = new javax.swing.JComboBox<>();
        t6 = new javax.swing.JComboBox<>();
        t7 = new javax.swing.JComboBox<>();
        t8 = new javax.swing.JComboBox<>();
        t9 = new javax.swing.JComboBox<>();
        t10 = new javax.swing.JComboBox<>();
        t11 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        t12 = new javax.swing.JComboBox<>();
        t13 = new javax.swing.JComboBox<>();
        t14 = new javax.swing.JComboBox<>();
        t15 = new javax.swing.JComboBox<>();
        t16 = new javax.swing.JComboBox<>();
        t17 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        t18 = new javax.swing.JComboBox<>();
        t19 = new javax.swing.JComboBox<>();
        t20 = new javax.swing.JComboBox<>();
        t21 = new javax.swing.JComboBox<>();
        t22 = new javax.swing.JComboBox<>();
        t23 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        t24 = new javax.swing.JComboBox<>();
        t25 = new javax.swing.JComboBox<>();
        t26 = new javax.swing.JComboBox<>();
        t27 = new javax.swing.JComboBox<>();
        t28 = new javax.swing.JComboBox<>();
        t29 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/routinemaker/BLUE.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("TERM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("LEVEL");

        termsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        termsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termsCmbActionPerformed(evt);
            }
        });

        levelsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        levelsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelsCmbActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("SEC");

        secsCmb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secsCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secsCmbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("MON");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("SUN");

        t0.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t0ActionPerformed(evt);
            }
        });

        t1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        t3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        t4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });

        t5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t5ActionPerformed(evt);
            }
        });

        t6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t6ActionPerformed(evt);
            }
        });

        t7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });

        t8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });

        t9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t9ActionPerformed(evt);
            }
        });

        t10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t10ActionPerformed(evt);
            }
        });

        t11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t11ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("TUE");

        t12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t12ActionPerformed(evt);
            }
        });

        t13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t13ActionPerformed(evt);
            }
        });

        t14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t15ActionPerformed(evt);
            }
        });

        t16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t16ActionPerformed(evt);
            }
        });

        t17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t17ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("WED");

        t18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t18ActionPerformed(evt);
            }
        });

        t19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t19ActionPerformed(evt);
            }
        });

        t20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t20ActionPerformed(evt);
            }
        });

        t21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t21ActionPerformed(evt);
            }
        });

        t22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t22ActionPerformed(evt);
            }
        });

        t23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t23ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("THU");

        t24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t24ActionPerformed(evt);
            }
        });

        t25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t25ActionPerformed(evt);
            }
        });

        t26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t26ActionPerformed(evt);
            }
        });

        t27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t27ActionPerformed(evt);
            }
        });

        t28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t28ActionPerformed(evt);
            }
        });

        t29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t29ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("1");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("2");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("3");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("4");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("5");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(termsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addGap(118, 118, 118)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(levelsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel13)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(secsCmb, 0, 199, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15)
                                        .addGap(59, 59, 59))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(t18, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t22, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t23, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(t24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t25, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t26, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t27, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t28, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(t29, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel6)
                    .addContainerGap(820, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(termsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(secsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(levelsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(261, 261, 261)
                    .addComponent(jLabel6)
                    .addContainerGap(312, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void termsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termsCmbActionPerformed
        load();
    }//GEN-LAST:event_termsCmbActionPerformed

    int find(int code){
        String s = code + "";
        for(int i=0; i<t[0].getItemCount(); i++){
            String x = t[0].getItemAt(i).toString();
            if(x.equals(s)) return i;
        }
        return -1;
    }
    
    void set(){
        String term = termsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(levelsCmb.getSelectedItem().toString());
        char s = secsCmb.getSelectedItem().toString().charAt(0);
        int sec = (int)s - 65;
        ArrayList<Integer>colors = new ArrayList<>();
        ArrayList<Integer>indexs = new ArrayList<>();
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
                indexs.add(find(code));   
            }
            
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Hello Set");
            return;
        }
        
        for(int i=0; i<colors.size(); i++){
            int p = colors.get(i);
            int q = indexs.get(i);
            slots.set(p, q);
            
            if(q==-1)   continue;
            FLAG = 1;
            t[p].setSelectedIndex(q);
        }
    }
    
    void load(){
        if(slots.size()==0){
            for(int i=0; i<30; i++) slots.add(0);
        }
        else{
            for(int i=0; i<30; i++) slots.set(i, 0);
        }
        if(termsCmb.getItemCount()*levelsCmb.getItemCount()*secsCmb.getItemCount()==0)  return;
        String c = "";
        String term = termsCmb.getSelectedItem().toString();
        c = levelsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(c);
        c = secsCmb.getSelectedItem().toString();
        int sec = (int)(c.charAt(0)) - 65;
        
        
        
        ArrayList<String> courses = new ArrayList<>();
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

        
        for(int i=0; i<30; i++){
            try{t[i].removeAllItems();}catch(Exception e){}
            for(int j=0; j<courses.size(); j++){
                FLAG=1;
                try{t[i].addItem(courses.get(j));}catch(Exception e){}
            }
        }
        System.out.println("______________________________________");
        
        
        set();
        
    }
    
    private void levelsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelsCmbActionPerformed
        load();
    }//GEN-LAST:event_levelsCmbActionPerformed

    int isMatching(String t, ArrayList<String>a){
        for(int i=0; i<a.size(); i++){
            if(a.get(i).equals(t))  return 1;
        }
        return 0;
    }
    
    void setCourse(int index){
        if(FLAG==1){
            FLAG=0;
            return;
        }
        
        int curIndex = t[index].getSelectedIndex();
        int preIndex = slots.get(index);
        if(curIndex==preIndex)  return;
        
        String term = termsCmb.getSelectedItem().toString();
        int level = Integer.parseInt(levelsCmb.getSelectedItem().toString());
        char s = secsCmb.getSelectedItem().toString().charAt(0);
        int sec = (int)s - 65;
        
        int curCode = Integer.parseInt(t[index].getSelectedItem().toString());

        ///System.out.println("Set Course: " + (index+1) + " " + t[index].getSelectedItem().toString());
        if(curIndex==0){
            try{
                PreparedStatement ps = conn.prepareStatement("DELETE FROM routine WHERE term=? AND level=? AND sec=? AND color=?");
                ps.setString(1, term);
                ps.setInt(2, level);
                ps.setInt(3, sec);
                ps.setInt(4, index);
                ps.execute();
                ps.close();
                slots.set(index, 0);
                return;
            }catch(Exception e){
                System.out.println("Set Course Delete Error 1");
                return;
            }
        }
        
        ArrayList<String> curTeachers = new ArrayList<>();
        
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT t1,t2,t3,t4,t5,t6,t7,t8 FROM courses WHERE term=? AND level=? AND section=? AND code=?");
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
            }
            
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 2");
            return;
        }
        
        for(int i=0; i<curTeachers.size(); i++){
            System.out.println(curTeachers.get(i));
        }
        
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
                System.out.println(c + "");
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Set Course Delete Error 3");
            return;
        }
        
        
        String log = "";
        ArrayList<String>xx = new ArrayList<>();
        try{
            PreparedStatement ps=conn.prepareStatement("SELECT t1,t2,t3,t4,t5,t6,t7,t8 FROM courses WHERE term=? AND level=? AND section=? AND code=?");
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
                        String t = rs.getString(i);
                        if(t.equals("N/A")) continue;
                        xx.add(t);
                        if(isMatching(t,curTeachers)==1)    log=log+t+" conflicts with "+c+" Level: "+l+"Sec: "+se+ "\n";
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
                FLAG=1;
                t[index].setSelectedIndex(preIndex);
                JOptionPane.showMessageDialog(null, log, "Conflict!", JOptionPane.ERROR_MESSAGE);
                return;
            }catch(Exception e){
                System.out.println("Set Course Delete Error 5");
                return;
            }
        }
        
        
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
            
            slots.set(index, curIndex);
        }catch(Exception e){
            System.out.println("Set Course Delete Error 7");
            return;
        }
        
    }
    
    private void secsCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secsCmbActionPerformed
        load(); 
    }//GEN-LAST:event_secsCmbActionPerformed

    private void t0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t0ActionPerformed
        // TODO add your handling code here:
        
        setCourse(0);
    }//GEN-LAST:event_t0ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
        setCourse(1);
    }//GEN-LAST:event_t1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
        setCourse(2);
    }//GEN-LAST:event_t2ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
        setCourse(3);
    }//GEN-LAST:event_t3ActionPerformed

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here:
        setCourse(4);
    }//GEN-LAST:event_t4ActionPerformed

    private void t5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t5ActionPerformed
        // TODO add your handling code here:
        setCourse(5);
    }//GEN-LAST:event_t5ActionPerformed

    private void t6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t6ActionPerformed
        // TODO add your handling code here:
        setCourse(6);
    }//GEN-LAST:event_t6ActionPerformed

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
        setCourse(7);
    }//GEN-LAST:event_t7ActionPerformed

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
        setCourse(8);
    }//GEN-LAST:event_t8ActionPerformed

    private void t9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t9ActionPerformed
        // TODO add your handling code here:
        setCourse(9);
    }//GEN-LAST:event_t9ActionPerformed

    private void t10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t10ActionPerformed
        // TODO add your handling code here:
        setCourse(10);
    }//GEN-LAST:event_t10ActionPerformed

    private void t11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t11ActionPerformed
        // TODO add your handling code here:
        setCourse(11);
    }//GEN-LAST:event_t11ActionPerformed

    private void t12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t12ActionPerformed
        // TODO add your handling code here:
        setCourse(12);
    }//GEN-LAST:event_t12ActionPerformed

    private void t13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t13ActionPerformed
        // TODO add your handling code here:
        setCourse(13);
    }//GEN-LAST:event_t13ActionPerformed

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
        // TODO add your handling code here:
        setCourse(14);
    }//GEN-LAST:event_t14ActionPerformed

    private void t15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t15ActionPerformed
        // TODO add your handling code here:
        setCourse(15);
    }//GEN-LAST:event_t15ActionPerformed

    private void t16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t16ActionPerformed
        // TODO add your handling code here:
        setCourse(16);
    }//GEN-LAST:event_t16ActionPerformed

    private void t17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t17ActionPerformed
        // TODO add your handling code here:
        setCourse(17);
    }//GEN-LAST:event_t17ActionPerformed

    private void t18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t18ActionPerformed
        // TODO add your handling code here:
        setCourse(18);
    }//GEN-LAST:event_t18ActionPerformed

    private void t19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t19ActionPerformed
        // TODO add your handling code here:
        setCourse(19);
    }//GEN-LAST:event_t19ActionPerformed

    private void t20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t20ActionPerformed
        // TODO add your handling code here:
        setCourse(20);
    }//GEN-LAST:event_t20ActionPerformed

    private void t21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t21ActionPerformed
        // TODO add your handling code here:
        setCourse(21);
    }//GEN-LAST:event_t21ActionPerformed

    private void t22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t22ActionPerformed
        // TODO add your handling code here:
        setCourse(22);
    }//GEN-LAST:event_t22ActionPerformed

    private void t23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t23ActionPerformed
        // TODO add your handling code here:
        setCourse(23);
    }//GEN-LAST:event_t23ActionPerformed

    private void t24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t24ActionPerformed
        // TODO add your handling code here:
        setCourse(24);
    }//GEN-LAST:event_t24ActionPerformed

    private void t25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t25ActionPerformed
        // TODO add your handling code here:
        setCourse(25);
    }//GEN-LAST:event_t25ActionPerformed

    private void t26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t26ActionPerformed
        // TODO add your handling code here:
        setCourse(26);
    }//GEN-LAST:event_t26ActionPerformed

    private void t27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t27ActionPerformed
        // TODO add your handling code here:
        setCourse(27);
    }//GEN-LAST:event_t27ActionPerformed

    private void t28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t28ActionPerformed
        // TODO add your handling code here:
        setCourse(28);
    }//GEN-LAST:event_t28ActionPerformed

    private void t29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t29ActionPerformed
        // TODO add your handling code here:
        setCourse(29);
    }//GEN-LAST:event_t29ActionPerformed


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
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Routine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Routine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JComboBox<String> levelsCmb;
    private javax.swing.JComboBox<String> secsCmb;
    private javax.swing.JComboBox<String> t0;
    private javax.swing.JComboBox<String> t1;
    private javax.swing.JComboBox<String> t10;
    private javax.swing.JComboBox<String> t11;
    private javax.swing.JComboBox<String> t12;
    private javax.swing.JComboBox<String> t13;
    private javax.swing.JComboBox<String> t14;
    private javax.swing.JComboBox<String> t15;
    private javax.swing.JComboBox<String> t16;
    private javax.swing.JComboBox<String> t17;
    private javax.swing.JComboBox<String> t18;
    private javax.swing.JComboBox<String> t19;
    private javax.swing.JComboBox<String> t2;
    private javax.swing.JComboBox<String> t20;
    private javax.swing.JComboBox<String> t21;
    private javax.swing.JComboBox<String> t22;
    private javax.swing.JComboBox<String> t23;
    private javax.swing.JComboBox<String> t24;
    private javax.swing.JComboBox<String> t25;
    private javax.swing.JComboBox<String> t26;
    private javax.swing.JComboBox<String> t27;
    private javax.swing.JComboBox<String> t28;
    private javax.swing.JComboBox<String> t29;
    private javax.swing.JComboBox<String> t3;
    private javax.swing.JComboBox<String> t4;
    private javax.swing.JComboBox<String> t5;
    private javax.swing.JComboBox<String> t6;
    private javax.swing.JComboBox<String> t7;
    private javax.swing.JComboBox<String> t8;
    private javax.swing.JComboBox<String> t9;
    private javax.swing.JComboBox<String> termsCmb;
    // End of variables declaration//GEN-END:variables
}
