package com.movieflix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movieflix.service.FileService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/file/")
public class FileController {
		
	private final FileService fileService;

	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@Value("${project.poster}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFileHandler(@RequestBody MultipartFile file) throws IOException {
		String uploadedFileName = fileService.uplodFile(path, file);
		
		return ResponseEntity.ok("File Uploaded : "+uploadedFileName);
	}
	
	@GetMapping("/{fileName}")
	public void serverFileHandaler(@PathVariable String fileName , HttpServletResponse response ) throws IOException,FileNotFoundException {
		
		InputStream resourceFile = fileService.getResourceFile(path,fileName);
		response.setContentType(MediaType.IMAGE_PNG_VALUE);
		org.springframework.util.StreamUtils.copy(resourceFile, response.getOutputStream());
		
	}
	
	
}
