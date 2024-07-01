package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ComputerHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerHistoryOfPassedCoursesService {
    @Autowired
    private ComputerHistoryOfPassedCoursesRepository computerHistoryOfPassedCoursesRepository;
}
