package animator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.shape.Arc;

// Conjunto de objetos da animacao.
class ObjectSet {
    
    private Image[] images;
    private Move move;
    Random aleatorio=new Random();
    private ArrayList<Retangulo> retList = new ArrayList<Retangulo>();
    private ArrayList<Circulo> circList = new ArrayList<Circulo>();
    private ArrayList<Estrela> estList = new ArrayList<Estrela>();
    private ArrayList<Pentagono> pentList = new ArrayList<Pentagono>();
    int n=1;
    int ang=0;
    
    public ObjectSet(Dimension tela) {
        move=new Move(tela);
    }
    
    
    // Adiciona objetos da classe Image ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addImages(int n, Dimension dim, BufferedImage image, String path) {
        System.out.printf("Test: adding %d images\n", n);
        System.out.printf("Test: motion path %s\n", path);
        images = new Image[n];
        for (int i = 0; i < images.length; i++) {
            Point p = new Point(aleatorio.nextInt(dim.width-150), aleatorio.nextInt(dim.height-150));
            images[i] = new Image(p, image, path);
        }
    }
    
    // Adiciona objetos da classe Star ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addStars(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d stars\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i=0; i<n; i++) {
            Point p=new Point(aleatorio.nextInt(500), aleatorio.nextInt(500));
            Estrela novo=new Estrela(p, path);
            estList.add(novo);
        }
    }
    
    // Adiciona objetos da classe Star ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addRectangles(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d rectangles\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i=0; i<n; i++) {
            Point p=new Point(aleatorio.nextInt(dim.width-150), aleatorio.nextInt(dim.height-150));
            Retangulo novo=new Retangulo(p, 30+aleatorio.nextInt(150), 30+aleatorio.nextInt(150), path);
            retList.add(novo);
        }
    }
    
    void addPentagons(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d pentagons\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i=0; i<n; i++) {
            Point p=new Point(aleatorio.nextInt(dim.width-150), aleatorio.nextInt(dim.height-150));
            Pentagono novo=new Pentagono(p, dim, path);
            pentList.add(novo);
        }
    }
    
    // Adiciona objetos da classe Star ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addCircles(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d rectangles\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i=0; i<n; i++) {
            Point p=new Point (aleatorio.nextInt(dim.width-150), aleatorio.nextInt(dim.height-150));
            Circulo novo=new Circulo(p, 30+aleatorio.nextInt(150), 30+aleatorio.nextInt(150), path);
            circList.add(novo);
        }
    }
    
    
    // Desenha cada um dos objetos da animacao.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void drawAll(Graphics g) {
        System.out.println("drawAll");
        if (retList!=null) {
            for (int i=0; i<retList.size(); i++) 
                retList.get(i).drawRet(g);
        }
        if (images!=null) {
            for(int i=0; i<images.length; i++) 
                images[i].draw(g);
        }
        if (circList!=null){
            for (int i=0; i<circList.size(); i++)
                circList.get(i).drawCirc(g);
        }
        if (estList!=null){
            for(int i=0; i<estList.size(); i++)
                estList.get(i).drawEst(g);
        }
        if (pentList!=null) {
            for (int i=0; i<pentList.size(); i++)
                pentList.get(i).drawPentagon(g);
        }
    }
    

    // Move cada um dos objetos da animacao.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void moveAll() {
       System.out.println("moveAll");
       
       if (images!=null) {
           for (int i=0; i<images.length; i++) {
               if (images[i].pathType().equalsIgnoreCase("Line"))
                   images[i].setPos(move.moveLine(images[i].getPos()));
               if (images[i].pathType().equalsIgnoreCase("Circle"))
                   images[i].setPos(move.moveCircle(images[i].getPos(), images[i].getPos(), ang));
                
           }
       }
       
       if (retList!=null) {
            for (int i=0; i<retList.size(); i++) {
                if (retList.get(i).pathType().equalsIgnoreCase("Line"))
                    retList.get(i).setPoint(move.moveLine(retList.get(i).getPoint()));
                else if (retList.get(i).pathType().equalsIgnoreCase("Circle"))
                    retList.get(i).setPoint(move.moveCircle(retList.get(i).getPoint(),retList.get(i).getCentro(), ang)); 
                else if (retList.get(i).pathType().equalsIgnoreCase("Zoom")) //ZigZag
                    retList.get(i).setPoint(move.moveZigZag(retList.get(i).getPoint(), n));
            }
       }
       
       if (circList!=null) {
           for (int i=0; i<circList.size(); i++) {
               if (circList.get(i).pathType().equals("Line"))
                   circList.get(i).setPoint(move.moveLine(circList.get(i).getPoint()));
               else if (circList.get(i).pathType().equalsIgnoreCase("Circle"))
                   circList.get(i).setPoint(move.moveCircle(circList.get(i).getPoint(), circList.get(i).getCentro(), ang));
               else if (circList.get(i).pathType().equalsIgnoreCase("Zoom"))
                   circList.get(i).setPoint(move.moveZigZag(circList.get(i).getPoint(), n));
           }
       }
       
       if (estList!=null) {
           for (int i=0; i<estList.size(); i++) {
               if (estList.get(i).pathType().equalsIgnoreCase("Line"))
                       estList.get(i).setPoint(move.moveLine(estList.get(i).getPoint()));
               if(estList.get(i).pathType().equalsIgnoreCase("Cirle"))
                   estList.get(i).setPoint(move.moveCircle(estList.get(i).getPoint(), estList.get(i).getCentro(), ang));
               if(estList.get(i).pathType().equalsIgnoreCase("Zoom"))
                   estList.get(i).setPoint(move.moveZigZag(estList.get(i).getPoint(), n));
           }
       }
       
       if(pentList!=null)
           for (int i=0; i<pentList.size(); i++){
               if(pentList.get(i).pathType().equalsIgnoreCase("Line"))
                   pentList.get(i).setPoint(move.moveLine(pentList.get(i).getPoint()));
               if(pentList.get(i).pathType().equalsIgnoreCase("Cirle"))
                   pentList.get(i).setPoint(move.moveCircle(pentList.get(i).getPoint(), pentList.get(i).getPoint(), ang));
               if(pentList.get(i).pathType().equalsIgnoreCase("Zoom"))
                   pentList.get(i).setPoint(move.moveZigZag(pentList.get(i).getPoint(), n));
           }
       n++;
       ang++;
       if (ang==360)
           ang=0;
    }
       
}

