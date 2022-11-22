//package com.Xbrain.BackendXbrain.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private JwtTokenHelper jwtTokenHelper;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String requestToken = request.getHeader("Authorization");
//
//        System.out.println(requestToken);
//
//        String username = null;
//        String token = null;
//
//        if(request!=null && requestToken.startsWith("Bearer"))
//        {
//            token = requestToken.substring(7);
//
//            try {
//                username = this.jwtTokenHelper.getUsernameFromToken(token);
//            } catch (IllegalArgumentException e){
//                System.out.println("unable");
//            }
//        }
//
//        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
//
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//
//            if(this.jwtTokenHelper.validateToken(token, userDetails)){
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//
//    filterChain.doFilter(request,response);
//    }
//}
