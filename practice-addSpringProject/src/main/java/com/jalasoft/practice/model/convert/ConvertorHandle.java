package com.jalasoft.practice.model.convert;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.model.convert.exception.ConvertorException;
import com.jalasoft.practice.model.convert.parameter.ConvertorParam;
import com.jalasoft.practice.model.convert.result.Result;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.jalasoft.practice.model.convert.zip.ZipDirectory.zipDirectory;

public class ConvertorHandle implements IConvertor<ConvertorParam>{
    private static String ZIP_FILE_NAME = "ImagesCreated.zip";
    private static String NEW_FILE_NAME = "custom-render";
    private static String DOC_INVALID = "Document invalid.";

    @Override
    public Result convertor(ConvertorParam param) throws ConvertorException, InvalidDataException {
        param.validate();
        File fileName = param.getInputFile(); // provide the path to pdf file
        PDDocument document = null;
        Path sourceDirectoryPath = Paths.get(param.getOutDir());

        try
        {
            document = PDDocument.load( new File(fileName.getAbsolutePath()));

            PDFRenderer renderer = new PDFRenderer(document);
            Files.createDirectories(Paths.get(param.getOutDir()));

            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage image = renderer.renderImage(page);
                String page_index = Integer.toString(page);
                ImageIO.write(image, param.getFormat(), new File(sourceDirectoryPath +"\\"+NEW_FILE_NAME+page_index+"."+(param.getFormat()).toLowerCase()));
            }
            document.close();

            zipDirectory(sourceDirectoryPath.toString(), sourceDirectoryPath +"\\"+ZIP_FILE_NAME);
            return new Result(ZIP_FILE_NAME);
        } catch (IOException ex) {
            throw new ConvertorException(ex);
        }
        finally {
            if(document == null) {
                throw new InvalidDataException(DOC_INVALID);
            }
        }
    }
}
