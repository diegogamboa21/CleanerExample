/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Diego Gamboa
 */
public class RectangleObject {
    
    public int x;
    public int y;
    public int width;
    public int height;

    public RectangleObject() {
        this(0, 0, 0, 0);
    }

    public RectangleObject(RectangleObject r) {
        this(r.x, r.y, r.width, r.height);
    }

    public RectangleObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public RectangleObject(int width, int height) {
        this(0, 0, width, height);
    }

//    public RectangleObject(Point p, Dimension d) {
//        this(p.x, p.y, d.width, d.height);
//    }
//
//    public RectangleObject(Point p) {
//        this(p.x, p.y, 0, 0);
//    }
//
//    public RectangleObject(Dimension d) {
//        this(0, 0, d.width, d.height);
//    }

    public double getX() {
        return x;
    }
    
    public double getY(){
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
