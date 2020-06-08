/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.common.configuration;

import com.jalasoft.practice.common.constant.PropertyConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author AL
 * @version 1.1
 */
public class ConfigurationProperty {

    public static List<String> getFormatType() throws InvalidDataException {
        return PropertyHandler.getInstance().getValueAsList(PropertyConstant.FORMAT_TEXT_TYPE);
    }

    public static List<String> getExtensionFile() throws InvalidDataException {
        return PropertyHandler.getInstance().getValueAsList(PropertyConstant.EXTENSION_TEXT_TYPE);
    }
}
