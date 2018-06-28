package servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.rpc.ServiceException;

//import org.dom4j.DocumentException;

//import dao.body;
//import test.testClient;
//import test.testlogin;
//import util.Query_Map;

/**
 * Servlet implementation class Main2
 */
public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 6977402643848374753L;
	 private String message;

	  public void init() throws ServletException
	  {
	      // 鎵ц蹇呴渶鐨勫垵濮嬪寲
	      //message = "Hello World";
		  System.out.println("init.............");
	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  String message = request.getParameter("message");
	      // 璁剧疆鍝嶅簲鍐呭绫诲瀷
	      response.setContentType("text/html");

	      // 瀹為檯鐨勯�昏緫鏄湪杩欓噷
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	  }
	  


}
