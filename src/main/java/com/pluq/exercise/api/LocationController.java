package com.pluq.exercise.api;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.service.ILocationService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public Collection<ChargeLocation> getLocations(){
        return locationService.getLocations();
    }

    @RequestMapping(value = "/remove", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public HttpStatus remove(@PathParam(value = "id") String id){
        if (id == null || id.isEmpty()) return HttpStatus.NO_CONTENT;
        locationService.removeLocation(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/addorupdate", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public HttpStatus add(@RequestBody ChargeLocation location){
        locationService.addOrUpdateLocation(location);
        return HttpStatus.OK;
    }
}
