package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.Agence;
import com.parkauto.parkauto.repository.IAgenceRepository;


@Service //1er
public class AgenceService {
@Autowired
IAgenceRepository agenceRepository;
 
//list of agence
	public List<Agence> getAgences(){
	return agenceRepository.findAll();
	}
//save
	public Agence saveAgence(Agence agence){
		return agenceRepository.save(agence);
	}
	// get a agence	
	public Agence getAgenceById(Long idagence) {
		return agenceRepository.findById(idagence).get();
	}
	// Delete a agence
	public void deleteAgence(Agence agence) {
		agenceRepository.delete(agence);
	}
 
}