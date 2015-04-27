import java.util.Vector;

public class Network {

	Vector<Vector<Neuron>> m_layers = new Vector<Vector<Neuron>>(); // m_layers[layerNum][neuronNum]

	public Network(Vector<Integer> topology) {
		int numLayers = topology.size();
		for (int layerNum = 0; layerNum < numLayers; layerNum++) {
			// init new Layer
			m_layers.add(new Vector<Neuron>());
			System.out.println("Made a new Layer!");
			// each neuron has a number of outputs like the number of neurons on
			// next layer except the last neuron
			int numOutputs = layerNum == topology.size() - 1 ? 0 : topology
					.get(layerNum + 1);

			// init new Neurons of new Layer with bias
			for (int neuronNum = 0; neuronNum <= topology.get(layerNum); neuronNum++) {
				m_layers.lastElement().add(new Neuron(numOutputs));
				System.out.println("Made a new Neuron!");
			}
		}
	}

	public void feedForward(Vector<Double> inputVals) {

	}

	public void backProp(Vector<Double> targetVals) {

	}

	public void getResults(Vector<Double> resultVals) {

	}

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
