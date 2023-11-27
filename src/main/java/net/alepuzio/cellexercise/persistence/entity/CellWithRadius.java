package net.alepuzio.cellexercise.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CELL_WITH_RADIUS")
public class CellWithRadius {

	@Id
	@Column( name = "ID")
	private Cell id;

	@Column( name = "RADIUS")
	private Double radius;

	
	
	public CellWithRadius(Cell id, Double radius) {
		super();
		this.id = id;
		this.radius = radius;
	}

	public Cell getId() {
		return id;
	}

	public void setId(Cell id) {
		this.id = id;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

}
