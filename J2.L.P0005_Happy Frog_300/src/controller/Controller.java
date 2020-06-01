/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Timer;

/**
 *
 * @author TASS
 */
public class Controller {

    // Variables declaration - do not modify                     
    private MainFrame mf = new MainFrame();
    private Timer timer;
    private Pipe pipeI, pipeII;
    private Frog frog;
    
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JPanel pnlGame;
    // End of variables declarations

    public Controller() {
        initComponents();
        frog = new Frog(300);
        pnlGame.add(frog.getFrog());
        
        pipeI = new Pipe(pnlGame.getWidth());
        pnlGame.add(pipeI.getPipe1());
        pnlGame.add(pipeI.getPipe2());
        pipeII = new Pipe(pnlGame.getWidth() + 450);
        pnlGame.add(pipeII.getPipe1());
        pnlGame.add(pipeII.getPipe2());
        
        pnlGame.addMouseListener(new MouseAdapter() {            
            public void mouseClicked(MouseEvent me) {
//            System.out.println(me); 
                frog.setIsClicked(true);
            }            
        });        
        
        timer = run();
        timer.start();
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
    
    public Timer run() {
        timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pipeI.render();
                pipeII.render();
                frog.render();
            }
        });
        return timer;
    }
    
    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
}
