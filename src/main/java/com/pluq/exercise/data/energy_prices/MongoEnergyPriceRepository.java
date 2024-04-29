package com.pluq.exercise.data.energy_prices;

import com.pluq.exercise.domain.pojo.EnergyPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface MongoEnergyPriceRepository extends MongoRepository<EnergyPrice, String> {
    @Query("{ 'date': ?0, 'timeSlot': ?1 }")
    Collection<EnergyPrice> pricesForDateHour(String date, int hour);
}
