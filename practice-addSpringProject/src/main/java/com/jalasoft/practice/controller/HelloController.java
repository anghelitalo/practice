package com.jalasoft.practice.controller;

import com.sun.jdi.event.ExceptionEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String sayHello(@RequestParam(value="name") String name,
                           @RequestParam(value="lastName") String lname ,@RequestParam(value = "files[]") List<MultipartFile> files) throws IOException {

           Path path = Paths.get("\\data\\");

           MultipartFileWriter writer = new MultipartFileWriter();

           for (MultipartFile file : files) {
               writer.writeFile(file, path);
           }
        return "Hello " + name + " " + lname ;

    }
}
