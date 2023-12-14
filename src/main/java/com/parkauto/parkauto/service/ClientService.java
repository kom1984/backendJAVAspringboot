package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.Client;
import com.parkauto.parkauto.repository.IClientRepository;



@Service
public class ClientService {
	
	@Autowired
	IClientRepository clientRepository;

		//Liste de client
		public List<Client> getClients(){
			return clientRepository.findAll();
		}
		
		
		//save
		public Client saveClient(Client client){
			return clientRepository.save(client);
		}
		
		// get a client	
		public Client getClientById(Long idcli) {
			return clientRepository.findById(idcli).get();
		}
		
		// Delete un client
		
		public void deleteClient(Client client) {
			clientRepository.delete(client);
		}
	
	
}
