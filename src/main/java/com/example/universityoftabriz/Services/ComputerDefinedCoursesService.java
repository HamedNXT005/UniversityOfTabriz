package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ComputerDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerDefinedCoursesService {
    @Autowired
    private ComputerDefinedCoursesRepository computerDefinedCoursesRepository;
}
