/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.model.convert.IConvertor;
import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.result.Result;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *@version 1.1
 *@author Publica
 */
public class ConvertorPng implements IConvertor {
    @Override
    public Result convertor(ConvertorParam param) throws ConvertorException, ParameterInvalidException {
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
                ImageIO.write(image, "PNG", new File("custom-render"+page_index+".png"));
            }

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
