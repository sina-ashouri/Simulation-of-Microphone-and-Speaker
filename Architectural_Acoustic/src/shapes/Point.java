package shapes;

import java.awt.Graphics;

public class Point {

	public double x,y;
	public String Name;
	
	public Point() {
		this(10,10,"point");
	}

	public Point(double X, double Y){
		this.x = X;
		this.y = Y;
	}
	
	public Point(double X, double Y,String N){
		this.x = X;
		this.y = Y;
		this.Name = N;
	}
	
	public Point getposition(){
		return this;
	}
	
	public double getdistance(Point p){
		return Math.sqrt(Math.pow(p.x - this.x,2.00) + Math.pow(p.y - this.y,2.00));
	}
	
	public double getdistanceX(Point p){
		return p.x-this.x;
	}
	
	public double getdistanceY(Point p){
		return p.y - this.y;
	}
	
	public void setposition(double X,double Y){
		this.x = X;
		this.y = Y;
	}
	
}
