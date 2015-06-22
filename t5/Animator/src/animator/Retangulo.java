/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author OTAVIO
 */
public class Retangulo {
    public static int x;
    public static int y;
    private String pathType;
    private Point p;
    Point centro;
    
    public Retangulo(Point p, int x, int y, String pathType ) {
        this.x=x;
        this.y=y;
        this.p=p;
        this.centro=p;
        this.pathType=pathType;
    }
    
    public void drawRet(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)p.getX(), (int)p.getY(), this.x, this.y);
        
        
    }
    
    public Point getPoint() {
        return p;
    }
    
    
    public void setPoint(Point p) {
        this.p=p;
    }
    
    public Point getCentro() {
        return centro;
    }
    
    public String pathType() {
        return pathType;
    }
}
