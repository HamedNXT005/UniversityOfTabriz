package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ComputerPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerPreCoursesPlanService {
    @Autowired
    private ComputerPreCoursesPlanRepository computerPreCoursesPlanRepository;
}
