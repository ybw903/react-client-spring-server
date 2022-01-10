package com.upload.server.controller;

import com.upload.server.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload/file")
    public ResponseEntity fileUpload(@RequestPart MultipartFile file) {
        if (fileService.fileUpload(file))
            return ResponseEntity.status(200).build();
        return ResponseEntity.status(500).build();
    }
}
