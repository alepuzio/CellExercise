package net.alepuzio.cellexercise.persistence.entity;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CELL")
public class Cell {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column( name = "NAME")
	private String name;
	
	@Column( name = "LATITUDE")
	private Double latitude;
	

	@Column( name = "LONGITUDE")
	private Double longitude;
	

	@Column( name = "TIMESTAMP_CREATION")
	private Timestamp timestamp;
	
	@JoinColumn(name = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private CellWithPower cellWithPower;



	@JoinColumn(name = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private CellWithRadius cellWithRadius;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public CellWithPower getCellWithPower() {
		return cellWithPower;
	}

	public void setCellWithPower(CellWithPower cellWithPower) {
		this.cellWithPower = cellWithPower;
	}

	public CellWithRadius getCellWithRadius() {
		return cellWithRadius;
	}

	public void setCellWithRadius(CellWithRadius cellWithRadius) {
		this.cellWithRadius = cellWithRadius;
	}

	public Cell(Long id, String name, Double latitude, Double longitude, Timestamp timestamp,
			CellWithPower cellWithPower
			, CellWithRadius cellWithRadius
			) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.cellWithPower = cellWithPower;
		this.cellWithRadius = cellWithRadius;
	}

	
	

}
