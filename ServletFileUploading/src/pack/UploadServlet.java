package pack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private final int maxFileSize = 50 * 1024;
	private File file;
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// create new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximim file size to be uploaded
		upload.setSizeMax(maxFileSize);
		try {
			// parse the request to get file item
			List fileItems = upload.parseRequest(req);
			// process the upload file items
			Iterator i = fileItems.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					String fileName = fi.getName();
					file = new File("E:\\uploadfiles\\" + fileName);
					fi.write(file);
					pw.println("<h2>Uploaded file name: " + fileName
							+ "</h2><br>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
