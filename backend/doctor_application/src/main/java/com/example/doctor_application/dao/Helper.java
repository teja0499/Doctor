////package com.example.doctor_application.dao;
////
////import java.io.File;
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.nio.file.StandardCopyOption;
////
////import org.springframework.core.io.ClassPathResource;
////import org.springframework.stereotype.Component;
////import org.springframework.web.multipart.MultipartFile;
////import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
////
////@Component 
////public class Helper {
////
//////	 private final String uploadDir="C:\\Users\\dell\\Downloads\\doctor_application\\src\\main\\resources\\static\\image";
////	 private final String uploadDir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
////
////	 public Helper() throws IOException {
////		 File directory = new File(uploadDir.toString());
////       if (!directory.exists()) {
////           directory.mkdirs();
////       }
////	 }
////	 
////	 
//////    private final Path uploadDir;
//////
//////    public Helper() throws IOException {
//////        // Resolve the path to the static folder
//////        String resourcePath = "src/main/resources/static/image";
//////        this.uploadDir = Paths.get(resourcePath).toAbsolutePath().normalize();
//////
//////        // Create the directory if it doesn't exist
//////        File directory = new File(uploadDir.toString());
//////        if (!directory.exists()) {
//////            directory.mkdirs();
//////        }
//////    }
//////
////    public String uploadFile(MultipartFile file, String number) {
////        try {
//////            // Generate the new filename based on the number
////        	  File directory = new File(uploadDir.toString());
////            if (!directory.exists()) {
////                directory.mkdirs();
////            }
////            String fileExtension = "";
////            String originalFilename = file.getOriginalFilename();
////            if (originalFilename != null && originalFilename.contains(".")) {
////                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
////            }
////            String newFilename = number + fileExtension;
////
////            Files.copy(file.getInputStream(),Paths.get(uploadDir+File.separator+newFilename) , StandardCopyOption.REPLACE_EXISTING);
////            
////            String path=ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(newFilename).toUriString();
////
////            return path;
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return "";
////    }
////}
//
//package com.example.doctor_application.dao;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//@Component
//public class Helper {
//
//    @Value("${file.upload-dir:/opt/doctor-application/uploads}") // External directory path
//    private String uploadDir;
//
//    public Helper() throws IOException {
//        // Create the directory if it doesn't exist
//        File directory = new File(uploadDir);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//    }
//
//    public String uploadFile(MultipartFile file, String number) {
//        try {
//            // Ensure the upload directory exists
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Determine the file extension
//            String fileExtension = "";
//            String originalFilename = file.getOriginalFilename();
//            if (originalFilename != null && originalFilename.contains(".")) {
//                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//            }
//            String newFilename = number + fileExtension;
//
//            // Copy the file to the upload directory
//            Path targetLocation = Paths.get(uploadDir).resolve(newFilename);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//            // Return the URI to access the file
//            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/uploads/")
//                .path(newFilename)
//                .toUriString();
//
//            return path;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//}
//
