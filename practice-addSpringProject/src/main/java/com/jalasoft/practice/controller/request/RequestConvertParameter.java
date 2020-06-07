package com.jalasoft.practice.controller.request;
import org.springframework.web.multipart.MultipartFile;

public class RequestConvertParameter {
    private MultipartFile file;
    private String format;
    private String outDir;

    public RequestConvertParameter(MultipartFile file, String format, String outDir) {
        this.file = file;
        this.format = format;
        this.outDir = outDir;
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

    public String getOutDir() { return outDir;}

    public void setOutDir(String outDir) {this.outDir = outDir;}
}
