package shapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Mainwindow;

public class Image extends Shape {

	private BufferedImage BackgroundImage;
	private String path;
	
	public  Image(String s) {
		this.path = s;
		try {                
			BackgroundImage = ImageIO.read(new File(this.path));
	    } catch (IOException ex) {
	            // handle exception...
	    }
	
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
		G.drawImage(BackgroundImage, 0, 0, Mainwindow.mainPanel.getWidth(), Mainwindow.mainPanel.getHeight(), Mainwindow.mainPanel);
		
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
	
	public void setImage(String s){
		this.path = s;
		try {                
			BackgroundImage = ImageIO.read(new File(this.path));
	    } catch (IOException ex) {
	            // handle exception...
	    }
	}

}
