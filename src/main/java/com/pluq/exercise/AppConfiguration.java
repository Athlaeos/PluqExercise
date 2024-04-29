package com.pluq.exercise;

import com.pluq.exercise.domain.report.IterativeGenerationStrategy;
import com.pluq.exercise.domain.report.ReportGenerationStrategy;
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
    public IMeterValueService meterValueService(){
        return new MeterValueService();
    }

    @Bean
    public IEnergyPriceService energyPriceService(){
        return new EnergyPriceService();
    }

    @Bean
    public ReportGenerationStrategy reportGenerationStrategy(){
        return new IterativeGenerationStrategy();
    }

    @Bean
    public IReportService reportService(){
        return new ReportService();
    }
}
