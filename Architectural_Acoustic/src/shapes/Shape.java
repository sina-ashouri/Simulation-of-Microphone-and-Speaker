package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import main.*;

public abstract class Shape {
	Point center;
	Color fillcolor;
	Color bordercolor;
	String Name;
	double angle = 0.00;
	public static ArrayList<Shape> Allshapes = new ArrayList<>();
	public Shape() {
		this(new Point(),Color.BLACK,Color.BLACK,"shape");
		Allshapes.add(this);
		Iterator <Shape> itt = Allshapes.iterator();
		//select current shape 
		
	}
	
	public Shape(Point ce,Color fc,Color bc,String N){
		this.center = ce;
		this.fillcolor = fc;
		this.bordercolor = bc;
		this.Name = N;
		this.angle = 0.00;
		Allshapes.add(this);
	}
	
	public Shape(Shape s){
		this.center = s.getCenter();
		this.fillcolor = s.getfillcolor();
		this.bordercolor = s.getbordercolor();
		this.Name = s.getName();
		this.angle = s.getangle();
		Allshapes.add(this);
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center=center;
	}
	
	
	public String getName() {
		return Name;
	}
	public Color getfillcolor(){
		return fillcolor;
	}
	public Color getbordercolor(){
		return bordercolor;
	}
	public void setfillcolor(Color f){
		this.fillcolor = f;
	}
	public void setbordercolor(Color b){
		this.bordercolor = b;
	}
	public void setName(String name) {
		this.Name=name;
	}
	public String toString() {
		return "Shape:"+Name+center;
	}
	public double getangle(){
		return angle;
	}
	public void setangle(double ang){
		this.angle = ang;
	}
	
	
	public abstract boolean isIn(Point p); // return true if a point is in a shape
	public abstract double getArea();// calculate Area of shape
	public abstract String getType();// return type of shape
	public abstract void Render(Graphics G);// draw shape
	public abstract Point getLP1();// return point 1 of line
	public abstract Point getLP2();// return point 2 of line
	public abstract int getN();// return number of sides of a polygon
	public abstract int getL();// return side length of a polygon
	public abstract int getW();// return width of a rectangle
	public abstract int getH();// return height of a rectangle 
	public abstract Point getTP1();// return point 1 of triangle
	public abstract Point getTP2();// return point 2 of triangle
	public abstract Point getTP3();// return point 3 of triangle 
	public abstract int getR();// return radius of circle 
	public abstract void setPoints();// set points for triangle and line and rectangle 
	public abstract void setRotation(int a);// rotate shape 
}
