package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ElectricHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricHistoryOfPassedCoursesService {
    @Autowired
    private ElectricHistoryOfPassedCoursesRepository electricHistoryOfPassedCoursesRepository;

}
