package com.escuela.java8.hacks;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderExample {

    public static void main(String[] args) {

        ServiceLoader<Driver> loaderDrivers=ServiceLoader.load (Driver.class);
        Iterator<Driver> driversIterator= loaderDrivers.iterator ();

        try{
            while(driversIterator.hasNext ()){

            }
        }catch (Exception e){

        }


    }
}
