package net.alepuzio.cellexercise.functional.cell;

import java.util.Objects;

import net.alepuzio.cellexercise.functional.dynamic.Radius;
import net.alepuzio.cellexercise.functional.position.Point;

public class WithRadius implements MeasureForce {

	
	private MeasureForce origin;
	private Radius radius;
	
	public WithRadius(MeasureForce measure, Radius radius) {
		super();
		this.origin = measure;
		this.radius = radius;
	}



	public double calculate(Point point) {
		double result = 0.d;
		double distance  = this.origin.calculate(point);
		if(distance >= this.radius.getValue()) {
			result = 0;
		}else {
			result = (1 - (distance/this.radius.getValue())) *100.0d;
		}
		return result;
	}



	@Override
	public int hashCode() {
		return Objects.hash(origin, radius);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WithRadius)) {
			return false;
		}
		WithRadius other = (WithRadius) obj;
		return Objects.equals(origin, other.origin) && Objects.equals(radius, other.radius);
	}



	@Override
	public String toString() {
		return "WithRadius [origin=" + origin + ", radius=" + radius + "]";
	}


	
	
}
