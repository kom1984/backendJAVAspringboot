package com.parkauto.parkauto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERMISCONDUIRE")
public class PermisConduire {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPERMIS")
	private Long idPermis;
	
	@Column(name = "NUMEROPERMIS")
	private String numeroPermis;
	
	@Column(name = "DATEOBTENTION")
	private String dateObtention;
	
	@OneToOne(mappedBy = "permisConduire")
    private Client client;

	
	public PermisConduire(String numeroPermis, String dateObtention, Client client) {
		super();
		this.numeroPermis = numeroPermis;
		this.dateObtention = dateObtention;
		this.client = client;
	}

	public PermisConduire(Long idPermis, String numeroPermis, String dateObtention, Client client) {
		super();
		this.idPermis = idPermis;
		this.numeroPermis = numeroPermis;
		this.dateObtention = dateObtention;
		this.client = client;
	}

	public PermisConduire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdPermis() {
		return idPermis;
	}

	public void setIdPermis(Long idPermis) {
		this.idPermis = idPermis;
	}

	public String getNumeroPermis() {
		return numeroPermis;
	}

	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	public String getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(String dateObtention) {
		this.dateObtention = dateObtention;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
