package pj.specifiednetwork;
import java.util.Vector;

import pj.generator.TrainingSets;
import pj.neuralnetwork.Network;
import pj.ui.NNVisualisation;

public class Main {
	public TrainingSets trainingSets;
	public NNVisualisation nNVisualisation;
	public ExOrNetwork exOrNetwork;
	public TwoBoxesNetwork twoBoxesNetwork;
	
	public Main() {
		trainingSets = new TrainingSets();
		nNVisualisation = new NNVisualisation(this);
		exOrNetwork = new ExOrNetwork(this);
		twoBoxesNetwork = new TwoBoxesNetwork(this);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.exOrNetwork.trainExOr();
	}
	

}
