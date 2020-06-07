package com.jalasoft.practice.controller.service;

import com.jalasoft.practice.common.constant.ErrorMessageConstant;
import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.exception.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.nio.file.StandardCopyOption;
@Service
public class FileService {

    @Autowired
    private Properties properties;

    public File store(MultipartFile file) throws FileException {

        try {
                String fileInput;
                String folder = properties.getDirectoryFolder();
                fileInput = folder + file.getOriginalFilename();
                Path path = Paths.get(fileInput);
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
                return new File(fileInput);
            } catch (Exception ex) {
                throw new FileException(ErrorMessageConstant.FILE_ERROR, ex);
            }
    }

    public String getDownloadLink(File file) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/")
                .path(file.getName())
                .toUriString();
    }
}
