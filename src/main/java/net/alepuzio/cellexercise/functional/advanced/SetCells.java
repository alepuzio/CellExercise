package net.alepuzio.cellexercise.functional.advanced;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import net.alepuzio.cellexercise.functional.cell.MeasureForce;
import net.alepuzio.cellexercise.functional.position.Point;

public class SetCells {

	
	private List<MeasureForce> setCells;
	
	private Point aPoint;

	public SetCells(List<MeasureForce> setCells, Point aPoint) {
		this.setCells = setCells;
		this.aPoint = aPoint;
	}
	
	
	public List<MeasureForce> filterStrongerCellsThan(double thresoldForce){
			final Point apoingt = this.aPoint;
			List<MeasureForce> res = this.setCells
			.stream()
			.filter(c -> c.calculate(apoingt)  > thresoldForce)
			.collect(Collectors.toList())
			;
			return res;
		
			
	}
	
	
	public MeasureForce max(){
		final Point point = this.aPoint;
		 MeasureForce max = this.setCells
		.stream()
		.max(new Comparator<MeasureForce>() {

			@Override
			public int compare(MeasureForce o1, MeasureForce o2) {
				double res1 = o1.calculate(point);
				double res2 = o2.calculate(point);
				int res = 0;
				if( res1 > res2) {res = 1;}
				else if( res1 < res2) {res = -1;}
				return res ;
			}
			
		}).orElseThrow(RuntimeException::new);
		return max;
	}
	public MeasureForce min(){
		final Point point = this.aPoint;
		 MeasureForce min = this.setCells
		.stream()
		.min(new Comparator<MeasureForce>() {

			@Override
			public int compare(MeasureForce o1, MeasureForce o2) {
				double res1 = o1.calculate(point);
				double res2 = o2.calculate(point);
				int res = 0;
				if( res1 > res2) {res = 1;}
				else if( res1 < res2) {res = -1;}
				return res ;
			}
			
		}).orElseThrow(RuntimeException::new);
		return min;
	}
	
}
