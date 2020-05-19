/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author TASS
 */
public class Game {

    JButton[][] btns;

    void createNewGame(JPanel pnlGame, int size) {
        //remove all component from Jpanel
        pnlGame.removeAll();
        pnlGame.revalidate();
        pnlGame.repaint();
        //
        btns = new JButton[size][size];
        pnlGame.setLayout(new GridLayout(size, size, 5, 5));
        String[][] numbers = randomNumberOfButtons(size);
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[0].length; j++) {
                btns[i][j] = new JButton(numbers[i][j]);
                if (size >= 9) {
                    btns[i][j].setFont(new Font("Arial", Font.PLAIN, 7));
                }
                pnlGame.add(btns[i][j]);
                //Add Action Listener for Jbutton
                JButton btn = btns[i][j];
                Point posBtn = new Point(i, j);
                btn.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        boolean t = canMove(btn, new Point(0, 0));
                    }
                });
            }
        }
        //
        Point emptyPos = getEmptyPosition(btns);
        System.out.println(emptyPos);
        btns[(int) emptyPos.getX()][(int) emptyPos.getY()].setBackground(Color.blue);
    }

    //Make map game
    String[][] randomNumberOfButtons(int size) {
        String[][] numbers = new String[size][size];
        //Set value for numbers[][]
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
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
            for (int j = 0; j < btns.length; j++) {
                if (btns[i][j].getText().compareTo("") == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    //Action performed btns
    boolean canMove(JButton btnClick, Point posBtnClick) {
        System.out.println(btnClick.getText());
        System.out.println(posBtnClick);
        return true;
    }

}
