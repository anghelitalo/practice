package com.jalasoft.practice.controller;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileOutputStream;

public class MultipartFileWriter {

    public void writeFile(MultipartFile file, Path dir) {

            Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());

            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
