package com.techgeeknext.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomValidationFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomValidationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("======== In Init CustomValidationsFilter filter =========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        LOGGER.info("CustomValidationsFilter Request Details  {} : {}",
                httpServletRequest.getAuthType(), httpServletRequest.getRequestURI());


        // you can also check for auth type
       /* if(httpServletRequest.getAuthType()!=null){
        .....
        ....
        }*/

        //check for validation
        if (httpServletRequest.getRequestURI().equalsIgnoreCase("/welcome")) {

        //initiate next filter
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

        LOGGER.info("CustomValidationsFilter Response Status : {}", httpServletResponse.getStatus());
    }

    @Override
    public void destroy() {
        LOGGER.info("======= Destroy CustomValidationsFilter =========");
    }
}
