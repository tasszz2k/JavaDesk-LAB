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
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author TASS
 */
public class Controller {

    private final int HEIGHT_PNL = 600;
    private final int WIDTH_PNL = 900;
    // Variables declaration - do not modify                     
    private MainFrame mf = new MainFrame();
    private Memory memory = new Memory(0, 30, WIDTH_PNL, WIDTH_PNL + 450);
    private Timer timer;
    private Pipe pipeI, pipeII;
    private Frog frog;

    private int point = 0;
    private boolean isPause = false;

    private boolean isRelease = true;

    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JPanel pnlGame;
    // End of variables declarations

    public Controller() {
        initComponents();
        frog = new Frog(50);
        pnlGame.add(frog.getFrog());

        pipeI = new Pipe(WIDTH_PNL);
        pnlGame.add(pipeI.getPipe1());
        pnlGame.add(pipeI.getPipe2());
        pipeII = new Pipe(WIDTH_PNL + 450);
        pnlGame.add(pipeII.getPipe1());
        pnlGame.add(pipeII.getPipe2());

        pnlGame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println(me);
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

        //Add key Listener
        pnlGame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (isRelease) {
                    isRelease = false;
                    frog.setIsClicked(true);
                    System.out.println("Pressed");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isRelease = true;
                System.out.println("Released");
            }
        });
        pnlGame.setFocusable(true);
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
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pipeI.render();
                pipeII.render();
                frog.render();
                if (!frog.isIsAlive(pipeI, pipeII)) {
                    timer.stop();
                    int choice = JOptionPane.showConfirmDialog(null, "Do you want to play saved game?");
                    switch (choice) {
                        case 0:
                            rePlayGame(memory.getPoint(), memory.getxFrog(), memory.getxPipeI(), memory.getxPipeII());
                            break;
                        case 1:
                            rePlayGame(0, 50, WIDTH_PNL, WIDTH_PNL + 450);
                            break;
                        default:
                            System.exit(0);
                    }

                }
                getPoint();
            }
        });
        return timer;
    }

    void getPoint() {
        System.out.println(frog.getxFrog() + "==" + (pipeI.getxPipe() + pipeI.getWIDTH()));
        if (frog.getxFrog() == pipeI.getxPipe() + pipeI.getWIDTH()
                || frog.getxFrog() == pipeII.getxPipe() + pipeI.getWIDTH()) {
            System.err.println("OK");
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

        memory.setPoint(Integer.parseInt(lblPoint.getText()));
        memory.setxFrog(frog.getxFrog());
        memory.setxPipeI(pipeI.getxPipe());
        memory.setxPipeII(pipeII.getxPipe());

    }

    public void rePlayGame(int rPoint, int rXFrog, int rXPipeI, int rXPipeII) {
        pnlGame.removeAll();
        pnlGame.revalidate();
        pnlGame.repaint();

        lblPoint.setText(rPoint + "");
        frog = new Frog(rXFrog);
        pnlGame.add(frog.getFrog());

        pipeI = new Pipe(rXPipeI);
        pnlGame.add(pipeI.getPipe1());
        pnlGame.add(pipeI.getPipe2());
        pipeII = new Pipe(rXPipeII);
        pnlGame.add(pipeII.getPipe1());
        pnlGame.add(pipeII.getPipe2());

        pnlGame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println(me);
                frog.setIsClicked(true);
            }
        });
//        timer = run();
        timer.start();
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

}
