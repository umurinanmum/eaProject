package mum.ea.utilities;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	
    public String fileNameUploaded(HttpSession session,MultipartFile  file) {
    	
    
   	 if (file.isEmpty()) {

            return null;
        }
   	 
   	 String fileName=file.getOriginalFilename();
   	 
   
   	 try {
   		 byte barr[]=file.getBytes();
   		 BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(getPath(session)+fileName));
   		 bout.write(barr);
   		 bout.flush();
   		 bout.close();
//   		 Path fullPath=Paths.get(path+fileName);
//   		 
//   		 Files.write(fullPath,barr);
   		 
   		
   	     
   	 }
   	 catch(Exception e) {
   		 System.out.println(e);
   	 }
   	 
   	return fileName;
    
   	 
    }
    
    
    public String getPath(HttpSession session) {
    	String path=session.getServletContext().getRealPath("/WEB-INF/images/");
    	return path;
    }

}
