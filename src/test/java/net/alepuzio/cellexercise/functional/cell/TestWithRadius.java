package net.alepuzio.cellexercise.functional.cell;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.cell.Cell;
import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.functional.cell.WithPower;
import net.alepuzio.cellexercise.functional.cell.WithRadius;
import net.alepuzio.cellexercise.functional.dynamic.Power;
import net.alepuzio.cellexercise.functional.dynamic.Radius;
import net.alepuzio.cellexercise.functional.position.Latitude;
import net.alepuzio.cellexercise.functional.position.Longitude;
import net.alepuzio.cellexercise.functional.position.Point;

class TestWithRadius {


	@Test
	void whenSamePoint_thenCalculate100() {
		Longitude zeroLongitude = new Longitude(0);
		Latitude zeroLatitude = new Latitude(0);
		
		MeasureForce measureForce = new WithRadius(new Cell("cellNameWithRadius"
				, new Point(zeroLongitude , zeroLatitude ))
				, new Radius(10d));
		double result = measureForce.calculate(new Point(zeroLongitude , zeroLatitude ));
		double expected = 100.0d;
		assertEquals(expected, result);
	}

	
	@Test
	void whenRadiusEqualToTheDistance_thenCalculateZero() {
		MeasureForce measureForce = new WithRadius(new Cell("cellNameWithRadius"
				, new Point(new Longitude(0), new Latitude(0) ))
				, new Radius(10d));
		double result = measureForce.calculate(new Point(new Longitude(10) , new Latitude(10) ));
		double expected = 0d;
		assertEquals(expected, result);
	}
	
	@Test
	void whenRadiusMinorThenTheDistance_thenCalculateZero() {
		MeasureForce measureForce = new WithRadius(new Cell("cellNameWithRadius"
				, new Point(new Longitude(0), new Latitude(0) ) )
				, new Radius(10d));
		double result = measureForce.calculate(new Point(new Longitude(2) , new Latitude(2) ));
		double expected = 0d;
		assertEquals(expected, result);
	}

	@Test
	void whenRadiusByAnalysis_thenCalculateZero() {
		MeasureForce measureForce = new WithRadius(new Cell("cell2"
				, new Point(new Longitude(9.0961433), new Latitude(45.4732446) ) )
				, new Radius(10d));
		double result = measureForce.calculate(new Point(new Longitude(2) , new Latitude(2) ));
		double expected = 0d;
		assertEquals(expected, result);
	}
	
}
