package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.CivilDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilDefinedCoursesService {
    @Autowired
    private CivilDefinedCoursesRepository civilDefinedCoursesRepository;
}
