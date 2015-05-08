package pj.generator;

import pj.generator.*;
import pj.ui.NNVisualisation;

public class Main {
	public TrainingSetGenerator trainingSetGenerator;
	public NNVisualisation nNVisualisation;

	public Main() {
		trainingSetGenerator = new TrainingSetGenerator();
		nNVisualisation = new NNVisualisation(this);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
