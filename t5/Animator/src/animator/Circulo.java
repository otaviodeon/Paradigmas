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
public class Circulo {
    private int raio;
    private int raio2;
    private String pathType;
    Point p;
    Point centro;
    
    public Circulo(Point p, int raio, int raio2, String pathType){
        this.p=p;
        this.centro=p;
        this.raio=raio;
        this.raio2=raio2;
        this.pathType=pathType;
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
    
    public void drawCirc(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(p.x, p.y, raio, raio); 
    }
}
