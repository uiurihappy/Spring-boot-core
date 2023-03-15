package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV3SpringMvc implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("AppInitV3SpringMvc.onStartup");


        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        // 컨테이너에 스프링 설정을 추가
        appContext.register(HelloConfig.class);

        // Spring MVC dispatcher servlet 생성, Spring Container 연결
        DispatcherServlet dispatcher = new DispatcherServlet(appContext);

        // dispatcher servlet을 servlet container에 등록 (이름 주의!)
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV3", dispatcher);

        // 모든 요청이 dispatcher servlet을 통하도록 설정
        servlet.addMapping("/");
    }
}
