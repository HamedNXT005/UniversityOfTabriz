package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.CivilReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilReportService {
    @Autowired
    private CivilReportRepository civilReportRepository;
}
