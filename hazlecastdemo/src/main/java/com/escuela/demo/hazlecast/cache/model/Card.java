package com.escuela.demo.hazlecast.cache.model;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@QueryEntity
@KeySpace("card")
public class Card {

    @Id
    String min;
    String max;
}
