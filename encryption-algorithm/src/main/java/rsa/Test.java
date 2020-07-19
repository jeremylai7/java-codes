package rsa;

/**
 * @Auther: laizc
 * @Date: 2020/7/19 13:21
 * @Description:
 */
public class Test {

    private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK9yIG711y8nxP4Cgdov0746tnTKzoB6pV/FwwzI/xs+pj3XmQkrJdVLLrUQYqUsoQ7W3/00LKzbaZ4lT9HxqkECAwEAAQ==";

    private static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAr3IgbvXXLyfE/gKB2i/Tvjq2dMrOgHqlX8XDDMj/Gz6mPdeZCSsl1UsutRBipSyhDtbf/TQsrNtpniVP0fGqQQIDAQABAkByclFD8Kx5P0kapYoNSUun+ObSkwVX/ClqqzfMXEVFgGbx0SduGOZkViahFxJjr2Lj3pcoIA3pMfQPoh8HY1itAiEA8NEO6KCXtw1S0XuLXgTDFeEHAFMRCetRLcREAvpNSxMCIQC6gfCFWJp+74+HklBa9BSLUjYPwdroBEFCr6Hq33jr2wIhAL+7g2Y9rm2FAyJcffruSbDayCs+97rxC2In+IpyZSXXAiA+2md6KL/4IzeVkqNt42/A+/WoHcZuBnEPziydAK65nQIhAJQZLupv83exZ9G3FmeHzQwHTIp6QZy/XiYKMPfMNnZo";

    public static void main(String[] args) {
        String source = "laizc3333";
        //私钥加密，公钥解密
        /*String privateKeyEncrypt = RsaUtil.privateKeyEncrypt(privateKey,source);
        String publicKeyDecrypt = RsaUtil.publicKeyDecrypt(publicKey,privateKeyEncrypt);*/
        //公钥加密私钥解密
        String publicKeyEncrypt = RsaUtil.publicKeyEncrypt(publicKey,source);
        String privateKeyDecrypt =  RsaUtil.privateKeyDecrypt(privateKey,publicKeyEncrypt);
        System.out.println(privateKeyDecrypt);



    }
}
