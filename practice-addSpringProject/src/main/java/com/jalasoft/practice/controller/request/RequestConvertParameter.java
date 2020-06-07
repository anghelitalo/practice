package com.jalasoft.practice.controller.request;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.validation.*;
import com.jalasoft.practice.controller.exception.RequestParameter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class RequestConvertParameter extends RequestParameter {

    public RequestConvertParameter(MultipartFile file,String format,String outDir) {
        super(file, format,outDir);
    }

    @Override
    public void validate() throws InvalidDataException {

        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEmptyValidation("outDir",this.outDir),
                new NotNullOrEmptyValidation("format",this.format),
                new MultipartValidation(this.file),
                new FormatValidation(this.format)
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}
