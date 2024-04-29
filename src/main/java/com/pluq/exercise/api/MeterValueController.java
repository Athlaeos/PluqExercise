package com.pluq.exercise.api;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.pojo.ChargePole;
import com.pluq.exercise.domain.pojo.MeterValue;
import com.pluq.exercise.service.ILocationService;
import com.pluq.exercise.service.IMeterValueService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/metervalues")
public class MeterValueController {
    private final IMeterValueService meterValueService;
    private final ILocationService locationService;

    public MeterValueController(IMeterValueService meterValueService, ILocationService locationService){
        this.meterValueService = meterValueService;
        this.locationService = locationService;
    }

    @GetMapping
    public Collection<MeterValue> getMeterValues(){
        return meterValueService.getMeterValues();
    }

    @RequestMapping(value = "/bylocation", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public Collection<MeterValue> getByLocation(@PathParam(value = "location") String location){
        if (location == null || location.isEmpty()) return new HashSet<>();
        ChargeLocation loc = locationService.get(location);
        if (loc == null) return new HashSet<>();
        return meterValueService.getByLocation(loc);
    }

    @RequestMapping(value = "/bypole", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public Collection<MeterValue> getByPole(@PathParam(value = "location") String location, @PathParam(value = "pole") String pole){
        if (location == null || pole == null || location.isEmpty() || pole.isEmpty()) return new HashSet<>();
        ChargeLocation loc = locationService.get(location);
        if (loc == null) return new HashSet<>();
        ChargePole pol = loc.getEvses().stream().filter(p -> p.getPhysical_reference().equalsIgnoreCase(pole)).findFirst().orElse(null);
        if (pol == null) return new HashSet<>();
        return meterValueService.getByLocation(loc).stream()
                .filter(m -> m.getPhysicalReference().equalsIgnoreCase(pol.getPhysical_reference()))
                .collect(Collectors.toSet());
    }
}
