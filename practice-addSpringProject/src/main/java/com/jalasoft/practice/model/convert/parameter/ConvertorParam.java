/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.model.convert.parameter;

import com.jalasoft.practice.common.exception.InvalidDataException;

import java.io.File;

/**
 *@version 1.1
 *@author Publica
 */
public class ConvertorParam extends Parameter{

    public ConvertorParam(File file, String format, String outDir) {
        super(file, format, outDir);
    }


    @Override
    public void validate() throws InvalidDataException {
        super.validate();
    }
}
