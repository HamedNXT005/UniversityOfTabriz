package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Repository.ResourcesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourcesService {
    @Autowired
    private ResourcesRepository resourcesRepository;

    public void updateResource(Resources resource, Logger logger) {
            resourcesRepository.save(resource);
            logger.info("Resource with id: {} updated successfully.",resource.getId());
    }
}
