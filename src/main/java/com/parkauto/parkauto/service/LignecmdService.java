package com.parkauto.parkauto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkauto.parkauto.entity.Lignecmd;
import com.parkauto.parkauto.repository.ILignecmdRepository;

@Service
public class LignecmdService {

	@Autowired
	ILignecmdRepository lignecmdRepository;

		//Liste de lignecmd
		public List<Lignecmd> getLignecmd(){
			return lignecmdRepository.findAll();
		}
		
		
		//save
		public Lignecmd saveLignecmd(Lignecmd lignecmd){
			return lignecmdRepository.save(lignecmd);
		}
		
		// get a lignecmd	
		public Lignecmd getLignecmdById(Long idlignecmd) {
			return lignecmdRepository.findById(idlignecmd).get();
		}
		
		// Delete un lignecmd
		
		public void deleteLignecmd(Lignecmd lignecmd) {
			lignecmdRepository.delete(lignecmd);
		}
}
