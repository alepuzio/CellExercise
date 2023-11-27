package net.alepuzio.cellexercise.functional.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.alepuzio.cellexercise.functional.CellEvent;

public class SetCellEvent {
	
	private List<CellEvent> list;
	private static Integer FIRST_OCCURRENCE = new Integer(1);
		
	public SetCellEvent(List<CellEvent> list) {
		super();
		this.list = list;
	}


	public List<String> orderCellsByFrequency(){
		Iterator<CellEvent> iteraCellEvent = this.list.iterator();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		while(iteraCellEvent.hasNext()) {
			CellEvent tmp = iteraCellEvent.next();
			if(map.containsKey(tmp)) {
				map.put(tmp.getName(), new Integer(map.get(tmp.getName())+1));				
			}else {
				map.put(tmp.getName(), FIRST_OCCURRENCE);
			}
		}
		List<String> sortedKeys = new ArrayList<String>(map.keySet());
		Collections.sort(sortedKeys);
		Collections.reverse(sortedKeys);
		return sortedKeys;
	}
}
