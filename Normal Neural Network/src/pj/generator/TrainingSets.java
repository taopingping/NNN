package pj.generator;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class TrainingSets {
	
	public static final String twoBoxesFileName = "twoBoxes.png";
	public BufferedImage twoBoxesImage;
	public int[][] twoBoxesRGBSet;
	
	public static final String exOrFileName = "exOr.txt";
	public String exOrSetString;
	public int[][] exOrSet;
	
	public TrainingSets() {
		initialize();
		generate();
	}
	
	public void initialize() {
		ImageAdapter.initializeAdapter();
		TextFileAdapter.initializeAdapter();
	}
	
	public void generate() {
		generateSetTwoBoxes();
		generateSetExOr();
		
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
	
	public void generateSetTwoBoxes() {
		twoBoxesImage = ImageAdapter.readImage(twoBoxesFileName);
		twoBoxesRGBSet = ImageAdapter.getPixelsOf(twoBoxesImage);
//		twoBoxesTrainingSet = new int[twoBoxesRGBSet.length][twoBoxesRGBSet[0].length];
//		for(int row=0;row<twoBoxesRGBSet.length;row++) {
//			for(int col=0;col<twoBoxesRGBSet[0].length;col++) {
//				twoBoxesTrainingSet[row][col] = twoBoxesRGBSet[row][col] == -1? 0 : 1;
//				
//			}
//		}
	}
	
	public void generateSetTwoSpirals() {
		
	}
	
	public void generateSetExOr() {
		String set = "";
		int input1, input2;
		int targetOutput;
		int numSets = 2000;
		
		for(int setNum=0;setNum<numSets;setNum++) {
			input1 = generateRandomValue(0,1);
			input2 = generateRandomValue(0,1);
			targetOutput = (input1==1 && input2==0)||(input1==0 && input2==1)? 1: 0;
			set += input1+" "+input2+" "+targetOutput+" ";
			set += System.lineSeparator();
		}
		
		TextFileAdapter.writeTextFile(exOrFileName, set);
		String exOrSetString = TextFileAdapter.readTextFile(exOrFileName);
		exOrSet = TextFileAdapter.convertToIntArray(exOrSetString,numSets,3);
	}
	
	public int generateRandomValue(int von, int bis) {
		return (int)(Math.random()*(bis-von+1)+von);
	}
}
