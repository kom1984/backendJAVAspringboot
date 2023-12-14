package com.parkauto.parkauto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "LOCATION")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDLOCATION")
	private Long idLocation;
	
	@Column(name = "DATEDEBUT")
	private String dateDebut;
	
	@Column(name = "DATERETOUR")
	private String dateretour;
	
	@Column(name = "DEBUTLOCATION")
	private String debutLocation;
	
	
	@ManyToMany
	@JoinTable(name="LOCATION_CLIENT")
	private List<Client> clientList;
	
	@JsonIgnore
	@ManyToMany(mappedBy ="locationList")
	private List<Vehicule> vehiculeList;
	
	
	public Location(String dateDebut, String dateretour, String debutLocation, List<Client> clientList,
			List<Vehicule> vehiculeList) {
		super();
		this.dateDebut = dateDebut;
		this.dateretour = dateretour;
		this.debutLocation = debutLocation;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}




	public Location(Long idLocation, String dateDebut, String dateretour, String debutLocation, List<Client> clientList,
			List<Vehicule> vehiculeList) {
		super();
		this.idLocation = idLocation;
		this.dateDebut = dateDebut;
		this.dateretour = dateretour;
		this.debutLocation = debutLocation;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}




	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Location(List<Vehicule> vehiculeList) {
		super();
		this.vehiculeList = vehiculeList;
	}




	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}


	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}


	public Long getIdLocation() {
		return idLocation;
	}


	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateretour() {
		return dateretour;
	}


	public void setDateretour(String dateretour) {
		this.dateretour = dateretour;
	}


	public String getDebutLocation() {
		return debutLocation;
	}


	public void setDebutLocation(String debutLocation) {
		this.debutLocation = debutLocation;
	}


	public List<Client> getClientList() {
		return clientList;
	}


	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}




	
	
}
