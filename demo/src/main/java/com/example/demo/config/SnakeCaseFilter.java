package com.example.demo.config;

import com.google.common.base.CaseFormat;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SnakeCaseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final Map<String, String[]> formattedParams = new ConcurrentHashMap<>();

        //Convert values for each parameter
        for (String param : request.getParameterMap().keySet()) {
            String[] values = request.getParameterValues(param);

            String formattedParam = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, param);

            formattedParams.put(formattedParam, values);
        }

        filterChain.doFilter(new CustomResponseWrapper(request, formattedParams), response);

    }


    /**
     * Wrapper return new formatted parameters
     */
    class CustomResponseWrapper extends HttpServletRequestWrapper {

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */

        private Map<String, String[]> params;

        public CustomResponseWrapper(HttpServletRequest request, Map<String, String[]> params) {
            super(request);
            this.params = params;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return params;
        }

        @Override
        public String[] getParameterValues(String name) {
            return params.get(name);
        }

    }
}