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
import com.jalasoft.practice.common.validation.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *@version 1.1
 *@author Publica
 */
public class Parameter {
    File inputFile;
    String format;
    String outDir;

    public Parameter(File inputFile, String format, String outDir) {
        this.inputFile = inputFile;
        this.format = format;
        this.outDir = outDir;
    }

    public File getInputFile() {
        return inputFile;
    }
    public String getFormat(){return format;}
    public String getOutDir(){return outDir;}

    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEmptyValidation("outDir",this.outDir),
                new NotNullOrEmptyValidation("format",this.format),
                new FileValidation(this.inputFile,true),
                new FormatValidation(this.format)
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}
