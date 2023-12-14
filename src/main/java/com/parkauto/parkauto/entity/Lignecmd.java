package com.parkauto.parkauto.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "LIGNECMD")
public class Lignecmd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDLIGNECMD")
	private Long id;
	
	@Column(name = "LIBELLE")
	private String libelle;	
	
	@Column(name = "QTE")
	private int qte;
	
	@Column(name = "PRIX")
	private double prix;
	
	
	@ManyToOne
	@JoinColumn(name="lignecmd_id")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="Lignecmd-vehicule-id")
	private Vehicule vehicule;




	public Lignecmd() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Lignecmd(String libelle, int qte, double prix, Commande commande, Vehicule vehicule) {
		super();
		this.libelle = libelle;
		this.qte = qte;
		this.prix = prix;
		this.commande = commande;
		this.vehicule = vehicule;
	}


	public Lignecmd(Long id, String libelle, int qte, double prix, Commande commande, Vehicule vehicule) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.qte = qte;
		this.prix = prix;
		this.commande = commande;
		this.vehicule = vehicule;
	}


	public Vehicule getVehicule() {
		return vehicule;
	}


	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	

	
	
	
	
	
}
