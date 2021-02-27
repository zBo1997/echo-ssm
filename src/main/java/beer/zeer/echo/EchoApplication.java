package beer.zeer.echo;

import beer.zeer.echo.conf.ContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class EchoApplication implements WebApplicationInitializer {
    String springSecurityFilterChain = "springSecurityFilterChain"; // securityHandlerChainName
    @Override public void onStartup(ServletContext servletContext) {
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter(springSecurityFilterChain,
                new DelegatingFilterProxy(springSecurityFilterChain));
        securityFilter.setAsyncSupported(true);
        securityFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC),
                false, "/*");

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ContextConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(ctx));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        servletContext.addListener(new ContextLoaderListener(ctx));
    }
}
