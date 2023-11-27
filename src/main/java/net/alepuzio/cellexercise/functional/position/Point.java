package net.alepuzio.cellexercise.functional.position;

public class Point {

	private Longitude longitude;
	private Latitude latitude;
	private final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

	public Point(Longitude longitude, Latitude latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Point(double longitude, double latitude) {
		this(new Longitude(longitude), new Latitude(latitude));
	}

	public double calculateDistance(Point otherPoint) {
		double latDistance = Math.toRadians(this.getLatitude().getValue() - otherPoint.getLatitude().getValue());
		double lngDistance = Math.toRadians(this.getLongitude().getValue() - otherPoint.getLongitude().getValue());

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(this.getLatitude().getValue()))
						* Math.cos(Math.toRadians(otherPoint.getLatitude().getValue())) * Math.sin(lngDistance / 2)
						* Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Point [longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj;
		if (latitude == null) {
			if (other.latitude != null) {
				return false;
			}
		} else if (!latitude.equals(other.latitude)) {
			return false;
		}
		if (longitude == null) {
			if (other.longitude != null) {
				return false;
			}
		} else if (!longitude.equals(other.longitude)) {
			return false;
		}
		return true;
	}

	public Longitude getLongitude() {
		return longitude;
	}

	public Latitude getLatitude() {
		return latitude;
	}

}
