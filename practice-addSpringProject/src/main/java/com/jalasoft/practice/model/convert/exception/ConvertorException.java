/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.model.convert.exception;

/**
 *@version 1.1
 *@author Publica
 */
public class ConvertorException extends Exception{
    private static final String MESSAGE = "Error converting information from file.";

    public ConvertorException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public ConvertorException(Throwable ex) {
        super(MESSAGE, ex);
    }
}
