package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.MechanicDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicDefinedCoursesService {
    @Autowired
    private MechanicDefinedCoursesRepository mechanicDefinedCoursesRepository;

}
