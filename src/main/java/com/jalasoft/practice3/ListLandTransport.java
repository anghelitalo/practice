/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice3;

import java.util.ArrayList;
import java.util.List;

/**
 * ListLandTransport.java handle the
 * Land objects.
 * @version 1.0
 */
public class ListLandTransport {
    //List of objects kind Land.
    private List<Land> landList = new ArrayList<Land>();

    /**
     * Add a object kind Land to a list.
     * @param land Land data type.
     */
    public void addLand(Land land) {
        landList.add(land);
    }

    /**
     * Display the message created
     * of each Land Object.
     */
    public void display() {
        landList.stream().forEach(value -> System.out.println(value.displayData()));
    }
}
