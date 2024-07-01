package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ChemistryStudentsPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryStudentsPlanService {
    @Autowired
    private ChemistryStudentsPlanRepository chemistryStudentsPlanRepository;
}
