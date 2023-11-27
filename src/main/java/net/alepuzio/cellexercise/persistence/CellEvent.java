package net.alepuzio.cellexercise.persistence;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import net.alepuzio.cellexercise.functional.EnumTypology;
import net.alepuzio.cellexercise.persistence.entity.Cell;

@Entity
@Table(name = "CELL_EVENT")
public class CellEvent {
	
      @Id
	  @Column(name = "ID" )
	  private Cell cell;
	  
	  @Column(name = "TYPOLOGY" )
	  private EnumTypology typology;
	  
	  @Column(name = "TIMESTAMP_CREATION")
	  private Timestamp timestampCreation;

	  @Column(name = "TIMESTAMP_EVENT" ) 
	  private Timestamp timestampEvent;

	public CellEvent(Cell cell, EnumTypology typology, Timestamp timestampCreation, Timestamp timestampEvent) {
		super();
		this.cell = cell;
		this.typology = typology;
		this.timestampCreation = timestampCreation;
		this.timestampEvent = timestampEvent;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public EnumTypology getTypology() {
		return typology;
	}

	public void setTypology(EnumTypology typology) {
		this.typology = typology;
	}

	public Timestamp getTimestampCreation() {
		return timestampCreation;
	}

	public void setTimestampCreation(Timestamp timestampCreation) {
		this.timestampCreation = timestampCreation;
	}

	public Timestamp getTimestampEvent() {
		return timestampEvent;
	}

	public void setTimestampEvent(Timestamp timestampEvent) {
		this.timestampEvent = timestampEvent;
	}
	  
	  

}
