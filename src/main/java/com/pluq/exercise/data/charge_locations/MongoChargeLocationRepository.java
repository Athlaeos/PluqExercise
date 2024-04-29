package com.pluq.exercise.data.charge_locations;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoChargeLocationRepository extends MongoRepository<ChargeLocation, String> {
}
