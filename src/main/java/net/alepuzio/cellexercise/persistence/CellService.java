package net.alepuzio.cellexercise.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.cellexercise.functional.CellEvent;
import net.alepuzio.cellexercise.functional.advanced.SetCells;
import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.functional.position.Point;
import net.alepuzio.cellexercise.persistence.entity.Cell;

@Component
public class CellService {

	@Autowired
	private ManageCell manageCell;
	
	public List<MeasureForce> readAll() throws Exception{
		List<MeasureForce> result = new ArrayList<MeasureForce>();
		Iterator<Cell> iteratorCell = manageCell.readAllCells().iterator();		
		while(iteratorCell.hasNext()) {
			Cell tmp = iteratorCell.next();
			result.add(fromDbToFunctionalCell(tmp));
		}
		return result;
	}
	
	public List<? extends net.alepuzio.cellexercise.functional.cell.MeasureForce> filterStrongerCellsThan(
			Point point
			, double thresold) throws Exception{
		List<  MeasureForce> result = new ArrayList<MeasureForce>();
		Iterator<Cell> iteratorCell = manageCell.readAllCells().iterator();		
		while(iteratorCell.hasNext()) {
			Cell tmp = iteratorCell.next();
			result.add(fromDbToFunctionalCell(tmp));
		}
		return  new SetCells(result, point).filterStrongerCellsThan(thresold);
	}

	public List<CellEvent> readAllCellEvent() throws Exception{
		List<CellEvent> result = new ArrayList<CellEvent>();
		return result;
	}
	
	
	private net.alepuzio.cellexercise.functional.cell.MeasureForce fromDbToFunctionalCell(Cell cellFromDb){
		
		MeasureForce functionalCell = new net.alepuzio.cellexercise.functional.cell.Cell(
				                         cellFromDb.getName(),
				                             new Point(
				                                              cellFromDb.getLongitude()
				                                               , cellFromDb.getLatitude()
				))
	         ;

		return functionalCell;
	}
	
}
