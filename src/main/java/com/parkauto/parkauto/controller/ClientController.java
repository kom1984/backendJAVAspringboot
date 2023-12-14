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
import com.parkauto.parkauto.service.ClientService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/client")
	public Client createClient(@Validated @RequestBody(required = false)Client client) {
		return clientService.saveClient(client);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClient(){
		return clientService.getClients();
	}
	
	@GetMapping("/clients/idclient")
	public ResponseEntity findClientByid(@PathVariable(name="idClient") Long idClient){
		if(idClient == null) {
			return ResponseEntity.badRequest().body("cannot retreive véhicule with  null id");
		}
		Client client = clientService.getClientById(idClient);
		
		if(client == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(client);
	}
	
	
	
	@DeleteMapping("/clients/idclient")
	public ResponseEntity<Client> deleteClient(@Validated @PathVariable(name="idClient") Long idClient){
		Client client = clientService.getClientById(idClient);
		if(client == null) {
			return ResponseEntity.notFound().build();
		}
		clientService.deleteClient(client);
		return ResponseEntity.ok().body(client);
	}

}
