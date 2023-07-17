package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.config;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.AdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.TokenAdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.JwtTokenUtil;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AdminRepository userRepository;
    private final JwtTokenUtil jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenAdminRepository tokenRepository;

    @Override
    protected void doFilterInternal(@NonNull  HttpServletRequest request,@NonNull  HttpServletResponse response,@NonNull  FilterChain filterChain) throws ServletException, IOException {
        final var token = request.getParameter("token");
        String jwt = token;
        String userPhone = null;
        if (token == null){
            filterChain.doFilter(request,response);
            return;
        }

        try {
            System.out.println(token);
            userPhone = jwtService.getEmailFromToken(token);
        }catch(Exception e){
            e.printStackTrace();
            filterChain.doFilter(request,response);
            return;
        }

        if(userPhone!=null){
            TokenAdmin authToken = tokenRepository.getTokenAdminByToken(token);
            if (authToken == null){
                filterChain.doFilter(request,response);
                return;
            }
        }

        if (userPhone != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userPhone);
            if (jwtService.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request
                ));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }

        }
        filterChain.doFilter(request,response);


    }
}