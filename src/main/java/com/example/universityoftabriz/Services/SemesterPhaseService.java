package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.SemesterPhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterPhaseService {
    @Autowired
    private SemesterPhaseRepository semesterPhaseRepository;

}
