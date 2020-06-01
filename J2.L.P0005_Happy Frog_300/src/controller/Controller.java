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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    private int point = 0;
    private boolean isPause = false;

    private boolean isPress = false;
    private boolean isRelease = false;

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

        pnlGame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("dsa");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("");
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("xasdsjadasjdkl");
                    if (isRelease) {
                        isPress = true;
                        isRelease = false;
                        frog.setIsClicked(true);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("ajsdkldjsalk");
                isRelease = true;
            }
        });
        pnlGame.setFocusable(true);

//        timer = run();
//        timer.start();
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
                if (!frog.isIsAlive(pipeI, pipeII)) {
//                    timer.stop();
                }
                getPoint();
            }
        });
        return timer;
    }

    void getPoint() {
        if (frog.getxFrog() == pipeI.getxPipe() + pipeI.getWIDTH() || frog.getxFrog() == pipeII.getxPipe() + pipeI.getWIDTH()) {
            point++;
            lblPoint.setText(point + "");
        }
    }

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isPause) {
            timer.stop();
            btnPause.setText("Resume");
            isPause = true;
        } else {
            timer.start();
            btnPause.setText("Pause");
            isPause = false;
        }

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

}
