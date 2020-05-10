/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice3;

/**
 * Bicycle.java - a child class for demonstrating the use of
 * inheritance extends from Land.java class.
 * @version 1.0
 */
public class Bicycle extends Land {
   //Peculiarity of Bicycle Land Transport.
    private boolean exercise;

    /**
     * Create a bicycle.
     * @param name String data type.
     * @param price Int data type.
     * @param hasMotor Bool data type.
     * @param exerciseBike bool data type.
     */
    public Bicycle(String name, int price, boolean hasMotor, boolean exerciseBike) {
        super.Land(name, price, hasMotor);
        this.exercise = exerciseBike;
    }

    /**
     * Retrieve the message of a bicycle data.
     * @return String data type.
     */
    @Override
    public String displayData() {
        return String.format("name= %s ,price= %d,hasMotor= %s, exercise= %s", this.getName(), this.getPrice(), hasMotor, exercise);
    }
}
