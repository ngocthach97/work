package com.example.traning.Web.rest;

import com.example.traning.Common.Constraints.Validation;
import com.example.traning.Service.ServiceEx.ImageServiceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/image")
public class ImageAPI {
    @Autowired
    ImageServiceEx imageServiceEx;
    @GetMapping(value = "/load/{name}")
    public ResponseEntity<Resource> readImage(@PathVariable("name") String name, HttpServletRequest request) {
        Resource resource = imageServiceEx.readImage(name);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }
        if (Validation.isNull(contentType)) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
