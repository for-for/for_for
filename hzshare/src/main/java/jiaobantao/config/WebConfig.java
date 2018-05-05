package jiaobantao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/***
 *      ???????????????????? <mvc: -driven />
        Just as there are several ways of configuring DispatcherServlet, there’s more than
        one way to enable Spring MVC components. Historically, Spring has been configured
        using XML, and there’s an <mvc:annotation-driven> element that you can use to
        enable annotation-driven Spring MVC.
        We’ll talk about <mvc:annotation-driven>, among other Spring MVC configuration
        options, in chapter 7. But for now, you’ll keep your Spring MVC setup simple and
        Java-based.
        The very simplest Spring MVC configuration you can create is a class annotated
        with @EnableWebMvc:
 */
@Configuration
@EnableWebMvc

@ComponentScan("jiaobantao")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * look for JSP files by wrapping view names with a specific prefix and suffix
     * for example, a view name of "home" will be resolved as /WEB/INF/views/home.jsp
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * By calling enable() on the given DefaultServletHandlerConfigurer, you'are asking DispatcherServlet
     * to faward requests for static resources to the servlet container's default servlet and not
     * to try to handler them itself.
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
