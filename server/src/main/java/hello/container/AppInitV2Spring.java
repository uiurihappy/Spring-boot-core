package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {
	@Override
	public void onStartup(ServletContext servletContext) {
		System.out.println("AppInitV2Spring.onStartup");

		// Spring container 생성
		// AnnotationConfigWebApplicationContext = 애노테이션 기반 설정과 웹 기능을 지원하는 스프링 컨테이너로 이해
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		// 컨테이너에 스프링 설정을 추가
		appContext.register(HelloConfig.class);

		// Spring MVC dispatcher servlet 생성, Spring Container 연결
		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		// dispatcher servlet을 servlet container에 등록 (이름 주의!)
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcher);

		// mapping, /spring/* 요청이 dispatcher servlet을 통하도록 설정
		servlet.addMapping("/spring/*");

	}
	/*
	  /spring/hello-spring
	  실행을 /spring/* 패턴으로 호출했기 때문에 다음과 같이 동작한다.
	  dispatcherV2 디스패처 서블릿이 실행된다. ( /spring )
	  dispatcherV2 디스패처 서블릿은 스프링 컨트롤러를 찾아서 실행한다. ( /hello-spring )
	  이 때 서블릿을 찾아서 호출하는데 사용된 /spring 을 제외한 /hello-spring 가 매핑된 컨트롤러 HelloController )의 메서드를 찾아서 실행한다.
	  (쉽게 이야기해서 뒤에 * 부분으로 스프링 컨트롤러를 찾는다.)
	 */

}
