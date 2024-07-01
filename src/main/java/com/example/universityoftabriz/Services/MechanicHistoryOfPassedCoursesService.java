package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.MechanicHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicHistoryOfPassedCoursesService {
    @Autowired
    private MechanicHistoryOfPassedCoursesRepository mechanicHistoryOfPassedCoursesRepository;
}
