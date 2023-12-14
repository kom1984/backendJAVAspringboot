package com.parkauto.parkauto.controller;


import com.parkauto.parkauto.entity.ParkautoImages;
import com.parkauto.parkauto.service.ParkautoImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")

public class ParkautoImagesController {
    @Autowired
    ParkautoImagesService parkautoImagesService;

    @PostMapping("/parkautoImage")
    public ParkautoImages createParkautoImages(@Validated @RequestBody(required = false)ParkautoImages parkautoImages) {
        return parkautoImagesService.saveParkautoImages(parkautoImages);
    }

    @GetMapping("/parkautoImages")
    public List<ParkautoImages> getAllParkautoImages(){
        return parkautoImagesService.getParkautoImagess();
    }

    @GetMapping("/parkautoImages/idparkautoImages")
    public ResponseEntity findParkautoImagesByid(@PathVariable(name="idParkautoImages") Long idParkautoImages){
        if(idParkautoImages == null) {
            return ResponseEntity.badRequest().body("cannot retreive parkautoImages with  null id");
        }
        ParkautoImages parkautoImages = parkautoImagesService.getParkautoImagesById(idParkautoImages);

        if(parkautoImages == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(parkautoImages);
    }



    @DeleteMapping("/parkautoImages/idparkautoImages")
    public ResponseEntity<ParkautoImages> deleteParkautoImages(@Validated @PathVariable(name="idParkautoImages") Long idParkautoImages){
        ParkautoImages parkautoImages = parkautoImagesService.getParkautoImagesById(idParkautoImages);
        if(parkautoImages == null) {
            return ResponseEntity.notFound().build();
        }
        parkautoImagesService.deleteParkautoImages(parkautoImages);
        return ResponseEntity.ok().body(parkautoImages);
    }


}
