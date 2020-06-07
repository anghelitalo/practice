package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.exception.InvalidDataException;

public interface IValidatorStrategy {
    void validate() throws InvalidDataException;
}
