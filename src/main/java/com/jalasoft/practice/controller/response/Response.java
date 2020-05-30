/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.controller.response;

/**
 *@version 1.1
 *@author Publica
 */
public abstract class Response {
    String status;

    public Response(String status) {
        this.status =  status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
