package com.parkauto.parkauto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="vehicule")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDVEHICULE")
	private Long id;
	
	@Column(name = "ANNEEMODEL")
	private String anneeModel;
	
	@Column(name = "MARQUEVEHICULE")
	private String marqueVehicule;


	@Column(name = "IMAGEVEHICULE")
	private String imageVehicule;

	@Column(name = "DESCRIPTIF")
	private String descriptif;


	@Column(name = "PRIX")
	private double prix;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="location_vehicule")
	private List<Location> locationList;
	
	@OneToMany(mappedBy="vehicule")
	private List<Lignecmd> lignecmd;
	
	@ManyToMany
	@JoinTable(name="agence_vehicule")
	private List<Agence> agenceList;
	
	
	@ManyToOne
	@JoinColumn(name="modele_id")
	private ModeleVehicule modele;

	@OneToMany(mappedBy="vehicule")
	private List<ParkautoImages> ImageList;

	public String demarrer() {
		return "Véhicule démarré";
	}
	
	public String accelerer() {
		return "Véhicule accéleré";
	}
	

	
}
