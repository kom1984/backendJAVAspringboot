package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.PermisConduire;
import com.parkauto.parkauto.repository.IPermisConduireRepository;




@Service
public class PermisConduireService {

	@Autowired
	IPermisConduireRepository permisConduireRepository;

		//List of permisConduire
		public List<PermisConduire> getpermisConduires(){
			return permisConduireRepository.findAll();
		}
		
		
		//save
		public PermisConduire savepermisConduire(PermisConduire permisConduire){
			return permisConduireRepository.save(permisConduire);
		}
		
		// get a permisConduire	
		public PermisConduire getpermisConduireById(Long idcmd) {
			return permisConduireRepository.findById(idcmd).get();
		}
		
		// Delete one permisConduire
		
		public void deletepermisConduire(PermisConduire permisConduire) {
			permisConduireRepository.delete(permisConduire);
		}
	
}
