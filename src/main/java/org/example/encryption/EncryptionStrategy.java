package org.example.encryption;

public interface EncryptionStrategy {
    String encrypt(String data);
    String decrypt(String data);
}
