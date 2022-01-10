package com.upload.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    public boolean fileUpload(MultipartFile file) {
        UUID uid = UUID.randomUUID();
        OutputStream out = null;

        try {
            String fileName = uid + "_" + file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            File uploadFile = new File(fileName);
            out = new FileOutputStream(uploadFile);
            out.write(bytes);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          try {
              if (out!=null)
                  out.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
        }
        return false;
    }
}
