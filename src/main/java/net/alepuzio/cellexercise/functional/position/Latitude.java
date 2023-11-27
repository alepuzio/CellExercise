package net.alepuzio.cellexercise.functional.position;

import java.util.Objects;

public class Latitude {
	
	private double value;
	
	private static final double MIN_LATITUDE = -90;
	private static final double MAX_LATITUDE = 90;
	private static final double DELTA = 0.000001d;

	
	public Latitude(double value) {
		super();
		if(Math.abs(value - MIN_LATITUDE)<=DELTA || Math.abs(value - MAX_LATITUDE)<=DELTA) {
			throw new IllegalArgumentException(
					String.format(
					"The latitude value [%f] is invalid, it has to be between %f and %f"
							, value
							, MIN_LATITUDE
							, MAX_LATITUDE )
					);
		}
		this.value = value;
	}

	public double getValue() {
		return value;
	}


	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Latitude)) {
			return false;
		}
		Latitude other = (Latitude) obj;
		return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	@Override
	public String toString() {
		return "Latitude [value=" + value + "]";
	}


}
