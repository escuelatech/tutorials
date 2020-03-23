package com.escuela.demo.hazlecastdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HazlecastdemoApplicationTests {

    @Test
    void contextLoads() {
    }

    //    public void getPredicate(){
//        System.out.println("Predicate ");
//        IMap map = hazelcastInstance.getMap("employee");
////        map.put("1000",new City().setCountry("Uganda").setName("New York").setMin(new BigInteger("1000")).setMax(new BigInteger("2000")));
//        Collection <City> coll=  map.values( new SqlPredicate( "min <=3001 AND max > 3001" ) );
//        //Collection <City> coll=  map.values( new SqlPredicate( " '3001' between min and max" ) );
//        for (City c:coll) {
//            System.out.println(c.getCountry());
//        }
//        //map.values(predicate);
//    }

}
