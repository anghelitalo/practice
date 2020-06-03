package com.jalasoft.practice.model.convert;
import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.parameter.Parameter;
import com.jalasoft.practice.model.convert.result.Result;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertorHandle implements IConvertor<ConvertorParam>{


    @Override
    public Result convertor(ConvertorParam param) throws ConvertorException, ParameterInvalidException {
        param.validate();
        File fileName = param.getInputFile(); // provide the path to pdf file
        PDDocument document = null;

        try
        {
            document = PDDocument.load( new File(fileName.getAbsolutePath()));

            PDFRenderer renderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage image = renderer.renderImage(page);
                String page_index = Integer.toString(page);
                ImageIO.write(image, param.getFormat(), new File("custom-render"+page_index+"."+(param.getFormat()).toLowerCase()));
            }
            document.close();
            return new Result("Images created");

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
