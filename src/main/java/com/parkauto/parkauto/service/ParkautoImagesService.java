package com.parkauto.parkauto.service;

import com.parkauto.parkauto.entity.ParkautoImages;
import com.parkauto.parkauto.repository.IParkautoImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkautoImagesService {
    @Autowired
    IParkautoImageRepository parkautoImagesRepository;

    //liste des parkautoImages
    public List<ParkautoImages> getParkautoImagess(){
        return parkautoImagesRepository.findAll();
    }
    //save
    public ParkautoImages saveParkautoImages(ParkautoImages parkautoImages){
        return parkautoImagesRepository.save(parkautoImages);
    }
    // get a parkautoImages	
    public ParkautoImages getParkautoImagesById(Long idimg) {
        return parkautoImagesRepository.findById(idimg).get();
    }
    // Delete un parkautoImages
    public void deleteParkautoImages(ParkautoImages parkautoImages) {
        parkautoImagesRepository.delete(parkautoImages);
    }

}
