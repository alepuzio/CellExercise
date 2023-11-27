package net.alepuzio.cellexercise.functional.cell.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.CellEvent;
import net.alepuzio.cellexercise.functional.EnumTypology;
import net.alepuzio.cellexercise.functional.advanced.SetCellEvent;
import net.alepuzio.cellexercise.functional.cell.Cell;
import net.alepuzio.cellexercise.functional.position.Latitude;
import net.alepuzio.cellexercise.functional.position.Longitude;
import net.alepuzio.cellexercise.functional.position.Point;

class TestSetCellEvent {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Test
	void testOrderCellsByFrequency() {
		CellEvent origin = new CellEvent(new Cell("Origin" 
				,new Point(
				new Longitude(0), new Latitude(0)))
				, LocalDateTime.now()
				, EnumTypology.CONNECTED 
				);
		CellEvent originDisconnetted = new CellEvent(new Cell("Origin" 
				,new Point(
				new Longitude(0), new Latitude(0)))
				, LocalDateTime.now()
				, EnumTypology.DISCONNECTED 
				);
		CellEvent minLatitude = new CellEvent(new Cell("MinLatitude" 
				,new Point(
				new Longitude(0), new Latitude(-70)))
				, LocalDateTime.now()
				, EnumTypology.DISCONNECTED 
				);
		CellEvent minLongitude = new CellEvent(new Cell("MinLongitude" 
				,new Point(
				new Longitude(-70), new Latitude(0)))
				, LocalDateTime.now()
				, EnumTypology.CONNECTED 
				);
		List<CellEvent> list = Arrays.asList(origin
				, minLatitude
				, originDisconnetted
				, minLongitude	);

		SetCellEvent setCellEvent = new SetCellEvent(list);
		List<String> res = setCellEvent.orderCellsByFrequency();
		assertEquals(list.size(), res.size());
		
		assertEquals(origin.getName(), res.get(0));
		assertEquals(originDisconnetted.getName(), res.get(1));
		assertEquals(minLongitude.getName(), res.get(2));
		assertEquals(minLatitude.getName(), res.get(3));
	}

}
