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
 *Transport.java - a father class for demonstrating the use of
 * inheritance.
 * @version 1.0
 */
public class Transport {
    //name of transport.
    private String name;
    //price of transport.
    private int price;

    /**
     * Method for creation of Transport.
     * @param name String data type.
     * @param price Int data type.
     */
    public void Transport(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Retrieve the value of price.
     * @return A Int data type.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Retrieve the value of name.
     * @return A String data type.
     */
    public String getName() {
        return name;
    }

}
