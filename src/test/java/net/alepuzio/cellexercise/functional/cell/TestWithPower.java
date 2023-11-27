package net.alepuzio.cellexercise.functional.cell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.cell.Cell;
import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.functional.cell.WithPower;
import net.alepuzio.cellexercise.functional.dynamic.Power;
import net.alepuzio.cellexercise.functional.position.Latitude;
import net.alepuzio.cellexercise.functional.position.Longitude;
import net.alepuzio.cellexercise.functional.position.Point;

class TestWithPower {
	
	private static final Power POWER_FROM_DOCUMENTATION = new Power (1.25);

	@Test
	void whenSamePoint_thenCalculate100() {	
		MeasureForce measureForce = new WithPower(new Cell("cellNameWithPower"
				, new Point(new Longitude(0) ,  new Latitude(0) ))
				, POWER_FROM_DOCUMENTATION);
		double result = measureForce.calculate(
				new Point(new Longitude(0) ,  new Latitude(0) )
				);
		double expected = 100d;
		assertEquals(expected, result);
	}

	@Test
	void whenDifferentPoint_thenCalculate100() {
		MeasureForce measureForce = new WithPower(new Cell("cellNameWithPower"
				, new Point(new Longitude(0), new Latitude(0) ))
				, POWER_FROM_DOCUMENTATION);
		double result = measureForce.calculate(
				new Point(new Longitude(10) , new Latitude(10) )
				);
		double expected = 8.875433827102886E-151;
		assertEquals(expected, result);
	}
	
	@Test
	void whenOneDegreeLatitude_thenCalculate100() {
		MeasureForce measureForce = new WithPower(new Cell("cellNameWithPower"
				, new Point(new Longitude(0), new Latitude(0) ))
				, POWER_FROM_DOCUMENTATION);
		double result = measureForce.calculate(
				new Point(new Longitude(0) , new Latitude(1) ));
		double expected = 1.7498005798264097E-9;
		assertEquals(expected, result);
	}

	@Test
	void whenCellByAnalisys_thenCalculate() {
		MeasureForce measureForce = new WithPower(new Cell("Cella1" 
						,new Point(
						new Longitude(9.0756298), new Latitude(45.4616873)))
						, POWER_FROM_DOCUMENTATION
						);
		double result = measureForce.calculate(
				new Point(new Longitude(10), new Latitude(10)));
		double expected = 0.0;
		assertEquals(expected, result);
	}

}
