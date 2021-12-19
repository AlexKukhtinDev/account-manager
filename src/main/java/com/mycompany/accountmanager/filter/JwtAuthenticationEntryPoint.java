package com.mycompany.accountmanager.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.accountmanager.constant.SecurityConstant;
import com.mycompany.accountmanager.domain.HttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authenticationException) throws IOException {
        HttpResponse httpResponse = HttpResponse
                .builder()
                .httpStatus(FORBIDDEN)
                .httpStatusCode(FORBIDDEN.value())
                .reason(FORBIDDEN.getReasonPhrase())
                .message(SecurityConstant.FORBIDDEN_MESSAGE)
                .path(request.getContextPath())
                .build();

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(FORBIDDEN.value());

        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, httpResponse);
        outputStream.flush();
    }
}