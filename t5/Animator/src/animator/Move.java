/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Dimension;
import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author OTAVIO
 */
class Move {
    private Dimension tela;

    public Move(Dimension tela) {
        this.tela=tela;
    }
    
    public Point moveLine(Point p) {
        p.setLocation(p.getX()+10, p.getY());
        if (p.getX()>tela.width)
            p.setLocation(-100, p.getY());
        return p;
    }
    
    
    public Point moveZigZag(Point p, int n) {   //é chamado como Zoom (não tinha como mudar o nome do movimento na interface)
        if (n%2==0){
            p.setLocation(p.getX()+50, p.getY()+50);
            if (p.getY() > tela.height)
                 p.setLocation(p.getX(), 0);
        }
        else {
            p.setLocation(p.getX()-50, p.getY()+50);
           // if (p.getY() < tela.height)
             //   p.setLocation (p.getX(), 0);
            
        }
        return p;
    }
    
    
    public Point moveCircle(Point p, Point centro, double ang) {
       
        p.x = (int) (p.x+60*cos(ang)-centro.x);
        p.y = (int) (p.y+60*sin(ang)-centro.y);
        
        //float theta=60;
        //p.setLocation(p.x-Retangulo.x*Math.cos(angRad), p.y+Retangulo.y*Math.sin(angRad));
        return p;
    }
    
}
