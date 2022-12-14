package com.example.FormBindingExercise.bean;


import lombok.Data;

@Data

public class Car {

    private String model;
    private int year;
    private String brand;

    private final String [] powerTrain = {"Electric", "Internal Combustion", "Hydrogen", "Hybrid"};


}
