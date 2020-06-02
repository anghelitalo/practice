package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.exception.FileException;
import com.jalasoft.practice.controller.response.ErrorResponse;
import com.jalasoft.practice.controller.response.OKResponse;
import com.jalasoft.practice.controller.service.FileService;
import com.jalasoft.practice.model.convert.ConvertorHandle;

import com.jalasoft.practice.model.convert.IConvertor;
import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;


@RestController
@RequestMapping("/api/v1")
public class ConvertorController {
    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    @PostMapping("/convertor")
    public ResponseEntity convertPng(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "format") String format){

        try {
            File file_ = fileService.writeFile(file);
            IConvertor<ConvertorParam> convertorHandle = new ConvertorHandle();
            Result result = convertorHandle.convertor(new ConvertorParam(file_, format));
            return ResponseEntity.ok().body(new OKResponse(result.getText(), HttpServletResponse.SC_OK));
        } catch (FileException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );

        } catch (ParameterInvalidException ex){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );

        } catch (ConvertorException ex){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );

        } catch (Exception ex){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        }
    }
}
