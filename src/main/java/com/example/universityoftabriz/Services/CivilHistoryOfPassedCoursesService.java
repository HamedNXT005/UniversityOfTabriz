package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.CivilHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilHistoryOfPassedCoursesService {
    @Autowired
    private CivilHistoryOfPassedCoursesRepository civilHistoryOfPassedCoursesRepository;
}
