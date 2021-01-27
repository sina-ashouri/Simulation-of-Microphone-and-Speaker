package shapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Mainwindow;

public class Microphone extends Shape {
	private BufferedImage img;
	private int freq;
	private double intensity;
	public static ArrayList<Microphone> AllMicrophones = new ArrayList<>();
	
	public Microphone() {
		Allshapes.add(this);
		AllMicrophones.add(this);
		try {
			this.img =  ImageIO.read(new File("phone.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.freq = 0;
	}
	
	@Override
	public boolean isIn(Point p) {
		// TODO Auto-generated method stub
		if(30 >= (int)(p.getdistance(new Point(this.getCenter().x , this.getCenter().y ))))
			return true;
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
		G.drawImage(this.img, (int)this.getCenter().x  - (int)img.getWidth()/2, (int)this.getCenter().y - (int)img.getHeight()/2, Mainwindow.mainPanel);
		G.drawString("I : "+ this.freq, (int)this.getCenter().x - 30, (int)this.getCenter().y+40);
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
	public void setfreq(int i){
		this.freq = i ;
	}
	public void setIntensity(){
		
	}

}
