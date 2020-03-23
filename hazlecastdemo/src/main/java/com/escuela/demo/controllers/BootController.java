package com.escuela.demo.controllers;

//import com.escuela.demo.hazlecast.cache.model.City;
import com.escuela.demo.hazlecast.cache.model.City;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.SqlPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

@RestController
public class BootController {

    @Qualifier("hazelcastInstance")
    @Autowired
    HazelcastInstance hazelcastInstance;

    @GetMapping(value = "/findcity")
    public @ResponseBody  Collection <City> getCityNames() {
        IMap map = hazelcastInstance.getMap("country");
        Collection <City> coll=  map.values( new SqlPredicate( "min <=2001 AND max > 2001" ) );
        return coll;
    }

}
