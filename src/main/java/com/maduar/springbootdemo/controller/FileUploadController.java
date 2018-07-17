package com.maduar.springbootdemo.controller;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *
 * @author maduar
 * @date 22/06/2018 10:56 AM
 * @email maduar@163.com
 *
 * */
@RestController
@RequestMapping(value = "/file")
public class FileUploadController extends HttpServlet {

  @PostMapping(value="/upload")
  @ResponseBody
  public String upload(@RequestParam("file") MultipartFile file) throws ServletException, IOException {

//    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//    String result;
//    if (!isMultipart) {
//      result = "is not mutipart ";
//      return result;
//    }

    String name = "tt2";
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
            new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
        stream.write(bytes);
        stream.close();
        return "You successfully uploaded " + name + " into " + name + "-uploaded !";
      } catch (Exception e) {
        return "You failed to upload " + name + " => " + e.getMessage();
      }
    } else {
      return "You failed to upload " + name + " because the file was empty.";
    }

//    return "error";
  }

  @RequestMapping(value="/hello", method = RequestMethod.GET)
  public HttpEntity<?> sayHello() {
    return ResponseEntity.ok("hello");
  }
}
