package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ComputerStudentsPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerStudentsPlanService {
    @Autowired
    private ComputerStudentsPlanRepository computerStudentsPlanRepository;

}
