package com.escuela.demo.controllers;

import com.escuela.demo.hazlecast.cache.model.City;
import com.escuela.demo.hazlecast.cache.model.QCity;
import com.escuela.demo.hazlecast.repository.CityRepository;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
public class BootController {

    @Qualifier("hazelcastInstance")
    @Autowired
    HazelcastInstance hazelcastInstance;

    @Autowired
    CityRepository cityRepository;



    @GetMapping(value = "/youtube")
    public @ResponseBody Map<?,?> getYouTubeVideos() {
        Map s= hazelcastInstance.getMap("customers");
//        IMap map = hazelcastInstance.getMap("employee");
//        getData();
        getPredicate();
        return s;
    }



    public void getPredicate(){
        System.out.println("Predicate ");
        IMap map = hazelcastInstance.getMap("employee");
        map.put("1000",new City().setCountry("Uganda").setName("New York").setMin(new BigInteger("1000")).setMax(new BigInteger("2000")));

//        EntryObject e = new PredicateBuilder().getEntryObject();
//        Predicate predicate=e.lessEqual("max").and(e.greaterEqual("min"));
        Collection <City> coll=  map.values( new SqlPredicate( "min <=3001 AND max > 3001" ) );
//        Collection <City> coll=  map.values( new SqlPredicate( " '3001' between min and max" ) );
        for (City c:coll) {
            System.out.println(c.getCountry());
        }
//        map.values(predicate);
    }

     void getData(){
        cityRepository.save(new City().setCountry("US").setName("New York").setMin(new BigInteger("1000")));
        cityRepository.save(new City().setCountry("US").setName("New York").setMin(new BigInteger("1000")));
        cityRepository.save(new City().setCountry("US").setName("New York"));
        cityRepository.save(new City().setCountry("US").setName("New York"));
        System.out.println("Test "+cityRepository.findAll(QCity.city.max.between(1,10)));
        System.out.println(cityRepository.findAll(QCity.city.country.eq("US"), QCity.city.name.asc()));
        System.out.println("Test "+cityRepository.findRange(8));
        EntryObject e = new PredicateBuilder().getEntryObject();
//        Predicate predicate = e.is("active").and(e.get("age").lessThan(30));
        Predicate predicate=e.lessEqual("max").and(e.greaterEqual("min"));
//        EntryObject e = Predicates.greaterEqual("min",new City());
//        Predicate predicate = e.get("name").equal("body1");


//        System.out.println(cityRepository.findAll(QCity.city.max.gt(1), QCity.city.max.lt(10));
//        cityRepository.findOne(QCity.city.)
//        System.out.println(cityRepository.findTheRange("25"));
//        System.out.println(cityRepository.findTheRange("25"));
//        QCity.city.max.between(1,10);

    }

}
