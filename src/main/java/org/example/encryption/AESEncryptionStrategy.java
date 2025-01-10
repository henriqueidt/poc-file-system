package org.example.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptionStrategy implements EncryptionStrategy {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "HENRIQUEHENRIQUE";

    private SecretKey getKey() {
        return new SecretKeySpec(KEY.getBytes(), ALGORITHM);
    }

    @Override
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getKey());
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    public String decrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getKey());
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }
}
