package pj.specifiednetwork;

import java.util.Vector;

import pj.neuralnetwork.Network;

public class TwoBoxesNetwork {
	public Main main;
	public Network net;
	
	public TwoBoxesNetwork(Main main) {
		this.main = main;
	}
	
	public void trainTwoBoxes() {
		Main main = new Main();
		
		Vector<Integer> topology = new Vector<Integer>();
		topology.add(2);
		topology.add(3);
		topology.add(1);
		double bias = 1.0;
		
		net = new Network(topology, bias);
		for(int setNum=0;setNum<main.trainingSets.exOrSet.length;setNum++) {
			Vector<Double> inputVals = new Vector<Double>();
			inputVals.add((double)main.trainingSets.twoBoxesRGBSet[0][1]);
			inputVals.add((double)main.trainingSets.exOrSet[setNum][1]);
			net.feedForward(inputVals);
			
			System.out.println((setNum+1)+". Trainingsdurchlauf\nInput 1: "+inputVals.get(0)+" Input 2: "+inputVals.get(1));
			
			Vector<Double> targetVals = new Vector<Double>();
			targetVals.add((double)main.trainingSets.exOrSet[setNum][2]);
			net.backProp(targetVals);

			Vector<Double> resultVals = new Vector<Double>();
			net.getResults(resultVals);
			
			System.out.println("Result: "+String.format("%.2f", resultVals.get(0))+" target: "+targetVals.get(0)+"\n");
		}
	}
}
