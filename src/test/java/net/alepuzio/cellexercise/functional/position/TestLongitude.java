package net.alepuzio.cellexercise.functional.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.*;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.position.Longitude;

class TestLongitude {

	private  Logger logger = LogManager.getLogger(this.getClass());

	@Test
	void whenNormalValue_thenSuccessfulConstruction() {
		long expectedLongitude = 0L;
		Longitude longitude = new Longitude(expectedLongitude);
		assertNotNull(longitude);
		assertEquals(expectedLongitude, longitude.getValue());
	}
	@Test
	void whenLowValue_thenSuccessfulConstruction() {
		long expectedLongitude = -200L;
		try {
			Longitude longitude = new Longitude(expectedLongitude);
			assertNotNull(longitude);
			assertEquals(expectedLongitude, longitude.getValue());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			assertTrue(true);
		}
	}
	
	@Test
	void whenHighValue_thenFailedConstruction() {
		long expectedLongitude = 181L;
		try{
			Longitude longitude = new Longitude(expectedLongitude);			
			assertNotNull(longitude);
			assertEquals(expectedLongitude, longitude.getValue());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			assertFalse(false);

		}

	}
	
}
