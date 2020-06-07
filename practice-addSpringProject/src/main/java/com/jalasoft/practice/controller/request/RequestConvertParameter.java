package com.jalasoft.practice.controller.request;
import com.jalasoft.practice.controller.exception.RequestParamInvalidException;
import com.jalasoft.practice.controller.exception.RequestParameter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class RequestConvertParameter extends RequestParameter {

    private final static List<String> FORMATS = Arrays.asList("jpg","jpeg","png","bmp","gif");

    public RequestConvertParameter(MultipartFile file,String format,String outDir) {
        super(file, format,outDir);
    }

    @Override
    public void validate() throws RequestParamInvalidException {
        if (this.format == null || this.format.trim().isEmpty()) {
            throw new RequestParamInvalidException("format is null or empty");
        }
        if (this.file == null || this.file.isEmpty()) {
            throw new RequestParamInvalidException("file is null or empty");
        }
        if (this.file.getOriginalFilename().contains("..")) {
            throw new RequestParamInvalidException("invalid file name.");
        }
        if (this.outDir == null || this.outDir.trim().isEmpty()) {
            throw new RequestParamInvalidException("outDir is null or empty");
        }
        if (!FORMATS.contains(this.format.toLowerCase())) {
            throw new RequestParamInvalidException("format not allowed.");
        }
    }
}
