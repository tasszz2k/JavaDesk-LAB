/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author TASS
 */
public class Pipe {

    private final int HEIGHT_PNL = 600;
    private final int WIDTH_PNL = 900;

    private int xPipe = 0;
    private final int yPipe = 0;

    private final int WIDTH = 100;
    private int HEIGHT = 0;

    private final int MIN_Y = 0;
    private final int MAX_Y = 350;

    private final int slit = 200;
    private JButton pipe1, pipe2;

    public Pipe(int xPipe) {
        this.xPipe = xPipe;
        HEIGHT = randomNumberInRange(MIN_Y, MAX_Y);
        pipe1 = new JButton();
        pipe2 = new JButton();
    }

    public void render() {
        pipe1.setBounds(xPipe, yPipe, WIDTH, HEIGHT);
        pipe2.setBounds(xPipe, HEIGHT + slit, WIDTH, HEIGHT_PNL - HEIGHT - slit);
        update();
    }

    public void update() {
        if (xPipe <= -WIDTH) {
            xPipe = WIDTH_PNL;
            HEIGHT = randomNumberInRange(MIN_Y, MAX_Y);
        }
        xPipe -= 5;
    }

    int randomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public int getxPipe() {
        return xPipe;
    }

    public void setxPipe(int xPipe) {
        this.xPipe = xPipe;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public JButton getPipe1() {
        return pipe1;
    }

    public void setPipe1(JButton pipe1) {
        this.pipe1 = pipe1;
    }

    public JButton getPipe2() {
        return pipe2;
    }

    public void setPipe2(JButton pipe2) {
        this.pipe2 = pipe2;
    }

}
