package com.parkauto.parkauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkauto.parkauto.entity.Agence;
import com.parkauto.parkauto.service.AgenceService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AgenceController {
	@Autowired
	AgenceService agenceService;
	
	@PostMapping("/agence")
	public Agence createAgence(@Validated @RequestBody(required = false)Agence Agence) {
		return agenceService.saveAgence(Agence);
	}
	
	@GetMapping("/Agences")
	public List<Agence> getAllAgence(){
		return agenceService.getAgences();
	}
	
	@GetMapping("/Agences/idAgence")
	public ResponseEntity findAgenceByid(@PathVariable(name="idAgence") Long idAgence){
		if(idAgence == null) {
			return ResponseEntity.badRequest().body("cannot retreive agence with  null id");
		}
		Agence Agence = agenceService.getAgenceById(idAgence);
		
		if(Agence == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(Agence);
	}
	
	
	
	@DeleteMapping("/Agences/idAgence")
	public ResponseEntity<Agence> deleteAgence(@Validated @PathVariable(name="idAgence") Long idAgence){
		Agence Agence = agenceService.getAgenceById(idAgence);
		if(Agence == null) {
			return ResponseEntity.notFound().build();
		}
		agenceService.deleteAgence(Agence);
		return ResponseEntity.ok().body(Agence);
	}
	
	
}
	
	


