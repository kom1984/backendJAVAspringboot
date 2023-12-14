package com.parkauto.parkauto.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "AGENCE")
public class Agence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDAGENCE")
	private Long idAgence;
	
	@Column(name = "NOMAGENCE")
	private String nomAgence;
	
	@Column(name = "ADRESSEAGENCE")
	private String adresseAgence;
	
	@Column(name = "CPAGENCE")
	private String cpAgence;
	
	@Column(name = "VILLEAGENCE")
	private String villeAgence;
	
	@Column(name = "CAPACITEAGENCE")
	private int capaciteAgence;
	
	@ManyToMany(mappedBy = "agenceList")
	private List<Client> clientList;
	
	@ManyToMany(mappedBy = "agenceList")
	private List<Vehicule> vehiculeList;

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getAdresseAgence() {
		return adresseAgence;
	}

	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	public String getCpAgence() {
		return cpAgence;
	}

	public void setCpAgence(String cpAgence) {
		this.cpAgence = cpAgence;
	}

	public String getVilleAgence() {
		return villeAgence;
	}

	public void setVilleAgence(String villeAgence) {
		this.villeAgence = villeAgence;
	}

	public int getCapaciteAgence() {
		return capaciteAgence;
	}

	public void setCapaciteAgence(int capaciteAgence) {
		this.capaciteAgence = capaciteAgence;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}

	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(Long idAgence, String nomAgence, String adresseAgence, String cpAgence, String villeAgence,
			int capaciteAgence, List<Client> clientList, List<Vehicule> vehiculeList) {
		super();
		this.idAgence = idAgence;
		this.nomAgence = nomAgence;
		this.adresseAgence = adresseAgence;
		this.cpAgence = cpAgence;
		this.villeAgence = villeAgence;
		this.capaciteAgence = capaciteAgence;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}

	public Agence(String nomAgence, String adresseAgence, String cpAgence, String villeAgence, int capaciteAgence,
			List<Client> clientList, List<Vehicule> vehiculeList) {
		super();
		this.nomAgence = nomAgence;
		this.adresseAgence = adresseAgence;
		this.cpAgence = cpAgence;
		this.villeAgence = villeAgence;
		this.capaciteAgence = capaciteAgence;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}

	
	
	
	
	
	
	
	
}
	
	