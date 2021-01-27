package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.geom.*;
public class Polygon extends Shape{

	int numb,length;
	public static int sumofArea;
	public static int sumofArea2;
	public Polygon() {
		// TODO Auto-generated constructor stub
		super();
		Allshapes.add(this);
	}

	public Polygon(int x,int y,int n,int l,Color fc ,Color bc,String N){
		super(new Point(x,y),fc,bc,N);
		this.numb = n;
		this.length = l;
		Allshapes.add(this);
	}
	public Polygon(Polygon P){
		super(P.getCenter(),P.getfillcolor(),P.getbordercolor(),P.getName());
		this.numb = P.getnumb();
		this.length = P.getlength();
		Allshapes.add(this);
	}
	public int getnumb(){
		return numb;
	}
	
	public int getlength(){
		return length;
	}
	public double TriangleArea(Point P1,Point P2,Point P3){
		return Math.abs((P1.x*P2.y)+(P2.x*P3.y)+(P3.x*P1.y)-(P1.y*P2.x)-(P2.y*P3.x)-(P3.y*P1.x))/2;
	}
	@Override
	public boolean isIn(Point p) {
		// TODO Auto-generated method stub
		
		
		sumofArea =0;
		sumofArea2=0;
		int[] xpoint = new int[numb];
		int[] ypoint = new int[numb];
		
		for (int i = 0 ; i < numb ; i++){
			xpoint[i] = (int)(this.getCenter().x+length*Math.cos((i * 2 * Math.PI/numb)-this.getangle()));
			ypoint[i] = (int)(this.getCenter().y+length*Math.sin((i * 2 * Math.PI/numb)-this.getangle()));
		}
		for (int i = 0 ; i < numb - 1 ;i++){
			sumofArea += (int)(TriangleArea(new Point(xpoint[i],ypoint[i]) , p , new Point(xpoint[i+1],ypoint[i+1])));
		}
		sumofArea += (int)(TriangleArea(new Point(xpoint[0],ypoint[0]) , p , new Point(xpoint[numb-1],ypoint[numb-1])));
		for (int i = 0 ; i < numb - 1 ;i++){
			sumofArea2 += (int)(TriangleArea(new Point(xpoint[i],ypoint[i]) , this.getCenter() , new Point(xpoint[i+1],ypoint[i+1])));
		}
		sumofArea2 += (int)(TriangleArea(new Point(xpoint[0],ypoint[0]) , this.getCenter() , new Point(xpoint[numb-1],ypoint[numb-1])));
		if(Math.abs(sumofArea - sumofArea2) <= 3)
			return true;
		return false;
	}

	@Override
	public double getArea() {
		return 0.25*numb*length*length*(1/Math.tan(Math.PI/numb));
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "polygon";
	}

	@Override
	public void Render(Graphics G) {
		// TODO Auto-generated method stub
		
		int[] xpoints = new int[numb];
		int[] ypoints = new int[numb];
		
		for (int i = 0 ; i < numb ; i++){
			xpoints[i] = (int)(this.getCenter().x+length*Math.cos((i * 2 * Math.PI/numb)-this.getangle()));
			ypoints[i] = (int)(this.getCenter().y+length*Math.sin((i * 2 * Math.PI/numb)-this.getangle()));
		}
		G.setColor(fillcolor);
		G.fillPolygon(xpoints, ypoints, numb);
		G.setColor(bordercolor);
		G.drawPolygon(xpoints, ypoints, numb);
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
		return numb;
	}

	@Override
	public int getL() {
		// TODO Auto-generated method stub
		return length;
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
		return 0;
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

}
