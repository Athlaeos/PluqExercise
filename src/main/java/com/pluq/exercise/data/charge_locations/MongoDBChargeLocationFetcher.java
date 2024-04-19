package com.pluq.exercise.data.charge_locations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.pluq.exercise.domain.ChargeLocation;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Collection;
import java.util.HashSet;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBChargeLocationFetcher implements IChargeLocationFetcher {
    private static final String c = "mongodb://localhost:27017";
    private final ConnectionString CONNECTION_STRING = new ConnectionString(c);
    private final CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    private final CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(CONNECTION_STRING)
            .codecRegistry(codecRegistry)
            .build();

    @Override
    public Collection<ChargeLocation> fetchLocations() {
        Collection<ChargeLocation> locations = new HashSet<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase database = mongoClient.getDatabase("pluq");
            MongoCollection<ChargeLocation> collection = database.getCollection("charging_poles", ChargeLocation.class);

            for (ChargeLocation chargeLocation : collection.find()) {
                locations.add(chargeLocation);
            }
        }
        return locations;
    }
}
