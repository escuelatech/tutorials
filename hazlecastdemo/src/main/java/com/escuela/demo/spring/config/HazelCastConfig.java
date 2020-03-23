package com.escuela.demo.spring.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import com.hazelcast.core.IMap;
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

//    @Bean
    HazelcastInstance hazelcastServerInstance() {
        return Hazelcast.newHazelcastInstance();
    }

    @Bean
    HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();
//      clientConfig.setClusterName("dev");
        clientConfig.getNetworkConfig().addAddress("192.168.1.69", "192.168.1.69:5702");
        return HazelcastClient.newHazelcastClient(clientConfig);
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
