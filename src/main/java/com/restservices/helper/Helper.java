package com.restservices.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class Helper {

	public static boolean uploadImage(MultipartFile file) {
		
		boolean f = false;
		
		try {
			InputStream is = file.getInputStream();
			File path = new File("C:\\Users\\imash\\eclipse-workspace\\RestApi\\src\\main\\resources\\static\\UploadImage"
					+ File.separator+file.getOriginalFilename());
			FileOutputStream os = new FileOutputStream(path);
			byte [] arr = new byte[is.available()];
			is.read(arr);
			
			os.write(arr);
			os.flush();
			os.close();
			f = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
}
