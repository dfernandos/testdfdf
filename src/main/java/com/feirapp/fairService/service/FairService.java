package com.feirapp.fairService.service;

import com.feirapp.fairService.entity.Fair;
import com.feirapp.fairService.repository.FairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FairService {

    @Autowired
    private FairRepository fairRepository;

    public Fair saveFair(Fair fair){
       return fairRepository.save(fair);
    }

    public List<Fair> saveFairs(List<Fair> fairs){
        return fairRepository.saveAll(fairs);
    }

    public List<Fair> getFairs(){
        return fairRepository.findAll();
    }
}
