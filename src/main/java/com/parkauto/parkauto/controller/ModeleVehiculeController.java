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

import com.parkauto.parkauto.entity.ModeleVehicule;
import com.parkauto.parkauto.service.ModeleVehiculeService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ModeleVehiculeController {
	@Autowired
	ModeleVehiculeService modeleVehiculeService;
	
	@PostMapping("/modeleVehicule")
	public ModeleVehicule createModeleVehicule(@Validated @RequestBody(required = false)ModeleVehicule modeleVehicule) {
		return modeleVehiculeService.saveModeleVehicule(modeleVehicule);
	}
	
	@GetMapping("/modeleVehicules")
	public List<ModeleVehicule> getAllModeleVehicule(){
		return modeleVehiculeService.getModeleVehicules();
	}
	
	@GetMapping("/modeleVehicules/idmodeleVehicule")
	public ResponseEntity findModeleVehiculeByid(@PathVariable(name="idModeleVehicule") Long idModeleVehicule){
		if(idModeleVehicule == null) {
			return ResponseEntity.badRequest().body("cannot retreive véhicule with  null id");
		}
		ModeleVehicule modeleVehicule = modeleVehiculeService.getModeleVehiculeById(idModeleVehicule);
		
		if(modeleVehicule == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(modeleVehicule);
	}
	
	
	
	@DeleteMapping("/modeleVehicules/idmodeleVehicule")
	public ResponseEntity<ModeleVehicule> deleteModeleVehicule(@Validated @PathVariable(name="idModeleVehicule") Long idModeleVehicule){
		ModeleVehicule modeleVehicule = modeleVehiculeService.getModeleVehiculeById(idModeleVehicule);
		if(modeleVehicule == null) {
			return ResponseEntity.notFound().build();
		}
		modeleVehiculeService.deleteModeleVehicule(modeleVehicule);
		return ResponseEntity.ok().body(modeleVehicule);
	}
	
	
}
	
	

