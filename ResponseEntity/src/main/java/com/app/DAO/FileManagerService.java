package com.app.DAO;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class FileManagerService {
	
	@Autowired
	ServletContext app;
	private Path getPath(String folder,String filename) {
		File dir = Paths.get(app.getRealPath("/files/"),folder).toFile();
		if(!dir.exists()){
			//neu chua ton tai thi tao ra thu muc files
			dir.mkdir();
		}
		return Paths.get(dir.getAbsolutePath(), filename);
	
	}
	public byte[] read(String folder,String filename) {
		
	}
	public List<String> save(String folder,MultipartFile[] files){
		
	}
	public void delete(String folder, String filename) {
		
	}
	public List<String> list(String folder){
		
	}
}
