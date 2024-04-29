package com.pluq.exercise.data.meter;

import com.pluq.exercise.domain.pojo.MeterValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface MongoMeterValueRepository extends MongoRepository<MeterValue, String> {
    @Query("{ 'physicalReference' : ?0 }")
    Collection<MeterValue> findByPhysicalReference(String physicalReference);

    @Query("{ 'transactionId': ?0 }")
    Collection<MeterValue> findByTransactionId(String transactionId);
}
