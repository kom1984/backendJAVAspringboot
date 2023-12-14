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

import com.parkauto.parkauto.entity.Client;
import com.parkauto.parkauto.entity.Commande;
import com.parkauto.parkauto.service.ClientService;
import com.parkauto.parkauto.service.CommandeService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class CommandeController {

	@Autowired
	CommandeService commandeService;
	
	@PostMapping("/commande")
	public Commande createCommande(@Validated @RequestBody(required = false)Commande commande) {
		return commandeService.saveCommande(commande);
	}
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommande(){
		return commandeService.getCommandes();
	}
	
	@GetMapping("/commandes/idcommande")
	public ResponseEntity findCommandeByid(@PathVariable(name="idCommande") Long idCommande){
		if(idCommande == null) {
			return ResponseEntity.badRequest().body("cannot retreive commande with  null id");
		}
		Commande commande = commandeService.getCommandeById(idCommande);
		
		if(commande == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(commande);
	}
	
	
	
	@DeleteMapping("/commandes/idcommande")
	public ResponseEntity<Commande> deleteCommande(@Validated @PathVariable(name="idCommande") Long idCommande){
		Commande commande = commandeService.getCommandeById(idCommande);
		if(commande == null) {
			return ResponseEntity.notFound().build();
		}
		commandeService.deleteCommande(commande);
		return ResponseEntity.ok().body(commande);
	}
	
}
