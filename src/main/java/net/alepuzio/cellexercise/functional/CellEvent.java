package net.alepuzio.cellexercise.functional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import net.alepuzio.cellexercise.functional.cell.Cell;

public class CellEvent{

	private Cell cell;
	
	private LocalDateTime timestamp;
	
	private EnumTypology typology;

	public CellEvent(Cell cell, LocalDateTime timestamp, EnumTypology typology) {
		super();
		this.cell = cell;
		this.timestamp = timestamp;
		this.typology = typology;
	}
	public CellEvent(Cell cell, Timestamp timestamp, String typology) {
		this(cell, timestamp.toLocalDateTime(), EnumTypology.valueOf(typology));
	}
	public String getName() {
		return this.cell.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cell, timestamp, typology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CellEvent)) {
			return false;
		}
		CellEvent other = (CellEvent) obj;
		return Objects.equals(cell, other.cell) && Objects.equals(timestamp, other.timestamp)
				&& typology == other.typology;
	}

	@Override
	public String toString() {
		return "CellEvent [cell=" + cell + ", timestamp=" + timestamp + ", typology=" + typology + "]";
	}
	
	
}
