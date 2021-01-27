package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Circle extends Shape {

	int radius;
	public int Health;
	public int Frequency;
	public int Max_freq;
	public static ArrayList<Circle> Allcircles = new ArrayList<>();
	private int c_wall;
	private int c_p1;
	private int c_p2;

	public Circle() {
		super();
		this.Health = 10;
		this.c_wall = -1;
		this.c_p1 = -1;
		this.c_p2 = -1;
		Allshapes.add(this);
		Allcircles.add(this);
	}
	
	public Circle(double x,double y,int r,Color fc,Color bc,String N) {
		super(new Point(x,y),fc,bc,N);
		this.radius = r;
		this.Health = 4;
		this.c_wall = -1;
		this.c_p1 = -1;
		this.c_p2 = -1;
		Allshapes.add(this);
		Allcircles.add(this);
	}
	
	public Circle(Circle C){
		super(C.getCenter(),C.getfillcolor(),C.getbordercolor(),C.getName());
		this.radius = C.getradius();
		this.Health = 4;
		this.c_wall = -1;
		this.c_p1 = -1;
		this.c_p2 = -1;
		Allshapes.add(this);
		Allcircles.add(this);
	}
	
	public int getradius(){
		return radius;
	}
	
	@Override
	public boolean isIn(Point p) {
		// TODO Auto-generated method stub
		if(radius >= (int)(p.getdistance(new Point(this.getCenter().x , this.getCenter().y ))))
			return true;
		return false;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		
		return Math.PI*radius*radius;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "circle";
	}

	@Override
	public void Render(Graphics G) {
		
	
		
		 Graphics2D g = (Graphics2D) G;
		    /* Enable anti-aliasing and pure stroke */
		    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		    /* Construct a shape and draw it */
		    Ellipse2D.Double shape = new Ellipse2D.Double(this.getCenter().x - radius, this.getCenter().y - radius,2*radius, 2*radius);
		    g.setColor(this.fillcolor);
		    g.fill(shape);
		    
	}

	@Override
	public Point getLP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getW() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getTP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getTP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getTP3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getR() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public void setPoints() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void setRotation(int a) {
		// TODO Auto-generated method stub
		
	}
	
	public void setFrequency(int i){
		this.Frequency = i;
	}

	public void setMaxFrequency(int i){
		this.Max_freq = i;
	}
	
	public void setContact(int i,int j,int k){
		this.c_wall = i;
		this.c_p1 = j;
		this.c_p2 = k;
	}
	
	public boolean isContact(int i,int j,int k){
		if(this.c_wall == i && this.c_p1 == j && this.c_p2 == k)
			return true;
		return false;
	}
	
}
