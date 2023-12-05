package com.fiktionmaps.fiktionmaps.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String jwt = authHeader.substring(7);

            try {
                FirebaseToken t = jwtService.verifyToken(jwt);

                if (t.getClaims().containsKey("user_id")) {
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            } catch (FirebaseAuthException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            } catch (Error e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }


}
