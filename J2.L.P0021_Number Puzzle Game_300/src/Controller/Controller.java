/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.MainFrame;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author TASS
 */
public class Controller {

    MainFrame mf = new MainFrame();
    Game game = new Game();
    //pnl control
    private JButton btnNewGame;
    private JComboBox<String> cmbSize;
    private JLabel lblMoveCount;
    private JLabel lblTime;
    private JPanel pnlGame;

    public Controller() {
        initComponents();
        mf.setVisible(true);
    }

    void initComponents() {
        //pnl control
        btnNewGame = mf.getBtnNewGame();
        cmbSize = mf.getCmbSize();
        lblMoveCount = mf.getLblMoveCount();
        lblTime = mf.getLblTime();
        pnlGame = mf.getPnlGame();

        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        //New game
        int size = 3;
        game.createNewGame(mf, pnlGame, size, lblMoveCount, lblTime);
    }

    private void btnNewGameActionPerformed(ActionEvent evt) {
        game.getTimer().stop();
        int size = cmbSize.getSelectedIndex() + 3;
        System.out.println(size);
        game.createNewGame(mf,pnlGame, size, lblMoveCount, lblTime);
    }

}
