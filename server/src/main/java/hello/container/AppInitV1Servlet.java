package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit{

	@Override
	public void onStartup(ServletContext servletContext) {
		System.out.println("AppInitV1Servlet.onStartup");

		// 순수 서블릿 코드 등록 (프로그래밍 방식)
		/*
		무한한 유연성을 제공한다.
		외부 설정을 읽어서 등록이 가능하다.
		 */
		ServletRegistration.Dynamic helloServlet =
				servletContext.addServlet("helloServlet", new HelloServlet());
				// .addMapping("/helloServlet"); // chain 으로도 가능
		helloServlet.addMapping("/helloServlet");

	}
}
