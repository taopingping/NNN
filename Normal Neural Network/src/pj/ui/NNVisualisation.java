package pj.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pj.generator.Main;

public class NNVisualisation extends JPanel {
	public Main main;
	public BufferedImage image;
	public int[][] imageRGB;
	public int frame_width;
	public int frame_height;
	public JFrame frame;
	
	public NNVisualisation(Main main) {
		this.main = main;
		this.image = main.trainingSetGenerator.twoBoxesImage;
		this.imageRGB = main.trainingSetGenerator.twoBoxesRGBSet;
		this.frame_width = this.image.getWidth();
		this.frame_height = this.image.getHeight();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Neural Network");
		frame.setLocationRelativeTo(null);
		frame.setLocation(frame.getX()-frame_width/2,frame.getY()-frame_height/2);
		frame.add(this);
		frame.setVisible(true);
		this.frame_height += frame.getInsets().top+frame.getInsets().bottom;
		frame.setSize(frame_width,frame_height);
				
		this.setBackground(Color.black);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image,0,0,this);
	}
}
