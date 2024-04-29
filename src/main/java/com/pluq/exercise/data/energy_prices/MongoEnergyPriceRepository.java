package com.pluq.exercise.data.energy_prices;

import com.pluq.exercise.domain.pojo.EnergyPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEnergyPriceRepository extends MongoRepository<EnergyPrice, String> {
}
