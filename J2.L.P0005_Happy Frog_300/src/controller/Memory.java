/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author TASS
 */
public class Memory {
    /*
    point
    yFrog
    xPipeI, xPipeII     
     */
    
    private int point;
    private int xFrog;
    private int xPipeI;
    private int xPipeII;

    public Memory() {
    }

    public Memory(int point, int xFrog, int xPipeI, int xPipeII) {
        this.point = point;
        this.xFrog = xFrog;
        this.xPipeI = xPipeI;
        this.xPipeII = xPipeII;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getxFrog() {
        return xFrog;
    }

    public void setxFrog(int xFrog) {
        this.xFrog = xFrog;
    }

    public int getxPipeI() {
        return xPipeI;
    }

    public void setxPipeI(int xPipeI) {
        this.xPipeI = xPipeI;
    }

    public int getxPipeII() {
        return xPipeII;
    }

    public void setxPipeII(int xPipeII) {
        this.xPipeII = xPipeII;
    }

    
    
}
