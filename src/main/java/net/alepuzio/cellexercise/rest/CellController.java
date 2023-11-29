package net.alepuzio.cellexercise.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.alepuzio.cellexercise.functional.CellEvent;
import net.alepuzio.cellexercise.functional.advanced.SetCellEvent;
import net.alepuzio.cellexercise.functional.advanced.SetCells;
import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.persistence.CellService;
import net.alepuzio.cellexercise.transmission.PointAndThreshold;

@Controller
public class CellController {
	
	@Autowired
	private CellService cellService;

		private Logger logger = LogManager.getLogger(this.getClass());

		
		@GetMapping("/orderedCellEvent")
		public ResponseEntity<List<String>> orderCellsByFrequencyDesc(){
			 ResponseEntity<List<String>> res = null;
			 try {
				List<CellEvent> list = this.cellService.readAllCellEvent();
				SetCellEvent setCellEvent = new SetCellEvent(list);
				res = ResponseEntity.ok(setCellEvent.orderCellsByFrequency());
			} catch (Exception e) {
				logger.fatal("orderCellsByFrequencyDesc():" + e.getMessage());
			}
			return res;
		}
			
		
		
		@PutMapping("/cellsStrongerThan")
		public ResponseEntity<List<MeasureForce>> cellsStrongerThan(
				@RequestBody PointAndThreshold pointAndThreshold){
			 ResponseEntity<List<MeasureForce>> res = null;
			 logger.info(">cellsStrongerThan:"+pointAndThreshold);
			 try {
				List<MeasureForce> list = this.cellService.readAll();
				 logger.info("list:"+list);
				SetCells setCell = new SetCells(list, pointAndThreshold.getPoint().getPoint());
				res = ResponseEntity.ok(setCell.filterStrongerCellsThan(Double.parseDouble(pointAndThreshold.getThreshold())));
			} catch (Exception e) {
				logger.fatal("cellsStrongerThan("+ pointAndThreshold.getPoint() + ", " + pointAndThreshold.getThreshold()+"):"+e.getMessage());
			}
			 logger.info("<cellsStrongerThan:"+res);

			return res;
		}
		
		
		@GetMapping("/")
		public ResponseEntity<List<CellEvent>> hello(){
			logger.info("hello");
			return ResponseEntity.ok(null);
		
			
		}
		@PutMapping("/testrest")
		public ResponseEntity<List<MeasureForce>> testrest(
				@RequestBody PointAndThreshold threshold){
			 ResponseEntity<List<MeasureForce>> res = null;
			 logger.info(">testrest:"+threshold);
			
			return res;
		}
		
}


