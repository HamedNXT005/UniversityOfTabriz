package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.SemesterPhase;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.SemesterPhaseRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterPhaseService {
    @Autowired
    private SemesterPhaseRepository semesterPhaseRepository;

    public void updateSemesterPhase(SemesterPhase semesterPhase ) {
        semesterPhaseRepository.save(semesterPhase);
    }

    public List<SemesterPhase> getAll(){
        return semesterPhaseRepository.findAll();
    }


    public long getPhase(){
        long ID = 0;
        List<SemesterPhase> semesterPhases = semesterPhaseRepository.findAll();
        for (SemesterPhase semester: semesterPhases) {
            if (semester.isStatus()){
                ID = semester.getId();
            }
        }
        return ID;
    }
}
