package com.project.Talentix.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PassEncoder {
    // Encode (hash) a plain password
    public static String encode(String plainPassword) {
        return BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
        // 12 is the cost factor (strength), can be adjusted
    }

    // Verify a password against a hashed password
    public static boolean verify(String plainPassword, String hashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword);
        return result.verified;
    }
}
