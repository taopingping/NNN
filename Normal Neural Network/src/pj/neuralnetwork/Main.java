package pj.neuralnetwork;
import java.util.Vector;
import pj.generator.TrainingSets;
import pj.ui.NNVisualisation;

public class Main {
	public TrainingSets trainingSets;
	public NNVisualisation nNVisualisation;
	
	public Main() {
		trainingSets = new TrainingSets();
		nNVisualisation = new NNVisualisation(this);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		Vector<Integer> topology = new Vector<Integer>();
		topology.add(2);
		topology.add(1);
		Network net = new Network(topology);
		for(int setNum=0;setNum<main.trainingSets.exOrSet.length;setNum++) {
			Vector<Double> inputVals = new Vector<Double>();
			inputVals.add((double)main.trainingSets.exOrSet[setNum][0]);
			inputVals.add((double)main.trainingSets.exOrSet[setNum][1]);
			net.feedForward(inputVals);

			Vector<Double> targetVals = new Vector<Double>();
			targetVals.add((double)main.trainingSets.exOrSet[setNum][2]);
			net.backProp(targetVals);

			Vector<Double> resultVals = new Vector<Double>();
			net.getResults(resultVals);
			
			System.out.println((setNum+1)+". Trainingsdurchlauf\nInput 1: "+inputVals.get(0)+" Input 2: "+inputVals.get(1)+"\nResult: "+resultVals.get(0)+" target: "+targetVals.get(0)+"\n");
		}
	}
}
