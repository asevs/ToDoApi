//package pl.asev.todoapi.configuration;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Collections;
//
//public class JWTConfiguration {
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new JWTFilter());
//        filterRegistrationBean.setUrlPatterns(Collections.singleton("/"));
//        return filterRegistrationBean;
//    }
//}
