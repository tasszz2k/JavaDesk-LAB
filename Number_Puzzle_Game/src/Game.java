/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author TASS
 */
public class Game {

    private JButton[][] btns;
    private Timer timer;
    private int moveCounter;
    private int time;

    void createNewGame(JPanel pnlGame, int size, JLabel lblMoveCount, JLabel lblTime) {
        moveCounter = 0;
        time = 0;
        timer = setupTime(lblTime);
        lblMoveCount.setText("0");
        lblTime.setText("0");

        //remove all component from Jpanel
        pnlGame.removeAll();
        pnlGame.revalidate();
        pnlGame.repaint();
        //
        btns = new JButton[size][size];
        pnlGame.setLayout(new GridLayout(size, size, 5, 5));
        //#Test won
//        String[][] numbers = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "", "8"}};
        String[][] numbers = randomNumberOfButtons(size);

        //settime
        timer.start();
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[0].length; j++) {
                btns[i][j] = new JButton(numbers[i][j]);
                if (size >= 9) {
                    btns[i][j].setFont(new Font("Arial", Font.PLAIN, 7));
                }
                pnlGame.add(btns[i][j]);
                //Add Action Listener for Jbutton
                JButton btn = btns[i][j];
                btn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.err.println(moveCounter);
                        move(btn, lblMoveCount);
                    }
                });
            }
        }
    }

    //========================== Make map game =================================//
    String[][] randomNumberOfButtons(int size) {
        String[][] numbers = new String[size][size];
        //Set value for numbers[][]
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j] = (i * size + j) + "";
            }
        }
        numbers[0][0] = "";
        //Shuffle Array
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int xRand = randomNumberInRange(0, size - 1);
                int yRand = randomNumberInRange(0, size - 1);
                String temp = numbers[i][j];
                numbers[i][j] = numbers[xRand][yRand];
                numbers[xRand][yRand] = temp;
            }
        }

        return numbers;
    }

    int randomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    Point getEmptyPosition(JButton[][] btns) {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[0].length; j++) {
                if (btns[i][j].getText().compareTo("") == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    //===================== Action performed btns ==============================//
    boolean canMove(JButton btnClick) {
        //get empty btn position & btnClick Position
        Point emptyPos = getEmptyPosition(btns);
        Point btnClickPos = getButtonPosition(btns, btnClick);
        int rowEmptyBtn = (int) emptyPos.getX();
        int colEmptyBtn = (int) emptyPos.getY();
        int rowBtnClick = (int) btnClickPos.getX();
        int colBtnClick = (int) btnClickPos.getY();

        if (rowBtnClick == rowEmptyBtn && (colBtnClick == colEmptyBtn - 1 || colBtnClick == colEmptyBtn + 1)) {
            return true;
        } else if (colBtnClick == colEmptyBtn && (rowBtnClick == rowEmptyBtn - 1 || rowBtnClick == rowEmptyBtn + 1)) {
            return true;
        } else {
            return false;
        }

    }

    void move(JButton btn, JLabel lblMoveCount) {

        if (canMove(btn)) {
            Point emptyPos = getEmptyPosition(btns);
            JButton emptyBtn = btns[(int) emptyPos.getX()][(int) emptyPos.getY()];
            swapTxtTwoButtons(emptyBtn, btn);

            //Movecounter++
            lblMoveCount.setText(++moveCounter + "");
        }
        if (isWon(btns)) {
            timer.stop();
            System.err.println("You win!!!");
            JOptionPane.showMessageDialog(null, "You win!");
            //Disable moveable when game won
            for (int i = 0; i < btns.length; i++) {
                for (int j = 0; j < btns.length; j++) {
                    btns[i][j].setEnabled(false);
                }

            }
        }
    }

    void swapTxtTwoButtons(JButton emptyBtn, JButton btn) {
        //swap txt
        emptyBtn.setText(btn.getText());
        btn.setText("");

    }

    Point getButtonPosition(JButton[][] btns, JButton btn) {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[0].length; j++) {
                if (btns[i][j].getText().compareTo(btn.getText()) == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    boolean isWon(JButton[][] btns) {
        int size = btns.length;
        if (!btns[size - 1][size - 1].getText().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < btns.length; i++) {
                for (int j = 0; j < btns.length; j++) {
                    if (i == size - 1 && j == size - 1) {
                        return true;
                    }
                    if (btns[i][j].getText().compareTo((i * size + j + 1) + "") != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    //Time
    Timer setupTime(JLabel lblTime) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                lblTime.setText(time + "");
            }
        });
        return timer;
    }

    public Timer getTimer() {
        return timer;
    }
    
    
    
}
