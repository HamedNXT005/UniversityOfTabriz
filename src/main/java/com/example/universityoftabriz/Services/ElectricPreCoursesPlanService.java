package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ElectricPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricPreCoursesPlanService {
    @Autowired
    private ElectricPreCoursesPlanRepository electricPreCoursesPlanRepository;

}
