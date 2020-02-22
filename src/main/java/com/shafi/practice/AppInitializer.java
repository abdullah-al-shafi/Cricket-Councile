package com.shafi.practice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class AppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletCxt) {


		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		rootContext.refresh();

		servletCxt.addListener(new ContextLoaderListener(rootContext));

//		servletCxt.setInitParameter("spring.profiles.active", "dev");

		// Create and register the DispatcherServlet
		AnnotationConfigWebApplicationContext servletRegisterer = new AnnotationConfigWebApplicationContext();
		servletRegisterer.register(ServletConfig.class);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("servlet",
				new DispatcherServlet(servletRegisterer));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
		

}
