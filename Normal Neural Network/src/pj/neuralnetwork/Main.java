package pj.neuralnetwork;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<Integer> topology = new Vector<Integer>();
		topology.add(3);
		topology.add(2);
		topology.add(1);
		Network net = new Network(topology);

		Vector<Double> inputVals = new Vector<Double>();
		net.feedForward(inputVals);

		Vector<Double> targetVals = new Vector<Double>();
		net.backProp(targetVals);

		Vector<Double> resultVals = new Vector<Double>();
		net.getResults(resultVals);
	}

}
