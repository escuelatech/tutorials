package com.escuela.demo.hazlecast.repository;

import com.escuela.demo.hazlecast.cache.model.City;
import org.springframework.data.hazelcast.repository.HazelcastRepository;
import org.springframework.data.hazelcast.repository.query.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends HazelcastRepository <City, String>, QuerydslPredicateExecutor <City> {

   @Query(value = "select * from City c  where ( c.min <=:accountNumber and c.max >= :accountNumber ) ")
   City findTheRange(@Param("accountNumber") String accountNumber);

    @Query(value = "select c from City c  where :accountNumber between c.min and c.max ")
    City findRange(@Param("accountNumber") Integer accountNumber);
//    @Query("SELECT m FROM <YOUR_TABLE_NAME> m where ( m.id >=:min and m.id <= :max )")
//    List <City> findTheRange();
}
