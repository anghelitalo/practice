package com.jalasoft.practice.controller.endpoint;
import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author HP
 * @version 1.1
 */
@RequestMapping("/api/v1")
@RestController
public class DownloadController {
    @Autowired
    private Properties properties;

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity downloadFile(@PathVariable("fileName") String fileName) {
        try {
            String commonContentType = "application/zip";
            Path path = Paths.get(properties.getDirectoryFolder()+properties.getPublicFolder()+"\\"+ fileName);
            Resource resource = new UrlResource(path.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName)
                    .contentType(MediaType.parseMediaType(commonContentType))
                    .body(resource);
        } catch (MalformedURLException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        }
    }
}
