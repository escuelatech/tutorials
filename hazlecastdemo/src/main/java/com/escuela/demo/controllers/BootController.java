package com.escuela.demo.controllers;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BootController {

    @Qualifier("hazelcastInstance")
    @Autowired
    HazelcastInstance hazelcastInstance;

    @GetMapping(value = "/youtube")
    public @ResponseBody Map<?,?> getYouTubeVideos() {
        System.out.print(">>>>> Test111 >>>>>>>>");
        Map s= hazelcastInstance.getMap("customers");
        return s;
    }

}
