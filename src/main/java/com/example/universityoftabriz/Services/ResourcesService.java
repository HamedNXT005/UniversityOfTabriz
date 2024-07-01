package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcesService {
    @Autowired
    private ResourcesRepository resourcesRepository;
}
