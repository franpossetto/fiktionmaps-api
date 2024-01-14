package com.fiktionmaps.fiktionmaps.config;

import com.fiktionmaps.fiktionmaps.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUserId(String token) throws FirebaseAuthException {
        String t = token.replace("Bearer ", "");
        FirebaseToken decodedToken = verifyToken(t);
        return decodedToken.getUid();
    }

    public FirebaseToken verifyToken(String token) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().verifyIdToken(token);

    }
}
