/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.constant.ErrorMessageConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.configuration.ConfigurationProperty;

import java.util.List;

/**
 * @author AL
 * @version 1.1
 */
public class FormatValidation implements IValidatorStrategy {
    /**
     *
     */
    private final String ext;
    /**
     *
     */
    private List<String> FORMAT;

    /**
     * @param ext
     */
    public FormatValidation(String ext) {
        this.ext = ext;
    }

    /**
     * @throws InvalidDataException
     */
    @Override
    public void validate() throws InvalidDataException {
        this.FORMAT = ConfigurationProperty.getFormatType();
        if (!FORMAT.contains(this.ext)) {
            throw new InvalidDataException(ErrorMessageConstant.EXTENSION_ERROR_MESSAGE);
        }
    }
}
