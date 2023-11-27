package net.alepuzio.cellexercise.functional.position;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.position.Latitude;
import net.alepuzio.cellexercise.functional.position.Longitude;
import net.alepuzio.cellexercise.functional.position.Point;

public class TestPoint {

	@Test
	void when_samepoint_then_CalculateDistanceZero() {
		Longitude longitude = new Longitude(0);
		Latitude latitude = new Latitude(0) ;
		Point center = new Point(longitude , latitude );
		Point anotherPointer = new Point(longitude , latitude );
		double result = center.calculateDistance(anotherPointer);
		assertEquals(0, result);
	}

	@Test
	void when_extremeLatitude_samelongitude_then_CalculateDistanceZero() {
		Longitude longitude = new Longitude(0);
		Latitude minlatitude = new Latitude(0) ;
		Latitude maxlatitude = new Latitude(89d) ;
		Point center = new Point(longitude , minlatitude );
		Point anotherPointer = new Point(longitude , maxlatitude );
		double result = center.calculateDistance(anotherPointer);
		assertEquals(9896.0d, result);
	}

	@Test
	void when_sameLatitude_extremeLongitude_then_CalculateDistanceZero() {
		Longitude minLongitude = new Longitude(0);
		Longitude maxLongitude = new Longitude(179.5d);
		Latitude latitude = new Latitude(0) ;
		Point center = new Point(minLongitude , latitude );
		Point anotherPointer = new Point(maxLongitude , latitude );
		double result = center.calculateDistance(anotherPointer);
		assertEquals(19959.0d, result);
	}
}
