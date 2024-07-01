package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.MechanicStudentsPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicStudentsPlanService {
    @Autowired
    private MechanicStudentsPlanRepository mechanicStudentsPlanRepository;
    
}
