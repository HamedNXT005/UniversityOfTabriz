package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ElectricStudentsPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricStudentsPlanService {
    @Autowired
    private ElectricStudentsPlanRepository electricStudentsPlanRepository;
}
