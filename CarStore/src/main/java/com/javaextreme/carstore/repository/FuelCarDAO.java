package com.javaextreme.carstore.repository;

public interface FuelCarDAO extends CarDAO{
    Integer getEngineVolume(Integer vehiceId);
}
