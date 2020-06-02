/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.parameter.Parameter;
import com.jalasoft.practice.model.convert.result.Result;

/**
 *@version 1.1
 *@author Publica
 */
public interface IConvertor <T extends Parameter>{
    Result convertor(T param) throws ConvertorException, ParameterInvalidException;
}
