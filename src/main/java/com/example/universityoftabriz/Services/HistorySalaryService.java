package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.HistorySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorySalaryService {
    @Autowired
    private HistorySalaryRepository historySalaryRepository;

}
