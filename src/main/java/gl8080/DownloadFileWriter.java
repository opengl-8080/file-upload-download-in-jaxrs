package gl8080;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

public class DownloadFileWriter implements Closeable {
    
    private final HttpServletResponse response;
    private BufferedWriter writer;
    private String fileName;
    private String charset = "Shift_JIS";
    private String lineSeparator = "\r\n";

    public DownloadFileWriter(HttpServletResponse response) {
        this(response, null);
    }

    public DownloadFileWriter(HttpServletResponse response, String fileName) {
        if (response == null) throw new NullPointerException("response is null.");
        
        this.response = response;
        this.fileName = fileName;
    }

    public void println(Object object) throws IOException {
        this.print(object + this.lineSeparator);
    }
    
    public void print(Object object) throws IOException {
        if (this.writer == null) {
            this.setup();
        }
        this.writer.write(object + "");
    }

    private void setup() throws IOException {
        if (this.fileName == null || this.fileName.isEmpty()) {
            throw new IllegalStateException("file name is empty.");
        }
        
        this.response.setStatus(Status.OK.getStatusCode());
        this.response.setContentType("application/octet-stream");
        this.response.setHeader("Content-Disposition", "attachment;filename=" + this.fileName);
        this.writer = new BufferedWriter(new OutputStreamWriter(this.response.getOutputStream(), this.charset));
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void close() {
        if (this.writer != null) {
            try {
                this.writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
