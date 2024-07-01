package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
}
