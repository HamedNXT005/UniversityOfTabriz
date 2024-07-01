package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ChemistryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryReportService {
    @Autowired
    private ChemistryReportRepository chemistryReportRepository;
}
