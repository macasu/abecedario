package abecedario;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import abecedario.config.SitemeshFilter;
import abecedario.config.SpringWebConfig;

public class Application implements WebApplicationInitializer{
 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("abecedario.config");
		webApplicationContext.register(SpringWebConfig.class);
		
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
		
		addSitemeshFilterToServletContext(servletContext);
		registerDispatcherServlet(servletContext);
		
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
	}
 
    private void addSitemeshFilterToServletContext(ServletContext servletContext) {
        FilterRegistration.Dynamic sitemesh = servletContext.addFilter("sitemesh", new SitemeshFilter());
        EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        sitemesh.addMappingForUrlPatterns(sitemeshDispatcherTypes, true, "/*");
    }
 
    private void registerDispatcherServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(
                new AnnotationConfigWebApplicationContext()));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
