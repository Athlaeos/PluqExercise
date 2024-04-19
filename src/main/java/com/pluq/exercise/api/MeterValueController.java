package com.pluq.exercise.api;

import com.pluq.exercise.domain.MeterValue;
import com.pluq.exercise.service.IMeterValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/meter")
public class MeterValueController {
    private final IMeterValueService meterValueService;

    public MeterValueController(IMeterValueService locationService){
        this.meterValueService = locationService;
    }

    @GetMapping
    public Collection<MeterValue> getLocations(){
        return meterValueService.getMeterValues();
    }
}
