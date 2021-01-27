package main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import shapes.*;

public class PaintPanel extends JPanel
{
	public static String timeS;
	private static final long serialVersionUID = 5898156464924142361L;
	ListenersCollection listener = new ListenersCollection();
	public static int mousex,mousey;
	//private int DX,DY; //distance between center of selected shape and mouse
	public boolean isCtrl = false;
	public boolean CreatingWall = false;
	public int abs,ht,ref; // wall absorbance and ht
	public Image image = new Image("");
	public PaintPanel()
	{
		addMouseListener(listener);
		addMouseMotionListener(listener);
		setFocusable(true);
		addKeyListener(listener);
		addFocusListener(listener);
		
	}
	void render(Graphics G)
	{// draw panel
		G.setColor(Color.white);
		G.fillRect(0, 0, this.getWidth(), this.getHeight());
		G.setColor(Color.black);
		G.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		////////
		////////
		Graphics2D g2 = (Graphics2D) G;
		g2.setStroke(new BasicStroke(4));
		G.setFont(new Font("Arial",Font.BOLD,15));
		image.Render(G);
		for(int i = 0 ; i < Shape.Allshapes.size() ; i++){
			Shape.Allshapes.get(i).Render(G);
		} 
		////////
	}

	class ListenersCollection implements MouseListener, MouseMotionListener, KeyListener, FocusListener
	{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			mousex = arg0.getPoint().x;
			mousey = arg0.getPoint().y;
			Mainwindow.mousepos.setText("X:"+PaintPanel.mousex+"Y:"+PaintPanel.mousey);
			
			for(int i = 0 ; i < Shape.Allshapes.size() ; i++){
				if(Shape.Allshapes.get(i).isIn(new Point(arg0.getPoint().x , arg0.getPoint().y))){
					Shape.Allshapes.get(i).setCenter(new Point(arg0.getPoint().x , arg0.getPoint().y));
					Mainwindow.mainPanel.repaint();
				}	
			}
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			mousex = arg0.getPoint().x;
			mousey = arg0.getPoint().y;
			Mainwindow.mousepos.setText("X:"+Mainwindow.mainPanel.mousex+"Y:"+Mainwindow.mainPanel.mousey);
		}
		
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			// TODO Auto-generated method stub
				if(Mainwindow.deletrad.isSelected()){
					for(int i = 0; i <Speaker.AllSpeakers.size() ; i++){
						if(Speaker.AllSpeakers.get(i).isIn(new Point(arg0.getX(),arg0.getY()))){
							Speaker.AllSpeakers.remove(i);
						}
					}
					for(int i = 0; i <Microphone.AllMicrophones.size() ; i++){
						if(Microphone.AllMicrophones.get(i).isIn(new Point(arg0.getX(),arg0.getY()))){
							Microphone.AllMicrophones.remove(i);
						}
					}
					for(int i = 0; i <shapes.Shape.Allshapes.size() ; i++){
						if(shapes.Shape.Allshapes.get(i).isIn(new Point(arg0.getX(),arg0.getY()))){
							shapes.Shape.Allshapes.remove(i);
						}
					}
				}
				if(!Mainwindow.selectrad.isSelected() && !Mainwindow.deletrad.isSelected()){
				if(CreatingWall == true){
					new Wall(new Point(arg0.getX(),arg0.getY()) , abs , ref, ht);
				}
				for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					Wall.AllWalls.get(i).paintWall(new Point(arg0.getX(),arg0.getY()));
				}
				}
				
				if(Mainwindow.selectrad.isSelected()){
				for(int i = 0 ; i < Speaker.AllSpeakers.size() ; i++){
					if(Speaker.AllSpeakers.get(i).isIn(new Point(arg0.getX(),arg0.getY()))){
						
						for(int j = 0 ; j < 36 ; j++){
							Circle s = new Circle(Speaker.AllSpeakers.get(i).getCenter().x,Speaker.AllSpeakers.get(i).getCenter().y,3,Color.BLACK,Color.BLACK,"");
							s.setFrequency(Speaker.AllSpeakers.get(i).getFrequency());
							s.setMaxFrequency(Speaker.AllSpeakers.get(i).getFrequency());
							Thread t = new Thread(new MoveBy(s, Math.cos(10*j*Math.PI/180), Math.sin(10*j*Math.PI/180)));
							t.start();
						}
					}
				}
				}
				
				repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			mousex = arg0.getPoint().x;
			mousey = arg0.getPoint().y;
			Mainwindow.mousepos.setText("X:"+Mainwindow.mainPanel.mousex+"Y:"+Mainwindow.mainPanel.mousey);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0){
			
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}	
	}
	public void paintComponent(Graphics G)
	{
		super.paintComponent(G);
		render(G);
	}
}
