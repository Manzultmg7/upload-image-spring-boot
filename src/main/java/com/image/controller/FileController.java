package com.image.controller;

import com.image.payload.FileResponse;
import com.image.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @Value("${project.image}")
    private  String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(
            @RequestParam("image")MultipartFile image
            ) throws IOException {
        String filename=this.fileService.uploadImage(path,image);
        return new ResponseEntity<>(new FileResponse(filename,"image is successfully uploaded"), HttpStatus.OK);
    }
}
