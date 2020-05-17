/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.MainFrame;
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
    Game g = new Game();
    private JButton[][] matrix;
    private int size;
    private int moveCount;
    private int time;
    private Timer timer;
    //pnl control
    private JButton btnNewGame;
    private JComboBox<String> cmbSize;
    private JLabel lblMoveCount;
    private JLabel lblSize;
    private JLabel lblTime;
    private JPanel pnlControl;
    private JPanel pnlGame;

    public Controller() {
        initComponents();
        mf.setVisible(true);
    }

    void initComponents() {
        size = 3;
        JButton[][] matrix = new JButton[size][size];
        moveCount = 0;
        time = 0;
        //pnl control
        btnNewGame = mf.getBtnNewGame();
        cmbSize = mf.getCmbSize();
        lblMoveCount = mf.getLblMoveCount();
        lblSize = mf.getLblSize();
        lblTime = mf.getLblTime();
        pnlControl = mf.getPnlControl();
        pnlGame = mf.getPnlGame();
    }

    public static void main(String[] args) {
        new Controller();
    }

}
