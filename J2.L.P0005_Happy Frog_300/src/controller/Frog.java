/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author TASS
 */
public class Frog {

    private JLabel frog;
    private final int xFrog = 30;
    private int yFrog = 300;
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private float accelerationDown = 0;

    private final int HEIGHT_PNL = 600;
    private final int WIDTH_PNL = 900;

    private boolean isClicked = false;
    private boolean isAlive = true;

    public Frog(int yFrog) {
        this.yFrog = yFrog;
        frog = new JLabel(new ImageIcon("images\\frog.png"));
//        frog = new JLabel();
//         frog.setBounds(xFrog, yFrog, WIDTH, HEIGHT);
//        setImageForLabel(frog, "images\\frog.png");
    }

    public void render() {
        frog.setBounds(xFrog, yFrog, WIDTH, HEIGHT);
        update();
    }

    public void update() {
        fall();
        fly();
    }

    public void fall() {
        accelerationDown += 0.3;
        yFrog += accelerationDown;
    }

    public void fly() {
        if (isClicked) {
            isClicked = false;
            if (yFrog <= WIDTH) {
                accelerationDown = 0;
                return;
            } else {
                accelerationDown = -5;
            }
        }
    }

    ImageIcon resizedImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new ImageIcon(img);
    }

    public void setImageForLabel(JLabel label, String path) {
        ImageIcon myIcon = new ImageIcon(getClass().getClassLoader().getResource(path));
        myIcon = resizedImage(myIcon, label.getWidth(), label.getHeight());
        label.setIcon(myIcon);
    }

    public JLabel getFrog() {
        return frog;
    }

    public void setFrog(JLabel frog) {
        this.frog = frog;
    }

    public int getyFrog() {
        return yFrog;
    }

    public void setyFrog(int yFrog) {
        this.yFrog = yFrog;
    }

    public boolean isIsAlive(Pipe pipeI, Pipe pipeII) {
        if (yFrog >= HEIGHT_PNL - HEIGHT) {
            System.err.println("1");
            isAlive = false;
        } else if (pipeI.getxPipe() >= (xFrog - pipeI.getWIDTH()) && pipeI.getxPipe() <= (xFrog + WIDTH)) {
            if (yFrog <= pipeI.getHEIGHT() || yFrog >= (pipeI.getHEIGHT() + pipeI.getSlit() - HEIGHT)) {
                System.err.println("2");

                isAlive = false;
            }
        } else if (pipeII.getxPipe() >= (xFrog - pipeII.getWIDTH()) && pipeII.getxPipe() <= (xFrog + WIDTH)) {
            if (yFrog <= pipeII.getHEIGHT() || yFrog >= (pipeII.getHEIGHT() + pipeII.getSlit() - HEIGHT)) {
                System.err.println("3");

                isAlive = false;
            }
        }
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isIsClicked() {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public int getxFrog() {
        return xFrog;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public float getAccelerationDown() {
        return accelerationDown;
    }

    public int getHEIGHT_PNL() {
        return HEIGHT_PNL;
    }

    public int getWIDTH_PNL() {
        return WIDTH_PNL;
    }

    public boolean isIsAlive() {
        return isAlive;
    }
    
    

}
