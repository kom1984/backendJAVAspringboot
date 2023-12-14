package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.Vehicule;
import com.parkauto.parkauto.repository.IVehiculeRepository;


@Service
public class VehiculeService {	
@Autowired
IVehiculeRepository vehiculeRepository;

	//Liste de véhicule
	public List<Vehicule> getVehicules(){
		return vehiculeRepository.findAll();
	}
	
	
	//save
	public Vehicule saveVehicule(Vehicule vehicule){
		return vehiculeRepository.save(vehicule);
	}
	
	// get a vehicule	
	public Vehicule getVehiculeById(Long idvehi) {
		return vehiculeRepository.findById(idvehi).get();
	}
	
	// Delete un vehicule
	
	public void deleteVehicule(Vehicule vehicule) {
		vehiculeRepository.delete(vehicule);
	}
}
