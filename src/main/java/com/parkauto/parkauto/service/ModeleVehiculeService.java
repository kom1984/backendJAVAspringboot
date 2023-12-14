package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.ModeleVehicule;
import com.parkauto.parkauto.repository.IModeleVehiculeRepository;

@Service
public class ModeleVehiculeService {	
@Autowired
IModeleVehiculeRepository modeleVehiculeRepository;

	//List of modal vehicle
	public List<ModeleVehicule> getModeleVehicules(){
		return modeleVehiculeRepository.findAll();
	}
	
	
	//save
	public ModeleVehicule saveModeleVehicule(ModeleVehicule modeleVehicule){
		return modeleVehiculeRepository.save(modeleVehicule);
	}
	
	// get a modal vehicle
	public ModeleVehicule getModeleVehiculeById(Long idvehi) {
		return modeleVehiculeRepository.findById(idvehi).get();
	}
	
	// Delete a modal vehicle
	
	public void deleteModeleVehicule(ModeleVehicule modeleVehicule) {
		modeleVehiculeRepository.delete(modeleVehicule);
	}
}
