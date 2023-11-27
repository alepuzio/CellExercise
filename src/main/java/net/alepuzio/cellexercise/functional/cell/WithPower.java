package net.alepuzio.cellexercise.functional.cell;


import java.util.Objects;

import net.alepuzio.cellexercise.functional.dynamic.Power;
import net.alepuzio.cellexercise.functional.position.Point;

public class WithPower implements MeasureForce {

	private MeasureForce origin;
	private Power power;
	
	public WithPower(MeasureForce measure, Power newPower) {
		super();
		this.origin = measure;
		this.power = newPower;
	}

	public double calculate(Point point) {
		double distance = this.origin.calculate(point);
		double result = Math.pow(this.power.getValue(), distance);
		return Math.pow(result, -1)*100;
	}

	@Override
	public int hashCode() {
		return Objects.hash(origin, power);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WithPower)) {
			return false;
		}
		WithPower other = (WithPower) obj;
		return Objects.equals(origin, other.origin) && Objects.equals(power, other.power);
	}

	@Override
	public String toString() {
		return "WithPower [origin=" + origin + ", power=" + power + "]";
	}


}
