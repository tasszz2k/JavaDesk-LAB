/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.MainFrame;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author TASS
 */
public class Controller {

    // Variables declaration - do not modify                     
    private MainFrame mf = new MainFrame();
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JPanel pnlGame;
    // End of variables declarations

    public Controller() {
        initComponents();
    }

    void initComponents() {
        btnExit = mf.getBtnExit();
        btnPause = mf.getBtnPause();
        btnSave = mf.getBtnSave();
        lblPoint = mf.getLblPoint();
        pnlGame = mf.getPnlGame();
        pnlGame.setBorder(BorderFactory.createLineBorder(Color.blue));
        mf.setVisible(true);

        //
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
    }

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
