package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.controller.request.RequestConvertParameter;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import org.apache.pdfbox.io.IOUtils;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;


public class ConvertorControllerTest {

    @Test
    public void convertPdfValidToImagePng() throws ParameterInvalidException, InvalidDataException, IOException {

        File file = new File("src/test/java/resources/test1.pdf");

        InputStream stream =  new FileInputStream(file);
        MultipartFile mockMultipartFile = new MockMultipartFile("test1", file.getName(), String.valueOf(MediaType.APPLICATION_PDF), stream);

        RequestConvertParameter param = new RequestConvertParameter(mockMultipartFile,"png","D:\\");

        ConvertorController convert = new ConvertorController();

        assertEquals(400, convert.convert(param).getStatusCodeValue());
    }

    private static MultipartFile buildMultipartFile(File file,
                                                   String multipartFileParameterName) throws IOException {
        MultipartFile multipartFile = null;

        try (final FileInputStream input = new FileInputStream(file)) {
            multipartFile = new MockMultipartFile(
                    multipartFileParameterName,
                    file.getName(),
                    Files.probeContentType(file.toPath()),
                    IOUtils.toByteArray(input));
        }

        return multipartFile;
    }

}