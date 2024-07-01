package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.MechanicReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicReportService {
    @Autowired
    private MechanicReportRepository mechanicReportRepository;
}
