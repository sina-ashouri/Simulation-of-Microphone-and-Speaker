package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

import shapes.*;

public class Mainwindow extends JApplet
{
	// create Icons with image ...
	public static ImageIcon penIcon = new ImageIcon("pencil.png");
	public static ImageIcon imageIcon = new ImageIcon("image.png");
	public static ImageIcon phoneIcon = new ImageIcon("phone.png");
	public static ImageIcon speakerIcon = new ImageIcon("speaker.png");
	
	public static PaintPanel mainPanel;
	public static JFrame mainFrame;
	public static JButton fillcButton; 
	public static JButton bordercButton;
	public static JLabel mousepos; // show current position of mouse pointer 
	
	public static String selectshapet;
	public static Shape selectshape;
	public static Shape copyshape;
	public static Point pastePoint; // point for paste 
	
	public static JRadioButton deletrad;
	public static JRadioButton selectrad;
	
	public static void main(String[] args)
	{
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screensize.getWidth();
		double height = screensize.getHeight();
		
		width = 5*width/6;
		height = 5*height/6;
		
		mainFrame = new JFrame("AP PROJECT");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setBounds(0, 0, (int)(width), (int)(height));
		mainFrame.setLayout(null);
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setBounds(4, (int)height-90, (int)width-10, 60);
		subPanel1.setLayout(new GridLayout(1, 0, 3, 0));
		mainFrame.add(subPanel1);
		
		
		JSeparator subSeparator = new JSeparator();
		subSeparator.setBounds(0, (int)height-88, (int)width, 2);
		mainFrame.add(subSeparator);
		
		mainPanel = new PaintPanel();
		mainPanel.setBounds(5, 5, (int)width-15, (int)height-97);
		mainFrame.add(mainPanel);
		
		mousepos = new JLabel("mousepos");
		mainPanel.add(mousepos);
		
		// buttons
		
		deletrad = new JRadioButton("delete");
		subPanel1.add(deletrad);
		
		selectrad = new JRadioButton("select");
		subPanel1.add(selectrad);
		
		deletrad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectrad.setSelected(false);
			}
		});
		
		selectrad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deletrad.setSelected(false);
			}
		});
		
		JButton clearBtn = new JButton("C");
		subPanel1.add(clearBtn);
	
		clearBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				shapes.Shape.Allshapes.clear();
				Wall.AllWalls.clear();
				Speaker.AllSpeakers.clear();
				Microphone.AllMicrophones.clear();
				Mainwindow.mainPanel.repaint();
			}
		});
		
		JButton penBtn = new JButton("");
		penBtn.setIcon(penIcon);
		subPanel1.add(penBtn);
		
		penBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				SetPenWindow sw = new SetPenWindow();
				sw.setVisible(true);
				for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					Wall.AllWalls.get(i).setPainting(false);
				}
				selectrad.setSelected(false);
				deletrad.setSelected(false);
			}
		});
		
		JButton imageBtn = new JButton("");
		imageBtn.setIcon(imageIcon);
		subPanel1.add(imageBtn);
		
		imageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectrad.setSelected(false);
				deletrad.setSelected(false);
				for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					Wall.AllWalls.get(i).setPainting(false);
				}
				JFileChooser c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.FILES_ONLY);
				c.setFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub1
						return "(*.png)";
					}
					
					@Override
					public boolean accept(File f) {
						// TODO Auto-generated method stub
						if(f.isDirectory()){
							return true;
						} else {
							return f.getName().toLowerCase().endsWith(".png");
						}
						}
				});
				int rVal = c.showOpenDialog(null);
				if(rVal == JFileChooser.APPROVE_OPTION){
					Mainwindow.mainPanel.image.setImage(c.getSelectedFile().toString());
					Mainwindow.mainPanel.repaint();
				}
				
			}
		});
		
		JButton phoneBtn = new JButton("");
		phoneBtn.setIcon(phoneIcon);
		subPanel1.add(phoneBtn);
		
		phoneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectrad.setSelected(false);
				deletrad.setSelected(false);
				Microphone mic = new Microphone();
				mic.setCenter(new Point(200,200));
				Thread t = new Thread(new MicThread(mic));
				t.start();
				for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					Wall.AllWalls.get(i).setPainting(false);
				}
				mainPanel.repaint();
			}
		});
		
		JButton speakerBtn = new JButton("");
		speakerBtn.setIcon(speakerIcon);
		subPanel1.add(speakerBtn);
		
		speakerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				selectrad.setSelected(false);
				deletrad.setSelected(false);
				AddSpeaker spw = new AddSpeaker();
				spw.setVisible(true);
				for(int i = 0 ; i < Wall.AllWalls.size() ; i++){
					Wall.AllWalls.get(i).setPainting(false);
				}
			}
		});
	
		mainFrame.setVisible(true);
	}
}
