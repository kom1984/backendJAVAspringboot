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

import com.parkauto.parkauto.entity.Lignecmd;
import com.parkauto.parkauto.service.LignecmdService;



@RestController
@RequestMapping
@CrossOrigin("*")
public class LignecmdController {
	
	
	
	@Autowired
	LignecmdService lignecmdService;
	
	@PostMapping("/lignecmd")
	public Lignecmd createLignecmd(@Validated @RequestBody(required = false)Lignecmd lignecmd) {
		return lignecmdService.saveLignecmd(lignecmd);
	}
	
	@GetMapping("/lignecmds")
	public List<Lignecmd> getAllLignecmd(){
		return lignecmdService.getLignecmd();
	}
	
	@GetMapping("/lignecmds/idlignecmd")
	public ResponseEntity findLignecmdByid(@PathVariable(name="idLignecmd") Long idLignecmd){
		if(idLignecmd == null) {
			return ResponseEntity.badRequest().body("cannot retreive lignecmd with  null id");
		}
		Lignecmd lignecmd = lignecmdService.getLignecmdById(idLignecmd);
		
		if(lignecmd == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(lignecmd);
	}
	
	
	
	@DeleteMapping("/lignecmds/idlignecmd")
	public ResponseEntity<Lignecmd> deleteLignecmd(@Validated @PathVariable(name="idLignecmd") Long idLignecmd){
		Lignecmd lignecmd = lignecmdService.getLignecmdById(idLignecmd);
		if(lignecmd == null) {
			return ResponseEntity.notFound().build();
		}
		lignecmdService.deleteLignecmd(lignecmd);
		return ResponseEntity.ok().body(lignecmd);
	}

}
