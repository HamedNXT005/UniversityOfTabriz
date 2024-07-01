package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ChemistryHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryHistoryOfPassedCoursesService {
    @Autowired
    private ChemistryHistoryOfPassedCoursesRepository chemistryHistoryOfPassedCoursesRepository;

}
