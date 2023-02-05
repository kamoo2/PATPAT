package com.ssafy.patpat.common.service;

import com.ssafy.patpat.common.entity.Image;
import com.ssafy.patpat.common.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ImageRepository imageRepository;

    @Value("${app.fileupload.uploadPath}")
    String uploadPath;

    @Value("${app.fileupload.uploadDir}")
    String uploadFolder;

    @Value("${app.filecall.url}")
    String callUrl;

    @Transactional
    public Image insertFile(MultipartFile uploadFile) throws Exception {
        File uploadDir = new File(uploadPath + File.separator + uploadFolder);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String fileName = uploadFile.getOriginalFilename();

        UUID uuid = UUID.randomUUID();

        String extension = FilenameUtils.getExtension(fileName);

        String savingFileName = uuid + "." + extension;

//                    File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

        String FilePath = uploadPath + File.separator + uploadFolder + File.separator + savingFileName;
        Path path = Paths.get(FilePath).toAbsolutePath();

        uploadFile.transferTo(path.toFile());

        Image image = Image.builder()
                .origFilename(fileName)
                .fileSize((int) uploadFile.getSize())
                .filename(fileName)
                .filePath(uploadFolder + "/" + savingFileName)
                .build();

        imageRepository.save(image);
        return image;
    }

    @Transactional
    public Image insertFileUrl(String url, String provider) {
        Image image = Image.builder()
                .origFilename(provider)
                .filename(provider)
                .filePath(url)
                .build();
        imageRepository.save(image);
        return image;
    }

    @Transactional
    public String getFileUrl(Image image){
        String fileName = image.getFilename();
        if(!fileName.equals("kakao") && !fileName.equals("naver") && !fileName.equals("google")){
            return callUrl+File.separator+image.getFilePath();
        }else{
            return image.getFilePath();
        }
    }

    @Transactional
    public boolean deleteFile(Image image){

        String fileName = image.getFilename();
        if(!fileName.equals("kakao") && !fileName.equals("naver") && !fileName.equals("google")){
            File file = new File(uploadPath + File.separator + image.getFilePath()); // fileUrl은 upload/...형태
            if(file.exists()) file.delete();
        }

        imageRepository.delete(image);
        return true;
    }

}