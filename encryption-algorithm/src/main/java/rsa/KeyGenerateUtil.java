package rsa;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @Auther: laizc
 * @Date: 2020/7/19 01:12
 * @Description: rsa 秘钥生成工具
 */
public class KeyGenerateUtil {

    public static void main(String[] args) {
        jdkRsa();
        String aa = "123";
    }

    private static void jdkRsa(){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey =(RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey =(RSAPrivateKey) keyPair.getPrivate();
            System.out.println("publicKey: "+ Base64.encodeBase64String(rsaPublicKey.getEncoded()));
            System.out.println("privateKey: "+ Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
