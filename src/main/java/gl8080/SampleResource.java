package gl8080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/sample")
public class SampleResource {
    
    private static final Logger logger = LoggerFactory.getLogger(SampleResource.class);
    
    @GET
    public String hello() {
        return "hello world";
    }
    
    @POST
    public void file(@Context HttpServletRequest request) {
        
        FileUploadHelper helper = new FileUploadHelper();
        
        
        
        System.out.println("file upload");
        
        ServletFileUpload upload = new ServletFileUpload();
        try {
            FileItemIterator itemIterator = upload.getItemIterator(request);
            while (itemIterator.hasNext()) {
                FileItemStream stream = itemIterator.next();
                logger.info("fieldName = {}", stream.getFieldName());
                
                try (BufferedReader br = new BufferedReader(new InputStreamReader(stream.openStream(), Charset.forName("MS932")))) {
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\r\n");
                    }
                    
                    logger.info("content = {}", sb.toString());
                }
            }
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        }
    }
}
