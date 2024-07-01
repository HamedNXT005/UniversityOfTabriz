package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.MechanicPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicPreCoursesPlanService {
    @Autowired
    private MechanicPreCoursesPlanRepository mechanicPreCoursesPlanRepository;

}
