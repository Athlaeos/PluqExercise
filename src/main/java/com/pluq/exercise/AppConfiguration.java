package com.pluq.exercise;

import com.pluq.exercise.data.converters.StringToZonedDateConverter;
import com.pluq.exercise.data.converters.ZonedDateToStringConverter;
import com.pluq.exercise.domain.report.IterativeGenerationStrategy;
import com.pluq.exercise.domain.report.ReportGenerationStrategy;
import com.pluq.exercise.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMongoAuditing
@EnableWebMvc
public class AppConfiguration implements WebMvcConfigurer {
    @Autowired
    private MappingMongoConverter mongoConverter;

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

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToZonedDateConverter());
        registry.addConverter(new ZonedDateToStringConverter());
    }
}
