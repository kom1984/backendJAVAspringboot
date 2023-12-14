package com.parkauto.parkauto.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.parkauto.parkauto.entity.Voiture;
 
import com.parkauto.parkauto.repository.IVoitureRepository;
 
@Service //1er
public class VoitureService {
@Autowired
IVoitureRepository voitureRepository;
 
//liste des voiture
	public List<Voiture> getVoitures(){
	return voitureRepository.findAll();
	}
//save
	public Voiture saveVoiture(Voiture voiture){
		return voitureRepository.save(voiture);
	}
	// get a voiture	
	public Voiture getVoitureById(Long idVoit) {
		return voitureRepository.findById(idVoit).get();
	}
	// Delete un voiture
	public void deleteVoiture(Voiture voiture) {
		voitureRepository.delete(voiture);
	}
 
}