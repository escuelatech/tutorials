package com.escuela.demo.spring.config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.HazelcastKeyValueAdapter;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;

import javax.annotation.PostConstruct;

@Configuration
@EnableHazelcastRepositories("com.escuela.demo.hazlecast.repository")
public class HazelCastConfig {

    @PostConstruct
    public void init(){
    }

    @Bean
    HazelcastInstance hazelcastInstance() {
        return Hazelcast.newHazelcastInstance();
    }

    @Bean
    public KeyValueOperations keyValueTemplate() {
        return new KeyValueTemplate(new HazelcastKeyValueAdapter(hazelcastInstance()));
    }

    @Bean
    public HazelcastKeyValueAdapter hazelcastKeyValueAdapter(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        return new HazelcastKeyValueAdapter(hazelcastInstance);
    }

}
