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
import java.util.Arrays;
import java.util.List;

/**
 *@version 1.1
 *@author Publica
 */
public class Parameter {
    File inputFile;
    String format;
    private final static List<String> formats = Arrays.asList("jpg","jpeg","png","bmp","gif");
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

    public void validate() throws ParameterInvalidException {
        if(inputFile.isHidden()) {
            throw new ParameterInvalidException();
        }
        if(!inputFile.isFile()) {
            throw new ParameterInvalidException();
        }
        if(format.isEmpty()){
            throw new ParameterInvalidException();
        }
        if(!formats.contains(this.format.toLowerCase()))
        {
            throw new ParameterInvalidException();
        }
    }
}
