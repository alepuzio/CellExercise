package net.alepuzio.cellexercise.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.cellexercise.functional.CellEvent;
import net.alepuzio.cellexercise.functional.position.Point;
import net.alepuzio.cellexercise.persistence.entity.Cell;

@Component
public class CellService {

	@Autowired
	private ManageCell manageCell;
	
	public List<net.alepuzio.cellexercise.functional.cell.Cell> readAll() throws Exception{
		List<net.alepuzio.cellexercise.functional.cell.Cell> result = new ArrayList<net.alepuzio.cellexercise.functional.cell.Cell>();
		Iterator<Cell> iteratorCell = manageCell.readAllCells().iterator();		
		while(iteratorCell.hasNext()) {
			Cell tmp = iteratorCell.next();
			result.add(fromDbToFunctionalCell(tmp));
		}
		return result;
	}
	
	public List<CellEvent> readAllCellEvent() throws Exception{
		List<CellEvent> result = new ArrayList<CellEvent>();
		Iterator<net.alepuzio.cellexercise.persistence.CellEvent> iteratorCellEvent = manageCell.readAllCellEvent().iterator();
		while(iteratorCellEvent.hasNext()) {
			net.alepuzio.cellexercise.persistence.CellEvent tmp = iteratorCellEvent.next();
			result.add(new net.alepuzio.cellexercise.functional.CellEvent(
															fromDbToFunctionalCell(tmp.getCell())
															, tmp.getTimestampEvent().toLocalDateTime()
															, tmp.getTypology()
															)
									
					);
		}
		return result;
	}
	
	
	private net.alepuzio.cellexercise.functional.cell.Cell fromDbToFunctionalCell(Cell cellFromDb){
		net.alepuzio.cellexercise.functional.cell.Cell functionalCell = new net.alepuzio.cellexercise.functional.cell.Cell(
				cellFromDb.getName(),
				new Point(
						cellFromDb.getLongitude()
						, cellFromDb.getLatitude()
						)
				);
		return functionalCell;
	}
	
}
