package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.SemesterPhase;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.SemesterPhaseRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterPhaseService {
    @Autowired
    private SemesterPhaseRepository semesterPhaseRepository;

    public void updateSemesterPhase(SemesterPhase semesterPhase ) {
        semesterPhaseRepository.save(semesterPhase);
    }
}
