package com.study.crud.service;

import com.study.crud.entity.Crud;
import com.study.crud.repository.crudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class crudService {

    @Autowired
    private com.study.crud.repository.crudRepository crudRepository;

    public void create(Crud crud, MultipartFile file)throws Exception{
        String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid+"_"+file.getOriginalFilename();
        File savefile = new File(projectpath, filename);
        file.transferTo(savefile);
        crud.setFilename(filename);
        crud.setFilepath("/files/"+filename);
        crudRepository.save(crud);
    }

    public Page<Crud> crudList(Pageable pageable){
        return crudRepository.findAll(pageable);
    }

    public Crud read(Integer id){

        return crudRepository.findById(id).get();
    }

    public void delete(Integer id){
        crudRepository.deleteById(id);
    }

    public Page<Crud> crudSearchList(String searchKeyword, Pageable pageable){

        return crudRepository.findByTitleContaining(searchKeyword, pageable);
    }
}
