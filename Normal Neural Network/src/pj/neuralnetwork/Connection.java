package pj.neuralnetwork;
public class Connection {
	private double weight;
	private double deltaWeight;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDeltaWeight() {
		return deltaWeight;
	}

	public void setDeltaWeight(double deltaWeight) {
		this.deltaWeight = deltaWeight;
	}

	public void addWeight(double newDeltaWeight) {
		weight += newDeltaWeight;
	}
}
