/*
 * EChequeBankServer.java
 *
 * Created on June 6, 2007, 2:11 PM
 */

package eCheque;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */
public class EChequeBankServer extends javax.swing.JFrame {
    
    private boolean serverStartFlag;
    private Thread bankServerThread;
    /** Creates new form EChequeBankServer */
    public EChequeBankServer() {
        initComponents();
        serverStartFlag = false;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBankShell = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jBStart = new javax.swing.JButton();
        jBStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("e-Cheque Bank Server");
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTBankShell.setColumns(20);
        jTBankShell.setFont(new java.awt.Font("Courier New", 1, 12));
        jTBankShell.setRows(5);
        jTBankShell.setText("\n>> e-Cheque Bank Server Waiting");
        jScrollPane1.setViewportView(jTBankShell);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jBStart.setText("Start");
        jBStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBStartMouseClicked(evt);
            }
        });

        jBStop.setText("Stop");
        jBStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBStopMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(jBStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(jBStop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBStop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-306)/2, (screenSize.height-271)/2, 306, 271);
    }// </editor-fold>//GEN-END:initComponents

    private void jBStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBStopMouseClicked
// TODO add your handling code here:
        if(serverStartFlag){
            
            try{
                
                JOptionPane.showMessageDialog(null,"The Server is going to shutdown","System Information",JOptionPane.INFORMATION_MESSAGE);
                bankServerThread.stop();
                Thread.sleep(5000);
                System.exit(0);
            }
            catch(Exception e){
                
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"The Server is not working","System Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBStopMouseClicked

    private void jBStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBStartMouseClicked
// TODO add your handling code here:
        if(!serverStartFlag){
            jTBankShell.append("\n\n>> Server is going to start");
            
            try{
            
                Runnable runBank = new BankServer();
                bankServerThread = new Thread(runBank);
                bankServerThread.start();
                serverStartFlag = true;
                jTBankShell.append("\n\n>> Server started");
            }
            catch(IOException exp){
                
                JOptionPane.showMessageDialog(null,exp.getMessage(),"Network Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"The Server is already running","System Information",JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_jBStartMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EChequeBankServer().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBStart;
    private javax.swing.JButton jBStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTBankShell;
    // End of variables declaration//GEN-END:variables
    
}
