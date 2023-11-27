package net.alepuzio.cellexercise.functional.dynamic;

public class Radius {

	private double value;

	public Radius(double value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Radius [value=" + value + "]KM";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Radius)) {
			return false;
		}
		Radius other = (Radius) obj;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
			return false;
		}
		return true;
	}

	public double getValue() {
		return value;
	}
	
	
}
