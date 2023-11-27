package net.alepuzio.cellexercise.functional.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.*;
import org.junit.jupiter.api.Test;

import net.alepuzio.cellexercise.functional.position.Latitude;

class TestLatitude {

	private  Logger logger = LogManager.getLogger(this.getClass());

	@Test
	void whenNormalValue_thenSuccessfulConstruction() {
		long expectedLatitude = 0L;
		Latitude longitude = new Latitude(expectedLatitude);
		assertNotNull(longitude);
		assertEquals(expectedLatitude, longitude.getValue());
	}
	@Test
	void whenLowValue_thenSuccessfulConstruction() {
		long expectedLatitude = -95L;
		try {
			Latitude longitude = new Latitude(expectedLatitude);
			assertNotNull(longitude);
			assertEquals(expectedLatitude, longitude.getValue());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			assertTrue(true);
		}
	}
	
	@Test
	void whenHighValue_thenFailedConstruction() {
		long expectedLatitude = 101L;
		try{
			Latitude longitude = new Latitude(expectedLatitude);			
			assertNotNull(longitude);
			assertEquals(expectedLatitude, longitude.getValue());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			assertFalse(false);

		}

	}
	
}
