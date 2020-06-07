/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *@version 1.1
 *@author Publica
 */
@Component
@ConfigurationProperties(prefix = "convertor")
public class Properties {
    String outputFolder;
    String directoryFolder;
    String publicFolder;

    public String getPublicFolder() {return publicFolder;}

    public void setPublicFolder(String publicFolder) { this.publicFolder = publicFolder;}

    public String getDirectoryFolder() {
        return directoryFolder;
    }

    public void setDirectoryFolder(String directoryFolder) {
        this.directoryFolder = directoryFolder;
    }

    public String getOutputFolder() {
        return outputFolder;
    }

    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }
}
