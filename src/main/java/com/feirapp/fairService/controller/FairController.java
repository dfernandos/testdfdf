package com.feirapp.fairService.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.feirapp.fairService.entity.Fair;
import com.feirapp.fairService.service.FairService;
import com.feirapp.fairService.utils.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FairController {

    @Autowired
    private FairService fairService;

    @PostMapping("/addFair")
    public Fair addFair(@RequestBody Fair fair){
        return fairService.saveFair(fair);
    }

    @PostMapping("/addMultipleFairs")
    public List<Fair> addMultipleFairs(@RequestBody List<Fair> fairs){
        return fairService.saveFairs(fairs);
    }

    @JsonFormat
    @GetMapping("/fairs")
    public List<Fair> getAllFairs(){
        return fairService.getFairs();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteFair(@PathVariable(value = "id") int id){
        fairService.deleteFair(id);
    }

    @JsonFormat
    @GetMapping("/fairs/{weekday}")
    public List<Fair> getAllFairsByWeekday(@PathVariable(value = "weekday") String weekday){
        return fairService.getFairByWeekDay(weekday);
    }

    @JsonFormat
    @GetMapping("/fairs/markers")
    public List<Marker> getAllMarkers(String weekday){
        return fairService.getMarkers();
    }
}
