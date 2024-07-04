package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Repository.ResourcesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ResourcesService {
    @Autowired
    private ResourcesRepository resourcesRepository;

    public void updateResource(Resources resource ) {
            resourcesRepository.save(resource);

    }

    public Optional<Resources> getResourceByDate(Date date, int semester){
        return resourcesRepository.findByYearEdAndSemester(date,semester);
    }

    public Resources getLastRecord(){
        return resourcesRepository.findLastRecord();
    }
}
