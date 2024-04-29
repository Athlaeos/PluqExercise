package com.pluq.exercise;

import com.pluq.exercise.data.meter.GsonMeterValueDataAccess;
import com.pluq.exercise.data.meter.IMeterValueDataAccess;
import com.pluq.exercise.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ILocationService locationService(){
        return new LocationService();
    }

    @Bean
    public IMeterValueDataAccess meterValueFetcher() {
        return new GsonMeterValueDataAccess();
    }

    @Bean
    public IMeterValueService meterValueService(IMeterValueDataAccess meterValueFetcher){
        return new MeterValueService(meterValueFetcher);
    }

    @Bean
    public IReportService reportService(){
        return new ReportService();
    }
}
