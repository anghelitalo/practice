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
 *
 */
public class Main {
    public static void main(String[] args){
        //List of Land Transport objects.
        ListLandTransport trans = new ListLandTransport();
        trans.addLand(new Bicycle("Cross",1500,false,false));
        trans.addLand(new Car("Audi",20000,true,false));
        //Display the message for each Land Transport.
        trans.display();
    }
}
