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

import com.parkauto.parkauto.entity.Voiture;
import com.parkauto.parkauto.service.VoitureService;
 
 
@RestController
@RequestMapping
@CrossOrigin("*")
public class VoitureController {
	@Autowired
	VoitureService voitureService;
	
	@PostMapping("/voiture")
	public Voiture createVoiture(@Validated @RequestBody(required = false)Voiture voiture) {
		return voitureService.saveVoiture(voiture);
	}
	
	@GetMapping("/voitures")
	public List<Voiture> getAllVoiture(){
		return voitureService.getVoitures();
	}
	
	@GetMapping("/voitures/idvoiture")
	public ResponseEntity findVoitureByid(@PathVariable(name="idVoiture") Long idVoiture){
		if(idVoiture == null) {
			return ResponseEntity.badRequest().body("cannot retreive voiture with  null id");
		}
		Voiture voiture = voitureService.getVoitureById(idVoiture);
		
		if(voiture == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(voiture);
	}
	
	
	
	@DeleteMapping("/voitures/idvoiture")
	public ResponseEntity<Voiture> deleteVoiture(@Validated @PathVariable(name="idVoiture") Long idVoiture){
		Voiture voiture = voitureService.getVoitureById(idVoiture);
		if(voiture == null) {
			return ResponseEntity.notFound().build();
		}
		voitureService.deleteVoiture(voiture);
		return ResponseEntity.ok().body(voiture);
	}
	
	
}