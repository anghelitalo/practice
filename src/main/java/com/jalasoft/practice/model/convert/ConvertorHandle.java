package com.jalasoft.practice.model.convert;
import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.result.Result;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ConvertorHandle implements IConvertor{


    @Override
    public Result convertor(ConvertorParam param) throws ConvertorException, ParameterInvalidException {
        File fileName = param.getInputFile(); // provide the path to pdf file
        PDDocument document = null;

        try
        {
            document = PDDocument.load( new File(fileName.getAbsolutePath()));
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document).toString();
            return new Result("Text in the area:" + pdfText);
        } catch (IOException ex) {
            throw new ConvertorException(ex);
        }
        finally {
            if(document == null) {
                throw new ParameterInvalidException("Document is not valid");
            }
        }
    }
}
