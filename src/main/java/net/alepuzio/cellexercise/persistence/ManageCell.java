package net.alepuzio.cellexercise.persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManageCell {


	
		@Autowired
		private CellRepository cellRepository;

		public Iterable<net.alepuzio.cellexercise.persistence.entity.Cell> readAllCells() throws Exception {
			return  cellRepository.findAll();
		}
		
	
			

}