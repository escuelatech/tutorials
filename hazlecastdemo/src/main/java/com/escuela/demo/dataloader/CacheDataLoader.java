package com.escuela.demo.dataloader;

import com.escuela.demo.hazlecast.cache.model.City;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;

@Component
public class CacheDataLoader {

    @Qualifier("hazelcastInstance")
    @Autowired
    HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void loadDataToHazleCast(){
        IMap map = hazelcastInstance.getMap("employee");
        map.put("1000",new City().setCountry("Uganda").setName("Africa").setMin(new BigInteger("1000")).setMax(new BigInteger("1999")));
        map.put("2000",new City().setCountry("New York").setName("United States").setMin(new BigInteger("2000")).setMax(new BigInteger("2999")));
        System.err.println("******** DATA LOADED TO HAZLECAST **********");
    }


}
