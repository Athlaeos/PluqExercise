package com.pluq.exercise.api;

import com.pluq.exercise.domain.ChargeLocation;
import com.pluq.exercise.service.ILocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/locations")
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public Collection<ChargeLocation> getLocations(){
        return locationService.getLocations();
    }
}
