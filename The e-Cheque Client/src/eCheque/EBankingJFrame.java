/*
 * EBankingJFrame.java
 *
 * Created on June 11, 2007, 6:52 PM
 */

package eCheque;

/**
 *
 * @author  Saad
 */
//import com.Trendy.swing.plaf.TrendyLookAndFeel;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;

public class EBankingJFrame extends javax.swing.JFrame {

    private boolean selectChequeFlag;
    private EChequeRegistration registerData;
    private ECheque depositCheque;
    /** Creates new form EBankingJFrame */
    public EBankingJFrame(EChequeRegistration registerdUser) {
        initComponents();
        registerData = registerdUser;
        selectChequeFlag = false;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTBankIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBLoadCheque = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCBDeposit = new javax.swing.JCheckBox();
        jCBCancel = new javax.swing.JCheckBox();
        jBSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("e-Banking");
        setResizable(false);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter e-Cheque Info."));
        jLabel1.setText("Bank  URL / IP");

        jLabel2.setText("Select e-Cheque");

        jBLoadCheque.setText("load ");
        jBLoadCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoadChequeActionPerformed(evt);
            }
        });

        jLabel3.setText("Operation Type");

        jCBDeposit.setText("deposit");
        jCBDeposit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCBDeposit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCBDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDepositActionPerformed(evt);
            }
        });

        jCBCancel.setText("cancel");
        jCBCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCBCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(37, 37, 37)
                        .add(jBLoadCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel3))
                        .add(8, 8, 8)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTBankIP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jCBDeposit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(19, 19, 19)
                                .add(jCBCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTBankIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jBLoadCheque))
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jCBDeposit)
                    .add(jCBCancel))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jBSubmit.setText("Submit Request");
        jBSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSubmitActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(113, 113, 113)
                        .add(jBSubmit)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(jBSubmit)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-372)/2, (screenSize.height-317)/2, 372, 317);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSubmitActionPerformed
// TODO add your handling code here:
        String hostName;
        hostName = jTBankIP.getText();
        if(hostName.length()!=0){
            
            if(selectChequeFlag){             
                
                if(jCBDeposit.isSelected()){
                    Runnable client = new EchequeClient(8189,1,hostName,registerData,depositCheque);
                    Thread clientThread = new Thread(client);
                    clientThread.start();
                }
                else if(jCBCancel.isSelected())
                {
                    Runnable client = new EchequeClient(8189,2,hostName,registerData,depositCheque);
                    Thread clientThread = new Thread(client);
                    clientThread.start();
                }
                else{
                    JOptionPane.showMessageDialog(null,"You have to select the operation type","User Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
               JOptionPane.showMessageDialog(null,"You have to load one of your e-Cheque","User Error",JOptionPane.ERROR_MESSAGE);
                
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"You have to enter the bank URl or IP","User Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBSubmitActionPerformed

    private void jCBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCancelActionPerformed
// TODO add your handling code here:
        jCBDeposit.setSelected(false);
    }//GEN-LAST:event_jCBCancelActionPerformed

    private void jCBDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDepositActionPerformed
// TODO add your handling code here:
        jCBCancel.setSelected(false);
    }//GEN-LAST:event_jCBDepositActionPerformed

    private void jBLoadChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoadChequeActionPerformed
// TODO add your handling code here:
    String chequePath;
    chequePath = getFileLoaction("Open Saved Cheque"); 
    if(chequePath.length()!=0){
        try{
        EChequeIO loadCheq = new EChequeIO();
        depositCheque = loadCheq.readCheque(chequePath);
        selectChequeFlag = true;
        }
        catch(IOException exp){
            JOptionPane.showMessageDialog(null,"can not load the cheque","System Error",JOptionPane.ERROR_MESSAGE);
            selectChequeFlag = false;
        }
        catch(ClassNotFoundException exp){
            JOptionPane.showMessageDialog(null,"Invaild e-Cheque","Error",JOptionPane.ERROR_MESSAGE);
            selectChequeFlag = false;
        }
    }
        
    }//GEN-LAST:event_jBLoadChequeActionPerformed
      private String getFileLoaction(String dialogTitle){
    
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fileChooser.setDialogTitle(dialogTitle);
        int result = fileChooser.showOpenDialog( this );
 
        if ( result == JFileChooser.CANCEL_OPTION )
             return "";
 
        File fileName = fileChooser.getSelectedFile();
 
         // display error if invalid
         if ( ( fileName == null ) || ( fileName.getName().equals( "" ) ) )
         {
            JOptionPane.showMessageDialog( this, "Invalid File Name",
              "Invalid File Name", JOptionPane.ERROR_MESSAGE );
           return "";
         } 
         return fileName.getPath();
      }
   
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLoadCheque;
    private javax.swing.JButton jBSubmit;
    private javax.swing.JCheckBox jCBCancel;
    private javax.swing.JCheckBox jCBDeposit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTBankIP;
    // End of variables declaration//GEN-END:variables
    
}
