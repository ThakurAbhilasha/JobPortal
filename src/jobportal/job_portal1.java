/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * job_portal1.java
 *
 * Created on 12 Jul, 2015, 6:55:21 PM
 */

package jobportal;

/**
 *
 * @author abhilasha
 */
public class job_portal1 extends javax.swing.JFrame {

    /** Creates new form job_portal1 */
    public job_portal1() {
        initComponents();
        setSize(1500,700);
        setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Register");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1200, 330, 110, 29);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Log in");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1200, 240, 100, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Not a Member yet?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1050, 340, 140, 17);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 56)); // NOI18N
        jLabel3.setText("Job Portal");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 260, 87);

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 24));
        jLabel4.setText("Don't wait.... the time will never just be right ..... Explore your Dreams!!");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 590, 800, 38);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abc/jan-job-search1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1450, 890);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 new Signup().setVisible(true);
  dispose();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 new login().setVisible(true);
  dispose();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new job_portal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
