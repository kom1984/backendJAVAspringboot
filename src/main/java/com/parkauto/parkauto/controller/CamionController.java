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
 
import com.parkauto.parkauto.entity.Camion;
import com.parkauto.parkauto.service.CamionService;
 
 
@RestController
@RequestMapping
@CrossOrigin("*")
public class CamionController {
	@Autowired
	CamionService camionService;
	
	@PostMapping("/camion")
	public Camion createCamion(@Validated @RequestBody(required = false)Camion camion) {
		return camionService.saveCamion(camion);
	}
	
	@GetMapping("/camions")
	public List<Camion> getAllCamion(){
		return camionService.getCamions();
	}
	
	@GetMapping("/camions/idcamion")
	public ResponseEntity findCamionByid(@PathVariable(name="idCamion") Long idCamion){
		if(idCamion == null) {
			return ResponseEntity.badRequest().body("cannot retreive camion with  null id");
		}
		Camion camion = camionService.getCamionById(idCamion);
		
		if(camion == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(camion);
	}
	
	
	
	@DeleteMapping("/camions/idcamion")
	public ResponseEntity<Camion> deleteCamion(@Validated @PathVariable(name="idCamion") Long idCamion){
		Camion camion = camionService.getCamionById(idCamion);
		if(camion == null) {
			return ResponseEntity.notFound().build();
		}
		camionService.deleteCamion(camion);
		return ResponseEntity.ok().body(camion);
	}
	
	
}