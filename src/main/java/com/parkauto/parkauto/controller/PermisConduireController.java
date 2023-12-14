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

import com.parkauto.parkauto.entity.PermisConduire;

import com.parkauto.parkauto.service.PermisConduireService;


@RestController
@RequestMapping
@CrossOrigin("*")
public class PermisConduireController  {

	@Autowired
	PermisConduireService permisConduireService;
	
	@PostMapping("/permisConduire")
	public PermisConduire createPermisConduire(@Validated @RequestBody(required = false)PermisConduire permisConduire) {
		return permisConduireService.savepermisConduire(permisConduire);
	}
	
	@GetMapping("/permisConduires")
	public List<PermisConduire> getAllPermisConduire(){
		return permisConduireService.getpermisConduires();
	}
	
	@GetMapping("/permisConduires/idPermisConduire")
	public ResponseEntity findPermisConduireByid(@PathVariable(name="idPermisConduire") Long idPermisConduire){
		if(idPermisConduire == null) {
			return ResponseEntity.badRequest().body("cannot retreive permisConduire with  null id");
		}
		PermisConduire permisConduire = permisConduireService.getpermisConduireById(idPermisConduire);
		
		if(idPermisConduire == null) 
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(permisConduire);
	}
	
	
	
	@DeleteMapping("/permisConduires/idPermisConduire")
	public ResponseEntity<PermisConduire> deletepermisConduire(@Validated @PathVariable(name="idPermisConduire") Long idPermisConduire){
		PermisConduire permisConduire = permisConduireService.getpermisConduireById(idPermisConduire);
		if(permisConduire == null) {
			return ResponseEntity.notFound().build();
		}
		permisConduireService.deletepermisConduire(permisConduire);
		return ResponseEntity.ok().body(permisConduire);
	}
	
}
