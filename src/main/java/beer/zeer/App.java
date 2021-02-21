package beer.zeer;

import beer.zeer.conf.ContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.logging.Logger;

public class App implements WebApplicationInitializer {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void onStartup(ServletContext servletContext) {

        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
        logger.info(String.format("[%s] [%s] [%s] \n", "tomcat config", servletContext, "ok"));

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain"));
        securityFilter.setAsyncSupported(true);
        securityFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC),
                false, "/*");
        logger.info(String.format("[%s] [%s] [%s] \n", "security filter", securityFilter, "loaded"));

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ContextConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
        logger.info(String.format("[%s] [%s] [%s] \n", "dispatcher servlet", dispatcherServlet, "loaded"));
    }
}
