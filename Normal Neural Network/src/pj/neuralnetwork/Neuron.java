package pj.neuralnetwork;
import java.util.Vector;

public class Neuron {

	private double outputVal;
	private Vector<Connection> outputWeights = new Vector<Connection>();
	private int myIndex;
	private double gradient;
	private static double eta = 0.15; // [0.0 .. 1.] overall net training rate
	private static double alpha = 0.5; // [0.0 .. n] multiplier of last
										// deltaWeight change (momentum)

	public Neuron(int numOutputs, int myIndex) {
		this.myIndex = myIndex;
		for (int i = 0; i < numOutputs; i++) {
			outputWeights.add(new Connection());
			outputWeights.lastElement().setWeight(randomWeight());
		}
	}

	static private double randomWeight() {
		return Math.random() * Double.MAX_VALUE;
	}

	public void setOutputVal(Double outputVal) {
		this.outputVal = outputVal;
	}

	public double getOutputVal() {
		return outputVal;
	}

	public void feedForward(Vector<Neuron> prevLayer) {
		// TODO Auto-generated method stub
		double sum = 0.0;

		// Sum the previous layer's outputs
		// Include the bias node from the previous layer

		for (int neuronNum = 0; neuronNum < prevLayer.size(); neuronNum++) {
			sum += prevLayer.get(neuronNum).getOutputVal()
					* prevLayer.get(neuronNum).outputWeights.get(myIndex)
							.getWeight();
		}
		outputVal = transferFunction(sum);
	}

	static private double transferFunction(double x) {
		// tanh - output range[-1, 0..1,0]
		return Math.tanh(x);
	}

	static private double transferFunctionDerivative(double x) {
		// tanh derivative
		return 1.0 - x * x;
	}

	public Vector<Connection> getOutputWeights() {
		return outputWeights;
	}

	public void calcOutputGradients(Double targetVal) {
		double delta = targetVal - outputVal;
		gradient = delta * transferFunctionDerivative(outputVal);
	}

	public void calcHiddenGradients(Vector<Neuron> nextLayer) {
		double dow = sumDOW(nextLayer);
		gradient = dow * transferFunctionDerivative(outputVal);
	}

	private double sumDOW(Vector<Neuron> nextLayer) {
		double sum = 0.0;

		// Sum our contributions of the errors at the nodes we need

		for (int neuronNum = 0; neuronNum < nextLayer.size() - 1; neuronNum++) {
			sum += outputWeights.get(neuronNum).getWeight()
					* nextLayer.get(neuronNum).getGradient();
		}
		return sum;
	}

	public double getGradient() {
		return gradient;
	}

	public void updateInputWeights(Vector<Neuron> prevLayer) {
		// The weights to be update are in the Connection container
		// In the neurons in the preceding layer

		for (int neuronNum = 0; neuronNum < prevLayer.size(); neuronNum++) {
			Neuron neuron = prevLayer.get(neuronNum);
			double oldDeltaWeight = neuron.outputWeights.get(myIndex)
					.getDeltaWeight();

			double newDeltaWeight =
			// Individual input, magnified by the gradient and train rate:
			eta * neuron.getOutputVal() * gradient
			// Also add momentum = a fraction of the previous delta weight
					+ alpha * oldDeltaWeight;
			neuron.getOutputWeights().get(myIndex)
					.setDeltaWeight(newDeltaWeight);
			neuron.getOutputWeights().get(myIndex).addWeight(newDeltaWeight);
		}

	}
}
