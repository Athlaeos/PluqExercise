package com.pluq.exercise;

import com.pluq.exercise.data.charge_locations.GsonChargeLocationFetcher;
import com.pluq.exercise.data.charge_locations.IChargeLocationFetcher;
import com.pluq.exercise.data.meter.GsonMeterValueFetcher;
import com.pluq.exercise.data.meter.IMeterValueFetcher;
import com.pluq.exercise.service.ILocationService;
import com.pluq.exercise.service.IMeterValueService;
import com.pluq.exercise.service.LocationService;
import com.pluq.exercise.service.MeterValueService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public IChargeLocationFetcher locationFetcher(){
        return new GsonChargeLocationFetcher();
    }

    @Bean
    public ILocationService locationService(IChargeLocationFetcher locationFetcher){
        return new LocationService(locationFetcher);
    }

    @Bean
    public IMeterValueFetcher meterValueFetcher() {
        return new GsonMeterValueFetcher();
    }

    @Bean
    public IMeterValueService meterValueService(IMeterValueFetcher meterValueFetcher){
        return new MeterValueService(meterValueFetcher);
    }
}
