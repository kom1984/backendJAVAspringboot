package com.parkauto.parkauto.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "MODELEVEHICULE")
public class ModeleVehicule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDMODELE")
	private Long idModele;
	
	@Column(name = "MARQUE")
	private String marque;
	
	@Column(name = "PRIXJOURNEE")
	private double prixJournee;
	
	 @OneToMany(mappedBy = "modele")
	    private List<Vehicule> vehiculeList;
	 

	public ModeleVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ModeleVehicule(String marque, double prixJournee, List<Vehicule> vehiculeList) {
		super();
		this.marque = marque;
		this.prixJournee = prixJournee;
		this.vehiculeList = vehiculeList;
	}


	public ModeleVehicule(Long idModele, String marque, double prixJournee, List<Vehicule> vehiculeList) {
		super();
		this.idModele = idModele;
		this.marque = marque;
		this.prixJournee = prixJournee;
		this.vehiculeList = vehiculeList;
	}


	public Long getIdModele() {
		return idModele;
	}

	public void setIdModele(Long idModele) {
		this.idModele = idModele;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrixJournee() {
		return prixJournee;
	}

	public void setPrixJournee(double prixJournee) {
		this.prixJournee = prixJournee;
	}

	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}

	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}
	 
	 
	
}
	
	
	