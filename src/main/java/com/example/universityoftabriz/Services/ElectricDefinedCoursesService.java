package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ElectricDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricDefinedCoursesService {
    @Autowired
    private ElectricDefinedCoursesRepository electricDefinedCoursesRepository;

}
