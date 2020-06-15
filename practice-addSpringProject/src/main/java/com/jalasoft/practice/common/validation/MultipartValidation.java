/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.configuration.ConfigurationProperty;
import com.jalasoft.practice.common.constant.ErrorMessageConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author AL
 * @version 1.1
 */
public class MultipartValidation implements IValidatorStrategy {
    private MultipartFile file;
    private List<String> EXTENSIONS;

    public MultipartValidation(MultipartFile file) {
        this.file = file;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (this.file == null || this.file.isEmpty() || this.file.getOriginalFilename().contains("..")) {
            throw new InvalidDataException(ErrorMessageConstant.MULTIPART_ERROR_MESSAGE);
        }
        this.extensionValidation();
    }

    private void extensionValidation() throws InvalidDataException {
        this.EXTENSIONS = ConfigurationProperty.getExtensionFile();
        String fileContentType = this.file.getContentType();
        if (!EXTENSIONS.contains(fileContentType)) {
            throw new InvalidDataException(ErrorMessageConstant.EXTENSION_ERROR_MESSAGE);
        }
    }
}
