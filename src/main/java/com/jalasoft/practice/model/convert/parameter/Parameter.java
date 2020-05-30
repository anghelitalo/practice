/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.model.convert.parameter;

import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;

import java.io.File;

/**
 *@version 1.1
 *@author Publica
 */
public class Parameter {
    File inputFile;

    public Parameter(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void validate() throws ParameterInvalidException, ParameterInvalidException {
        if(inputFile.isHidden()) {
            throw new ParameterInvalidException();
        }
        if(!inputFile.isFile()) {
            throw new ParameterInvalidException();
        }
    }
}
