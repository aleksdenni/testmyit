package net.testmyit.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CorsHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        if (handleCors(request, response, true)) {
            return;
        }
        chain.doFilter(request, response);
        handleCors(request, response, false);
    }

    private boolean handleCors(
            HttpServletRequest request, HttpServletResponse response, boolean options) {
        response.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeader(HttpHeaders.ORIGIN));
        response.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.joining(",")));
        response.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                "accept,content-type,content-length,authorization");
        response.setHeader(
                HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,
                "accept,content-type,content-length,authorization");
        response.setStatus(HttpStatus.OK.value());
        return options && request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name());
    }

}
