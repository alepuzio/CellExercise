package net.alepuzio.cellexercise.persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.cellexercise.functional.position.Longitude;
import net.alepuzio.cellexercise.functional.position.Point;
import net.alepuzio.cellexercise.persistence.entity.Cell;
import net.alepuzio.cellexercise.persistence.repository.CellEventRepository;

@Component
public class ManageCell {


		
		@Autowired
		private CellEventRepository cellEventRepository;

		@Autowired
		private CellRepository cellRepository;

		public Iterable<net.alepuzio.cellexercise.persistence.entity.Cell> readAllCells() throws Exception {
			return  cellRepository.findAll();
		}
		
		public Iterable<CellEvent> readAllCellEvent() throws Exception {
			return cellEventRepository.findAll();
		}
			

}