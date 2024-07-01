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

    public void updateBudget(Long id, long budget, Logger logger) {
        Optional<Resources> resourceOptional = resourcesRepository.findById(id);
        if (resourceOptional.isPresent()) {
            Resources resource = resourceOptional.get();
            resource.setTotal_budget(budget);
            resourcesRepository.save(resource);
            logger.info("New budget set successfully.");
        } else {
            logger.error("Resource with id: {} not found.",id);
            throw new RuntimeException("Resource with id: " + id + " not found.");
        }
    }

    public void updateBudget(Resources resource, long budget, Logger logger) {
            resource.setTotal_budget(budget);
            resourcesRepository.save(resource);
            logger.info("New budget set successfully.");
    }
}
