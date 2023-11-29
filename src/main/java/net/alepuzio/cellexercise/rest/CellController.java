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
import org.springframework.web.bind.annotation.RequestParam;

import net.alepuzio.cellexercise.functional.CellEvent;
import net.alepuzio.cellexercise.functional.advanced.SetCellEvent;
import net.alepuzio.cellexercise.functional.advanced.SetCells;
import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.functional.position.Point;
import net.alepuzio.cellexercise.persistence.CellService;

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
				@RequestParam Double thresold
				, @RequestBody Point point ){
			 ResponseEntity<List<MeasureForce>> res = null;
			 try {
				List<MeasureForce> list = this.cellService.readAll();
				SetCells setCell = new SetCells(list, point);
				res = ResponseEntity.ok(setCell.filterStrongerCellsThan(thresold));
			} catch (Exception e) {
				logger.fatal("cellsStrongerThan("+ thresold + ", " + point+"):"+e.getMessage());
			}
			return res;
		}
		@GetMapping("/")
		public ResponseEntity<List<CellEvent>> hello(){
			logger.info("hello");
			return ResponseEntity.ok(null);
		
			
		}
		
		
}


