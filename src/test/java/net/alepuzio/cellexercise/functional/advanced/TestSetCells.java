package net.alepuzio.cellexercise.functional.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

class TestSetCells {

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final Power POWER_FROM_DOCUMENTATION = new Power(5);
	private static final Radius RADIUS_FROM_DOCUMENTATION = new Radius(10d);

	@Test
	void test_filterStrongerCellsThan() {
	
		final Longitude longitudeZero = new Longitude(0);
		final Latitude latitudeZero = new Latitude(0);
		MeasureForce origin = new WithPower(new Cell("Origin" 
				, new Point(longitudeZero, latitudeZero))
				, POWER_FROM_DOCUMENTATION
				);

		MeasureForce maxLatitude = new WithPower(new Cell("MaxLatitude" 
				,new Point(
				longitudeZero, new Latitude(1)))
				, POWER_FROM_DOCUMENTATION);
		MeasureForce minLatitude = new WithPower(new Cell("MinLatitude" 
				,new Point(
				longitudeZero, new Latitude(0.5)))
				, POWER_FROM_DOCUMENTATION
				) ;
		MeasureForce minLongitude = new WithRadius(new Cell("MinLongitude" 
				,new Point(
				new Longitude(-70), latitudeZero))
				, RADIUS_FROM_DOCUMENTATION
				) ;
		List<MeasureForce> list = Arrays.asList(
				//origin
				//, 
				maxLatitude
				, minLatitude
				, minLongitude	);
			
		
		
		Point aGeneralPoint = new Point(new Longitude(0), new Latitude(0));
		double forceThresold = 2.596148429267414E-76d;
		SetCells cells = new SetCells(list, aGeneralPoint);
		List<MeasureForce> res = cells.filterStrongerCellsThan(forceThresold);
		logger.info("number of cells stronger than {}: {}", forceThresold, res.size());
		final int expectedNumberCellStrongerThanThreshold = 1;
		assertEquals(expectedNumberCellStrongerThanThreshold, res.size());
	}

	@Test
	void test_max_min() {
		
		MeasureForce maxLatitude = new WithPower(new Cell("MaxLatitude" 
				,new Point(
				new Longitude(0), new Latitude(1)))
				, POWER_FROM_DOCUMENTATION);
		MeasureForce minLatitude = new WithPower(new Cell("MinLatitude" 
				,new Point(
				new Longitude(0), new Latitude(0.5)))
				, POWER_FROM_DOCUMENTATION
				) ;
		MeasureForce minLongitude = new WithRadius(new Cell("MinLongitude" 
				,new Point(
				new Longitude(-70), new Latitude(0)))
				, RADIUS_FROM_DOCUMENTATION
				) ;
		List<MeasureForce> list = Arrays.asList(
				maxLatitude
				, minLatitude
				, minLongitude	
				);
			
		
		
		Point aGeneralPoint = new Point(new Longitude(0), new Latitude(0));
		SetCells cells = new SetCells(list, aGeneralPoint);
		MeasureForce max = cells.max();
		logger.info("max  {}", max.calculate(aGeneralPoint));
		assertNotNull(max);
		MeasureForce min = cells.min();
		logger.info("min  {}", min.calculate(aGeneralPoint));
		assertNotNull(min);;
		
	}

}
