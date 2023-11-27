package net.alepuzio.cellexercise.functional.position;

import java.util.Objects;

public class Longitude {
	

	private double value;
	
	private static final double MIN_LONGITUDE = -180d;
	private static final double MAX_LONGITUDE = 180d;
	private static final double DELTA = 0.000001d;
	public Longitude(double value) {
		super();
		if(Math.abs(value - MIN_LONGITUDE)<=DELTA || Math.abs(value - MAX_LONGITUDE)<=DELTA) {
			throw new IllegalArgumentException(
					String.format(
					"The longitude value [%f] is invalid, it has to be between %f and %f"
							, value
							, MIN_LONGITUDE
							, MAX_LONGITUDE)
					);
		}
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Longitude [value=" + value + "]";
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
		if (!(obj instanceof Longitude)) {
			return false;
		}
		Longitude other = (Longitude) obj;
		return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
	
	

}
