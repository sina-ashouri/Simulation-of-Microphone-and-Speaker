 package main;

import java.awt.Color;

import shapes.Circle;
import shapes.Point;
import shapes.Shape;
import shapes.Speaker;
import shapes.Wall;

public class MoveBy implements Runnable{

	private Circle shape;
	
	private Thread t;
	private double c;//cos theta 
	private double s;//sin theta
	private Thread tt;// Thread of starting
	
	int k = 0;
	double time = 0;
	
	
	public MoveBy(Circle sh , double vx,double vy){
		shape = sh;
		c = (vx/Math.sqrt(Math.pow(vx, 2.00)+Math.pow(vy, 2.00)));
		s = (vy/Math.sqrt(Math.pow(vx, 2.00)+Math.pow(vy, 2.00)));
		time = 0.00;
	}
	
	public void settread(Thread t){
		this.tt = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		/*if(this.shape.Frequency < 1){
			this.shape.setCenter(new Point(1000000.0,1000000.0));
			return;
		}*/
		if(shape.getCenter().x > Mainwindow.mainPanel.getWidth() + 100 || shape.getCenter().x < -100 || shape.getCenter().y > Mainwindow.mainPanel.getHeight() + 100 || shape.getCenter().y < -100){
			this.shape.setCenter(new Point(1000000.0,1000000.0));
			return;
		}
		try {
			shape.setCenter(new Point(shape.getCenter().x + c,shape.getCenter().y + s));
			System.out.println(shape.Frequency);
			for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					for(int j = 1 ; j < Wall.AllWalls.get(i).points.size() ; j++){
						double d1 = shape.getCenter().getdistance(Wall.AllWalls.get(i).points.get(j-1));
						double d2 = shape.getCenter().getdistance(Wall.AllWalls.get(i).points.get(j));
						double d = Wall.AllWalls.get(i).points.get(j-1).getdistance(Wall.AllWalls.get(i).points.get(j));
					if((d1+d2)-d < 0.05){
						
					if(shape.isContact(i, j-1, j) == false){
							shape.setContact(i, j-1, j);
							//shape.setFrequency((int)(shape.Frequency*0.01*(100.00 - (Wall.AllWalls.get(i).getReflectance()+Wall.AllWalls.get(i).getAbsorbance()))));
							System.out.println(shape.Frequency);
							double dx = Math.abs(Wall.AllWalls.get(i).points.get(j-1).getdistanceX(Wall.AllWalls.get(i).points.get(j)));
							double dy = Math.abs(Wall.AllWalls.get(i).points.get(j-1).getdistanceY(Wall.AllWalls.get(i).points.get(j)));
							double shi = Math.atan(dy/dx);
							if(Wall.AllWalls.get(i).points.get(j-1).x > Wall.AllWalls.get(i).points.get(j).x){
								if(Wall.AllWalls.get(i).points.get(j-1).y > Wall.AllWalls.get(i).points.get(j).y){
									shi *= -1.00;
								}
							}
							if(Wall.AllWalls.get(i).points.get(j).x > Wall.AllWalls.get(i).points.get(j-1).x){
								if(Wall.AllWalls.get(i).points.get(j).y > Wall.AllWalls.get(i).points.get(j-1).y){
									shi *= -1.00;
								}
							}
							double theata = (Math.atan(s/c));
							//System.out.println(theata);
							Circle sh = new Circle(shape.getCenter().x,shape.getCenter().y,3,Color.BLACK,Color.BLACK,"");
							sh.setContact(i, j-1, j);							
							sh.setFrequency((int)(shape.Frequency*0.01*Wall.AllWalls.get(i).getReflectance()));
							double phi = 2*theata + 2*shi ;
							shape.setCenter(new Point(10000.00, 10000.00));
							Thread th = new Thread(new MoveBy(sh, c*Math.cos(-phi) - s*Math.sin(-phi) , c*Math.sin(-phi) + s*Math.cos(-phi)));
							th.start();
						}
					}
					}
			}
			Mainwindow.mainPanel.repaint();
			t.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	}

}
