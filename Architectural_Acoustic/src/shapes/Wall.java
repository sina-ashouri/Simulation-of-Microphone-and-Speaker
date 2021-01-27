package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import main.Mainwindow;

public class Wall extends Shape {

	private boolean isPainting = true;
	private int height = 0;
	private int absorbance = 0;
	private int reflectance = 0;
	public ArrayList<Point> points = new ArrayList<>();
	public static ArrayList<Wall> AllWalls = new ArrayList<>();
	
	public Wall(Point p,int abs , int ref ,int h){
		Allshapes.add(this);
		AllWalls.add(this);
		this.isPainting = true;
		this.points.add(p);
		this.absorbance = abs;
		this.reflectance = ref;
		this.height = h;
	}
	
	@Override
	public boolean isIn(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Render(Graphics G) {
		// TODO Auto-generated method stub
			// line and circle
			Graphics2D g2 = (Graphics2D)G;
			if(this.absorbance < 20)
				g2.setStroke(new BasicStroke(1));
			if(this.absorbance >= 20 && this.absorbance < 40)
				g2.setStroke(new BasicStroke(2));
			if(this.absorbance >= 40 && this.absorbance < 60)
				g2.setStroke(new BasicStroke(3));
			if(this.absorbance >= 60 && this.absorbance < 80)
				g2.setStroke(new BasicStroke(4));
			if(this.absorbance >= 80 && this.absorbance < 100)
				g2.setStroke(new BasicStroke(5));
			
			if(this.reflectance < 20){
				G.setColor(Color.BLUE);
			}
			else{
			G.setColor(Color.RED);
			}
			for(int i = 1 ; i < this.points.size() ; i++){
				G.drawLine((int)this.points.get(i-1).x, (int)this.points.get(i-1).y, (int)this.points.get(i).x, (int)this.points.get(i).y);
			}			
			G.setColor(Color.BLACK);
			for(int i = 0 ; i < this.points.size() ; i++){
				G.fillOval((int)this.points.get(i).x - 4, (int)this.points.get(i).y - 4 , 8, 8);
			}
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
		return 0;
	}

	@Override
	public void setPoints() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRotation(int a) {
		// TODO Auto-generated method stub

	}
	
	public void setHeight(int h){
		this.height = h;
	}
	
	public void setAbsorbance(int a){
		this.absorbance = a;
	}
	
	public void setReflectance(int a){
		this.reflectance = a;
	}

	public int getHeight(){
		return this.height;
	}
	
	public int getAbsorbance(){
		return this.absorbance;
	}
	
	public int getReflectance(){
		return this.reflectance;
	}
	
	public void paintWall(Point p){
		if ( this.isPainting == true) {
					this.points.add(p);
				Mainwindow.mainPanel.CreatingWall = false;
		}
	}
	
	public void setPainting(boolean t){
		this.isPainting = t;
	}
	
	
}


	
