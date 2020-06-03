package com.jalasoft.practice.controller.request;
import org.springframework.web.multipart.MultipartFile;

public class RequestConvertParameter {
    private MultipartFile file;
    private String format;

    public RequestConvertParameter(MultipartFile file, String format) {
        this.file = file;
        this.format = format;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
