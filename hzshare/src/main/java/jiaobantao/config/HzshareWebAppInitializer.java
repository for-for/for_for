package jiaobantao.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
    configure DispatcherServlet

    Any class that extends AbstractAnnotationConfigDispatcherServletInitializer will automatically
    be used to configure DispatcherServlet and the Spring application context in the applicaton's
    servlet context.
 */


public class HzshareWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
        DispatcherServlet: Spring application context (beans)
        ContextLoaderListener
     */

    /**
     * let ContextLoaderListener load the other beans(containing middle-tier and data-tier components
     * that drive the back end of the application)
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    /**
     * let DispatcherServlet load its application context with beans(containing web components such as
     * controllers, view resolvers, and hander mappings) defined in the WebConfig configuration class
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    // identify paths that DispatcherServlet will be mapped to.
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
