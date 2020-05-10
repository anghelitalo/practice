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
 * Land.java - a father class for demonstrating the use of
 * inheritance extends from Transport.java class.
 * @version 1.0
 */
public class Land extends Transport {
    //Peculiarity of kind Land Transport.
    public boolean hasMotor;

    /**
     * For the creation of Transport kind Land.
     * @param name String data type.
     * @param price Int data type.
     * @param hasMotor Bool data type.
     */
    public void Land(String name, int price, boolean hasMotor) {
        super.Transport(name, price);
        this.hasMotor = hasMotor;
    }

    /**
     * Retrieve the value of display Data.
     * @return String data Type.
     */
    public String displayData() {
        return "";
    }

}
