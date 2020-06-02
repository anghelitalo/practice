package com.jalasoft.practice.controller.service;

import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.constant.ErrorConstant;
import com.jalasoft.practice.controller.exception.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.StandardCopyOption;
@Service
public class FileService {

    @Autowired
    private Properties properties;

    public File writeFile(MultipartFile file) throws FileException {

        try {
                String fileInput;
                String folder = properties.getInputFolder();
                fileInput = folder + file.getOriginalFilename();
                Path path = Paths.get(fileInput);
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
                return new File(fileInput);
            } catch (Exception ex) {
                throw new FileException(ErrorConstant.FILE_ERROR, ex);
            }
    }
}
