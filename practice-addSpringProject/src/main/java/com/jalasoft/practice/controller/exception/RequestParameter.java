/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.controller.exception;

import com.jalasoft.practice.common.exception.InvalidDataException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author AL
 * @version 1.1
 */
public abstract class RequestParameter {
    protected String format;
    protected String outDir;
    protected MultipartFile file;

    public RequestParameter(MultipartFile file,String format,String outDir) {
        this.format = format;
        this.file = file;
        this.outDir = outDir;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public abstract void validate() throws InvalidDataException;
}