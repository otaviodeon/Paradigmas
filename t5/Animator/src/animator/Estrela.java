/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Random;

/**
 *
 * @author OTAVIO
 */
public class Estrela {
    
    private String pathType;
    private Point p, centro;
    private int r1, r2;
    private int[] x, y, x2, y2;
    Random aleatorio=new Random();
    
    public Estrela(Point p, String pathType) {
        this.r1=20+aleatorio.nextInt(30);
        this.r2=2*r1;
        this.x=new int[3];
        this.y=new int[3];
        this.x2=new int[10];
        this.y2=new int[10];
        this.p=p;
        this.centro=p;
        this.pathType=pathType;
    } 
            
    
    public void drawEst(Graphics g) {
        double angulo=Math.PI/5;
        int aux=0;
        for (int i=0; i<5; i++) {
            x[0]=(int) ((r1*cos(angulo))+p.x);
            y[0]=(int) ((r1*sin(angulo))+p.y);
            x2[aux]=x[0];
            y2[aux]=y[0];
            aux++;
            angulo+=Math.PI/5;
            x[1]=(int) ((r2*cos(angulo))+p.x);
            y[1]=(int) ((r2*sin(angulo))+p.y);
            angulo+=Math.PI/5;
            x[2]=(int) ((r1*cos(angulo))+p.x);
            y[2]=(int) ((r1*sin(angulo))+p.y);
            x2[aux]=x[2];
            y2[aux]=y[2];
            g.setColor(Color.yellow);
            g.fillPolygon(x,y,3);
        }
        g.fillPolygon(x2, y2,5);           
    }
    
    public Point getCentro(){
        return centro;
    }
    
    public void setPoint (Point p) {
        this.p=p;
    }
    
    public Point getPoint () {
        return p;
    }
            
    public String pathType () {
        return pathType;
    }
}
