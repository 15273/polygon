package codewitemendi.Main;

/**
 * name:menachem mendel kalish
 * id:323110452
 * @version :14/12/2021
 * @author menachem mendel kalish
 * This tool takes on a convex
 * polygon and performs all kinds of operations on it
 * **/
public class Polygon {


    /**
     * Class variables
     * **/
    private final int MAX_VERTICES = 10;
    private Point[] _vertices;
    private int _noOfVertices;
    /**
     * Empty builder
     * **/
    public Polygon()
    {
        _noOfVertices = 0;
        _vertices = new Point[MAX_VERTICES];
    }
    /**
     * Gets a point from the user and adds it to the polygon
     * @param x kordinete of the point
     * @param y kordinate of the point
     * **/
    public boolean addVertex(int x, int y)
    {
        if (_noOfVertices >= MAX_VERTICES) {
            return false;
        }

        _vertices[_noOfVertices++] = new Point(x, y);

        return true;
    } /**
     *Gets a point from the user
     * and returns its position in the array
     * @param p point
     * **/
    public Point getNextVertex(Point p){
        for (int i=0;i<_noOfVertices;i++)
        {
            if (_vertices[i].equals(p) && i<_noOfVertices-1)
            {
                return _vertices[i+1];}

            if (_vertices[i].equals(p) && i==_noOfVertices){
                return _vertices[0];
            }
        }
        return null;
    }
    /**
     * @param  p
     * @return the number of the point you enter
     * */
// * find point p in the polygon
    public int findVertex(Point p)
    {
        for (int i=0;i<_noOfVertices;i++)
        {
            if (_vertices[i].equals(p))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return the highest vertex
     * **/
    // * Returns the highest point in the polygon
    //  * If there are two such returns the first of their
    public Point highestVertex()
    {
        if (_noOfVertices == 0)
            return null;
        int highestVertexIndex = 0;
        for (int i = 1; i < _noOfVertices; i++)
        {
            if (_vertices[i].getY() >
                    _vertices[highestVertexIndex].getY())
                highestVertexIndex = i;
        }
        Point result = new Point(_vertices[highestVertexIndex]);
        return result;
    }
    /**
     @return print the points of the poligon
      * **/
    public String toString()
    {
        if (_noOfVertices == 0)
            return "The polygon has 0 vertices.";

        String result = "The polygon has " + _noOfVertices +
                " vertices:\n(" + _vertices[0];
        for (int i = 1; i < _noOfVertices; i++)
            result += "," + _vertices[i];
        result += ")";
        return result;
    }
    /**
     @return the primeter of the poligon
      * **/
    public double calcPerimeter()
    {
        if (_noOfVertices < 2)
            return 0;

        if (_noOfVertices == 2)
            return _vertices[0].distance(_vertices[1]);
        double perimeter = 0;
        for (int i = 0; i < _noOfVertices - 1; i++)
            perimeter += _vertices[i].distance(_vertices[i + 1]);
        perimeter += _vertices[_noOfVertices - 1].distance(_vertices[0]);
        return perimeter;
    }


    /**
     @return print the area of the poligon
      * **/
    //* Calculates the polygon area
    public double calcArea()
    {
        double area = 0;
        int i = 0;
        double part1 = 0;
        double Heron = 0;
        if (_noOfVertices < 3) {
            return 0;
        }
        if (_noOfVertices > 2) {
            for (i = 1; i < _noOfVertices - 1; i++) {
                part1 = ((_vertices[0].distance(_vertices[i]) +
                        _vertices[0].distance(_vertices[i + 1]) +
                        _vertices[i].distance(_vertices[i + 1])) / 2);

                Heron = Math.sqrt(part1 * (part1 - _vertices[0].distance(_vertices[i])) *
                        (part1 - _vertices[0].distance(_vertices[i + 1])) *
                        (part1 - _vertices[i].distance(_vertices[i + 1])));
                area += Heron;
            }
        }
        return area;
    }
    /**
     @return true if the first poligon big then the second
      * **/
    public boolean isBigger(Polygon other)
    {
        return other.calcArea()<this.calcArea();
    }
    /**
     @return A square that surrounds the polygon
      * */

    public Polygon getBoundingBox(){
        Polygon rectangel_bounds = new Polygon();
        int y_h = 0;
        int y_low = 0;
        int x_h = 0;
        int x_low = 0;
        if (_noOfVertices < 3)
            return null;
        else {

            int highestVertexIndex = 0;
            int highestVertexIndex1 = 0;
            int lowest = 0;
            int lowest1 = 0;
            for (int i = 1; i < _noOfVertices; i++) {
                if (_vertices[i].getY() < _vertices[lowest].getY()) {
                    lowest = i;
                }
                if (_vertices[i].getY() >
                        _vertices[highestVertexIndex].getY()) {
                    highestVertexIndex = i;
                }

            }
            for (int i = 1; i < _noOfVertices; i++) {
                if (_vertices[i].getX() < _vertices[lowest1].getX()) {
                    lowest1 = i;
                }
                if (_vertices[i].getX() >
                        _vertices[highestVertexIndex1].getX()) {
                    highestVertexIndex1 = i;
                }
            }
            y_h = _vertices[highestVertexIndex].getY();
            y_low = _vertices[lowest].getY();
            x_h = _vertices[highestVertexIndex1].getX();
            x_low = _vertices[lowest1].getX();
        }

        rectangel_bounds .addVertex(x_low,y_low);
        rectangel_bounds .addVertex(x_h,y_low);
        rectangel_bounds .addVertex(x_h,y_h);
        rectangel_bounds .addVertex(x_low,y_h);
        return rectangel_bounds;
    }
}