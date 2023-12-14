package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkauto.parkauto.entity.Commande;
import com.parkauto.parkauto.repository.ICommandeRepository;



@Service
public class CommandeService {

	@Autowired
	ICommandeRepository commandeRepository;

		//Liste de commande
		public List<Commande> getCommandes(){
			return commandeRepository.findAll();
		}
		
		
		//save
		public Commande saveCommande(Commande commande){
			return commandeRepository.save(commande);
		}
		
		// get a commande	
		public Commande getCommandeById(Long idcmd) {
			return commandeRepository.findById(idcmd).get();
		}
		
		// Delete un commande
		
		public void deleteCommande(Commande commande) {
			commandeRepository.delete(commande);
		}
	
}
