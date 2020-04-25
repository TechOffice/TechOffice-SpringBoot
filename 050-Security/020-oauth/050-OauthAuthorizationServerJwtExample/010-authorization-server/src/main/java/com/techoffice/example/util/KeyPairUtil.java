package com.techoffice.example.util;

import com.techoffice.example.model.KeyPairModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Slf4j
public class KeyPairUtil {

    public static PrivateKey getPrivateKey(String privateKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyStr));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(keySpecPKCS8);
        return privateKey;
    }

    public static String encrypt(String content, String privateKeyStr) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] decryptedContentBytes = cipher.doFinal(content.getBytes());
        return new String(decryptedContentBytes);
    }

    public static String decrypt(String privateKeyStr, String encryptedContent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        Key publicKey = new RSAPublicKeyImpl(privateKeyStr.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedContentBytes = cipher.doFinal(encryptedContent.getBytes());
        String decryptedContent = new String(decryptedContentBytes);
        return decryptedContent;
    }

    public static KeyPairModel generateKeyPairModel() throws NoSuchAlgorithmException{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());

        KeyPairModel keyPairModel = new KeyPairModel();
        log.info("private key: {}", keyPairModel.getPrivateKey());
        log.info("public key: {}", keyPairModel.getPublicKey());

        String encryptedContent = encrypt("Testing Content", keyPairModel.getPrivateKey());

        return keyPairModel;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairModel keyPairModel = generateKeyPairModel();


    }

}
