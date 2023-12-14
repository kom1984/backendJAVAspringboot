package com.parkauto.parkauto.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table (name = "CAMION")
public class Camion extends Vehicule{	
	
	@Override
	public String demarrer() {
		return "BRRRRRRRRRR";
	}
	
	
	@Override
	public String accelerer() {
		return "BROUMMMMM";
	}



	
}

