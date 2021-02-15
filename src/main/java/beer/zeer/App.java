package beer.zeer;

import beer.zeer.conf.ContextConfig;
import beer.zeer.conf.MybatisConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.logging.Logger;

public class App implements WebApplicationInitializer {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ContextConfig.class);
        ctx.setServletContext(servletContext);
        log.info(ctx.toString() + ".register&setServletContext [" + ContextConfig.class.toString() +
                "][" + servletContext.toString() + "] [null]: completed initializing ctx");

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
        log.info(dynamic.toString() + ".addMapping&setLoadOnStartup [/][1] [null]" +
                ": completed initializing dispatcher");

        MybatisConfig.config();
        log.info(MybatisConfig.class.toString() + ".config [null] [null] : completed initializing mybatis");
    }
}
