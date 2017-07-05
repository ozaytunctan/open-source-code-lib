/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.gui;

import com.open.classification_learning.KnnClassification;
import com.open.lang.MessageBox;
import com.open.io.InputOutputUtils;
import com.open.matrix.CMat;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ozaytunctan13
 */
public class FrameMachineLearning extends javax.swing.JFrame {

    private DefaultComboBoxModel cbm_method = null;
    private boolean isTestLoad = false;
    private boolean isTrainLoad = false;
    private CMat train;
    private CMat test;
    private int trainDataAdet =99;
    private int testDataAdet = 99;
    String selected_file;
    private int n = -1;
    Color red = Color.RED;
    Color black = Color.BLACK;
    Color blue = Color.BLUE;
    Font ft = new Font(Font.MONOSPACED, 1, 16);
    Font ft2 = new Font(Font.SANS_SERIF, 1, 14);

    /**
     * Creates new form FrameMachineLearning
     */
    public FrameMachineLearning() {
        initComponents();
        initialize();
    }

    private void initialize() {
        jsliderInit();
        btResultShow.setEnabled(false);
        btTrainStart.setEnabled(false);
        btTestLoad.setEnabled(false);
        setFont();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtFolderName = new javax.swing.JTextField();
        btnFolderShow = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jslideTrain = new javax.swing.JSlider();
        lbTrain = new javax.swing.JLabel();
        lbTest = new javax.swing.JLabel();
        jslideTest = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        cbmNeighborValue = new javax.swing.JComboBox<>();
        btTrainStart = new javax.swing.JButton();
        btResultShow = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btTrainLoad = new javax.swing.JButton();
        btTestLoad = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pane_result = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153), null, null));

        jLabel9.setText("Folder:");

        txtFolderName.setText("C:\\");

            btnFolderShow.setText("...");
            btnFolderShow.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnFolderShowActionPerformed(evt);
                }
            });

            jLabel10.setText("Slected Data:");

            jLabel11.setText("Folder Path:");

            jLabel6.setText("KNN Algorithm Machine Learning");

            lbTrain.setText("Train Set Value %100");

            lbTest.setText("Test Set Value %100");

            jLabel5.setText("Neighbor Value");

            cbmNeighborValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "3", "5", "7", "9", "11", "13", "15", "17", "19", "21", "" }));

            btTrainStart.setText("Training");
            btTrainStart.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btTrainStartActionPerformed(evt);
                }
            });

            btResultShow.setText("Show Result");

            btTrainLoad.setText("Train Data Load");
            btTrainLoad.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btTrainLoadActionPerformed(evt);
                }
            });

            btTestLoad.setText("Test Data Load");
            btTestLoad.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btTestLoadActionPerformed(evt);
                }
            });

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "euclidean", "cityblock", "chessbord" }));

            jLabel1.setText("Distance Measure");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btResultShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btTrainStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTrain, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jslideTrain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jslideTest, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(cbmNeighborValue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel6)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addGap(0, 31, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFolderName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnFolderShow))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btTrainLoad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btTestLoad)
                                            .addGap(19, 19, 19))
                                        .addComponent(txtFileName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtFolderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFolderShow))
                    .addGap(20, 20, 20)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btTrainLoad)
                        .addComponent(btTestLoad))
                    .addGap(9, 9, 9)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jslideTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jslideTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbmNeighborValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))))
                    .addGap(18, 18, 18)
                    .addComponent(btTrainStart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btResultShow, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            pane_result.setBorder(new javax.swing.border.MatteBorder(null));

            jLabel2.setText("Sonuc Gösterimi Burda olacak");

            javax.swing.GroupLayout pane_resultLayout = new javax.swing.GroupLayout(pane_result);
            pane_result.setLayout(pane_resultLayout);
            pane_resultLayout.setHorizontalGroup(
                pane_resultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pane_resultLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(jLabel2)
                    .addContainerGap(181, Short.MAX_VALUE))
            );
            pane_resultLayout.setVerticalGroup(
                pane_resultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pane_resultLayout.createSequentialGroup()
                    .addGap(225, 225, 225)
                    .addComponent(jLabel2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pane_result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pane_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnFolderShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolderShowActionPerformed
        String pathFolder = txtFolderName.getText();
        showFolder(pathFolder);
        if (isTestLoad && isTrainLoad) {
            btTrainStart.setEnabled(true);
        }
        if (isTrainLoad) {
            btTrainLoad.setForeground(black);
        } else {
            btTrainLoad.setForeground(blue);
        }
        if (isTestLoad || !isTrainLoad) {
            btTestLoad.setForeground(black);
        } else {
            btTestLoad.setForeground(blue);
        }

    }//GEN-LAST:event_btnFolderShowActionPerformed

    private void btTrainLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTrainLoadActionPerformed
        selected_file = txtFileName.getText();
        txtFileName.setText("");
        if (selected_file != null) {
            double[][] val = null;
            try {
                val = InputOutputUtils.readFromFileDataDouble(selected_file, ",");
            } catch (Exception e) {
                MessageBox.showErrorMessage("Lutfen uygun veri dosyasini seciniz.\n Dosya içindekiler sayı olmalıdır.");
                return;
            }
            if (val != null) {
                train = CMat.getInstance(val);
                btTestLoad.setEnabled(true);
                isTrainLoad = true;
            } else {
                MessageBox.showErrorMessage("Lutfen uygun veriyi seciniz.");
                isTrainLoad = false;
                btTrainLoad.setForeground(red);
            }
        } else {
            MessageBox.showErrorMessage("Lütfen bir dosya seciniz.");
            isTrainLoad = false;
            btTrainLoad.setForeground(red);
        }
        if (isTrainLoad) {
            btTrainLoad.setEnabled(true);
            btTrainLoad.setForeground(black);
            btTrainStart.setEnabled(true);
            btTrainStart.setForeground(blue);
            btTrainLoad.setEnabled(false);
        }
    }//GEN-LAST:event_btTrainLoadActionPerformed

    private void btTestLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestLoadActionPerformed
        selected_file = txtFileName.getText();
        txtFileName.setText("");
        if (selected_file != null) {
            double[][] val = null;
            try {
                val = InputOutputUtils.readFromFileDataDouble(selected_file, ",");
            } catch (Exception e) {
                MessageBox.showErrorMessage("Lutfen uygun veri dosyasini seciniz.\n Dosya içindekiler sayı olmalıdır.");
                return;
            }
            if (val != null) {
                test = CMat.getInstance(val);
                btTestLoad.setEnabled(false);
                isTestLoad = true;
            } else {
                MessageBox.showErrorMessage("Lütfen uygun veriyi seciniz.");
                isTestLoad = false;
                btTestLoad.setForeground(red);
            }
        } else {
            MessageBox.showErrorMessage("Lütfen bir dosya seciniz.");
            btTestLoad.setForeground(red);
            isTestLoad = false;
        }
        if (isTestLoad && isTrainLoad) {
            btTrainStart.setEnabled(true);
            btTestLoad.setEnabled(false);
            btTestLoad.setForeground(black);
            btTrainStart.setForeground(blue);
        }
    }//GEN-LAST:event_btTestLoadActionPerformed

    private void btTrainStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTrainStartActionPerformed
        btTestLoad.setEnabled(true);
        btTrainLoad.setEnabled(true);
        double train_val = (double) (trainDataAdet / 100.0);
        double test_val = (double) (testDataAdet / 100.0);
        CMat egitimVal, testVal;
        if (isTrainLoad && !isTestLoad) {
            if (train.getRowNumber() > 0) {

                CMat[] c = train.splitToTestTrain(train_val);
                egitimVal = c[0];
                testVal = c[1];
            }
        } else if (isTrainLoad && isTestLoad) {
            CMat[] c = train.splitToTestTrain(train_val);
            egitimVal = c[0];
            testVal = test.splitToTestTrain(test_val)[0];
        }
        System.out.println(train_val + "" + "," + test_val + "");

    }//GEN-LAST:event_btTrainStartActionPerformed

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
            java.util.logging.Logger.getLogger(FrameMachineLearning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMachineLearning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMachineLearning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMachineLearning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMachineLearning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btResultShow;
    private javax.swing.JButton btTestLoad;
    private javax.swing.JButton btTrainLoad;
    private javax.swing.JButton btTrainStart;
    private javax.swing.JButton btnFolderShow;
    private javax.swing.JComboBox<String> cbmNeighborValue;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jslideTest;
    private javax.swing.JSlider jslideTrain;
    private javax.swing.JLabel lbTest;
    private javax.swing.JLabel lbTrain;
    private javax.swing.JPanel pane_result;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextField txtFolderName;
    // End of variables declaration//GEN-END:variables

    private void selectedAlgorithmShowingPane() {

    }

    private void showFolder(String pathFolder) {
        File f = InputOutputUtils.getFileFromChooserLoad(pathFolder);
        if (f != null) {
            txtFileName.setText(f.getAbsolutePath());
            selected_file = txtFileName.getText();
        }
    }

    private void setFont() {

        txtFolderName.setFont(ft);
        txtFileName.setFont(ft);
        btResultShow.setFont(ft2);
        btTestLoad.setFont(ft2);
        btTrainLoad.setFont(ft2);
        btnFolderShow.setFont(ft);
        btTrainStart.setFont(ft2);
    }

    private void jsliderInit() {
        jslideTest.addChangeListener(new JSliderEvent());
        jslideTrain.addChangeListener(new JSliderEvent());
        jslideTest.setMajorTickSpacing(20);
        jslideTest.setMinorTickSpacing(20);
        jslideTest.setPaintTicks(true);
        //jslideTest.setPaintLabels(true);
        jslideTrain.setMajorTickSpacing(20);
        jslideTrain.setMinorTickSpacing(20);
        jslideTrain.setPaintTicks(true);
        //jslideTrain.setPaintLabels(true);
    }

    private class JSliderEvent implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            trainDataAdet = jslideTrain.getValue();
            testDataAdet = jslideTest.getValue();
            lbTrain.setText("Train Set Value %" + trainDataAdet);
            lbTest.setText("Test Set Value %" + testDataAdet);
        }

    }
}
