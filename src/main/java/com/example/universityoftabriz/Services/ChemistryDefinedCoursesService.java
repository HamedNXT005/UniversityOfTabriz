package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ChemistryDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryDefinedCoursesService {
    @Autowired
    private ChemistryDefinedCoursesRepository chemistryDefinedCoursesRepository;
}
