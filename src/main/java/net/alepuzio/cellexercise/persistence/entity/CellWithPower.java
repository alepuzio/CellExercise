package net.alepuzio.cellexercise.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CELL_WITH_POWER")
public class CellWithPower {

	@Id
	@JoinColumn( name = "ID")
	@OneToOne
	private Cell id;
	
	@Column( name = "POWER")
	private Double power;

	
	public CellWithPower(Cell id, Double power) {
		super();
		this.id = id;
		this.power = power;
	}

	public Cell getId() {
		return id;
	}

	public void setId(Cell id) {
		this.id = id;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}

}
