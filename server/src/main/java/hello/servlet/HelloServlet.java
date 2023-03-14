package hello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

	/** 서블릿을 등록하는 2가지 방법
	 * @WebServlet 애노테이션
	 * 프로그래밍 방식
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("HelloServlet.service");
		resp.getWriter().println("Hello servlet!");
	}
}
