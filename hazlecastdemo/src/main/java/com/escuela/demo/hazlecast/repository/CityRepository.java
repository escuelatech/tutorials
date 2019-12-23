package com.escuela.demo.hazlecast.repository;

import com.escuela.demo.hazlecast.cache.model.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface CityRepository extends HazelcastRepository<City, String> {

}
