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
public class Pentagono {
    
    private String pathType;
    private Point p;
    private Point org;
    private Dimension d;
    private int r1, r2;
    private int[] x, y, x2, y2;
    Random aleatorio=new Random();
    
    public Pentagono(Point centro, Dimension d, String pathType) {
        this.pathType=pathType;
        this.r1=20+aleatorio.nextInt(30);
        this.r2=2*r1;
        this.x=new int[3];
        this.y=new int[3];
        this.x2=new int[10];
        this.y2=new int[10];
        if (centro.x<100)
            centro.x=100;
        if(centro.y<100)
            centro.y=100;
        this.p=new Point(centro.x, centro.y);
        this.pathType=pathType;
        this.org=new Point (centro.x, centro.y);
        this.d=new Dimension(d.width, d.height);
    }
    
    public void drawPentagon(Graphics g) {
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
            g.setColor(Color.green);
            g.fillPolygon(x,y,2);
        }
        g.fillPolygon(x2,y2,5);           
    }
    
    
    public void setPoint(Point p) {
        this.p=p;
    }
    
    public Point getPoint() {
        return p;
    }
    
    public String pathType() {
        return pathType;
    }
}


