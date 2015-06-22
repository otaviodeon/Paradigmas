package animator;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

// Uma imagem na animacao.
class Image {

    BufferedImage img;
    Point pos;
    private String pathType;

    public Image(Point pos, BufferedImage img, String pathType) {
        this.pos = pos;
        this.img = img;
        this.pathType=pathType;
    }

    public Point getPos() {
        return pos;
    }
   
    public void setPos(Point pos) {
        this.pos=pos;
    }
    
    public String pathType() {
        return pathType;
    }
    
    public void draw(Graphics g) {
        g.drawImage(img, (int) pos.getX(), (int) pos.getY(), null);
    }
    
    // Move a imagem de acordo segundo a trajetoria selecionada.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    public void move() {
       
    }
}
