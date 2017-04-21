package ru.dbd.configuraions;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by vorh on 4/12/17.
 */
public class MvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        String prod = System.getProperty("prod");
        if (prod ==null){
            servletContext.setInitParameter("spring.profiles.active","dev");
        }else {
            servletContext.setInitParameter("spring.profiles.active","prod");
        }
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConf.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

