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
 * Car.java - a child class for demonstrating the use of
 * inheritance extends from Land.java class.
 * @version 1.0
 */
public class Car extends Land {
    //Peculiarity of Car Land Transport.
    private boolean useGas;

    /**
     * Create a Car.
     * @param name String data type.
     * @param price Int data type.
     * @param hasMotor Bool data type.
     * @param useGas Bool data type.
     */
    public Car(String name, int price, boolean hasMotor, boolean useGas) {
        super.Land(name, price, hasMotor);
        this.useGas = useGas;
    }

    /**
     * Retrieve the message of a car data.
     * @return String data type.
     */
    @Override
    public String displayData() {
        return String.format("name= %s ,price= %d,hasMotor= %s, useGas= %s", this.getName(), this.getPrice(), hasMotor, useGas);
    }
}
