package com.techgeeknext.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomLoginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("======== In Init CustomLoginFilter filter =========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // check for valid url
        if(verifyValidURL(filterChain, httpServletRequest, httpServletResponse)) {
            //call for next filter
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        LOGGER.info("CustomLoginFilter Response Status : {}", httpServletResponse.getStatus());
    }


    @Override
    public void destroy() {
        LOGGER.info("########## Destroying CustomLoginFilter filter ##########");
    }

    private boolean verifyValidURL(FilterChain filterChain, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Requested URL : {}", request.getRequestURI());
        // we can add business logic to check  here that Requested URL have any invalid or junk code
        if(request.getRequestURI()
                .equalsIgnoreCase("/welcome")){
            return  true;
        }
        return  false;
    }
}
