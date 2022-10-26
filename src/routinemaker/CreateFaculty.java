package routinemaker;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CreateFaculty extends javax.swing.JFrame {

    public CreateFaculty()  {
        this.setResizable(false);
        this.setTitle("CREATE NEW FACULTY MEMBER");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateFaculty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CreateFaculty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CreateFaculty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CreateFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        termEdt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/routinemaker/BLUE.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NAME  OF  TEACHER");

        termEdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        termEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termEdtActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("ADD  TEACHER");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(termEdt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(termEdt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void termEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termEdtActionPerformed
        Connection conn = JConnection.ConnecrDb();
        String faculty = termEdt.getText().toString().trim().toUpperCase();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT term FROM faculties");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                if(s.equals(faculty)){
                    JOptionPane.showMessageDialog(null, faculty + " is added previously", "Error", JOptionPane.ERROR_MESSAGE);
                    ps.close();
                    rs.close();
                    conn.close();
                    return;
                }
            }
        }
        
        catch(Exception e){
            System.out.println("Hello 1");
        }
        
        
        int id = 0;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT max(id) FROM faculties");
            ResultSet rs = ps.executeQuery();
            while(rs.next())    id = rs.getInt(1);
            ps.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("Hello 2");
        }
        
        
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO faculties (id, name) VALUES (?, ?)");
            ps.setInt(1, id+1);
            ps.setString(2, faculty);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, faculty + " is added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            System.out.println("Hello 3");
        }
        
        termEdt.setText("");
        termEdt.requestFocusInWindow();
    }//GEN-LAST:event_termEdtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = JConnection.ConnecrDb();
        String faculty = termEdt.getText().toString().trim().toUpperCase();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT term FROM faculties");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s = rs.getString(1);
                if(s.equals(faculty)){
                    JOptionPane.showMessageDialog(null, faculty + " is added previously", "Error", JOptionPane.ERROR_MESSAGE);
                    ps.close();
                    rs.close();
                    conn.close();
                    return;
                }
            }
        }
        
        catch(Exception e){
            System.out.println("Hello 1");
        }
        
        
        int id = 0;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT max(id) FROM faculties");
            ResultSet rs = ps.executeQuery();
            while(rs.next())    id = rs.getInt(1);
            ps.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("Hello 2");
        }
        
        
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO faculties (id, name) VALUES (?, ?)");
            ps.setInt(1, id+1);
            ps.setString(2, faculty);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, faculty + " is added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            System.out.println("Hello 3");
        }
        
        termEdt.setText("");
        termEdt.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(CreateFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateFaculty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField termEdt;
    // End of variables declaration//GEN-END:variables
}
