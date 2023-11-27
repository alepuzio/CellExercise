package net.alepuzio.cellexercise.functional.cell;

import net.alepuzio.cellexercise.functional.position.Point;

public class Cell implements MeasureForce {

	private String name;
	private Point center;
	
	public Cell(String name, Point point) {
		super();
		this.name = name;
		this.center = point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cell)) {
			return false;
		}
		Cell other = (Cell) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (center == null) {
			if (other.center != null) {
				return false;
			}
		} else if (!center.equals(other.center)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cell [name=" + name + ", center=" + center + "]";
	}


	public double calculate(Point point) {
		return this.getCenter().calculateDistance(point);
	}


	public Point getCenter() {
		return this.center;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
