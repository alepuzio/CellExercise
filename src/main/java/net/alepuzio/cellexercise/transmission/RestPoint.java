package net.alepuzio.cellexercise.transmission;

import java.util.Objects;

import net.alepuzio.cellexercise.functional.position.Point;

public class RestPoint {

	private String latitude;

	private String longitude;
	
	public RestPoint(String longitude, String latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public RestPoint() {
		this(null, null);
	}	
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	
	public Point getPoint() {
		return new Point(Double.parseDouble(longitude), Double.parseDouble(latitude));
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RestPoint)) {
			return false;
		}
		RestPoint other = (RestPoint) obj;
		return Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude);
	}

	@Override
	public String toString() {
		return "RestPoint [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
		
}
