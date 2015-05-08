package pj.generator;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class TrainingSetGenerator {
	
	public static final String twoBoxesFileName = "twoBoxes.png";
	public BufferedImage twoBoxesImage;
	public int[][] twoBoxesRGBSet;
	
	public TrainingSetGenerator() {
		initialize();
		generate();
	}
	
	public void initialize() {
		ImageAdapter.initializeAdapter();
		TextFileAdapter.initializeAdapter();
	}
	
	public void generate() {
		generateSetTwoBoxes(twoBoxesFileName);

//		System.out.println("\nresult1 in RGB\n");
//		System.out.println("Length: "+result1.length+", Length[0]: "+result1[0].length);
//		Color myColor;
//		for(int i=0;i<result1.length;i++) {
//			for(int j=0;j<result1[0].length;j++) {
//				myColor = new Color(result1[i][j]);
//				System.out.print("("+myColor.getRed()+","+myColor.getGreen()+","+myColor.getBlue()+") ");
//				
//			}
//			System.out.println();
//		}
	}
	
	public void generateSetTwoBoxes(String fileName) {
		twoBoxesImage = ImageAdapter.readImage("twoBoxes.png");
		twoBoxesRGBSet = ImageAdapter.getPixelsOf(twoBoxesImage);
	}
	
	public void generateTwoSpirals(String fileName) {
		
	}
	
	public void generateExOr(String fileName) {
		
	}
}
