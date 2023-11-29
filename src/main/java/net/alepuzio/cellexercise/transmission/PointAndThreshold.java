package net.alepuzio.cellexercise.transmission;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointAndThreshold {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	private String threshold;
	
	
	private RestPoint point;
	public PointAndThreshold(RestPoint point, String threshold) {
		this.point = point;
		this.threshold = threshold;
		logger.info("construcgor("+threshold+")");
	}
	public RestPoint getPoint() {
		return point;
	}
	public void setPoint(RestPoint point) {
		this.point = point;
	}
	@Override
	public int hashCode() {
		return Objects.hash(point, threshold);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PointAndThreshold)) {
			return false;
		}
		PointAndThreshold other = (PointAndThreshold) obj;
		return Objects.equals(point, other.point) && Objects.equals(threshold, other.threshold);
	}
	@Override
	public String toString() {
		return "PointAndThreshold [point=" + point + ", threshold=" + threshold + "]";
	}

	
	public String getThreshold() {
		return threshold;
	}


	
	public PointAndThreshold(){
		this(null);
	}
	

	public PointAndThreshold(String threshold ){
		this.threshold = threshold;
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(threshold);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PointAndThreshold)) {
			return false;
		}
		PointAndThreshold other = (PointAndThreshold) obj;
		return  Objects.equals(threshold, other.threshold);
	}
	@Override
	public String toString() {
		return "PointAndThreshold [threshold=" + threshold + "]";
	}
*/
	
	
}
