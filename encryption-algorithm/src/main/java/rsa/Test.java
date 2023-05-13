package rsa;

/**
 * @Auther: laizc
 * @Date: 2020/7/19 13:21
 * @Description:
 */
public class Test {

    private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI3NwBNv8VcOJTnYKLi5saGq4SxfkoClq9LyWWXoK94sYNWW5+GgDxKRmc01ZebzDplFQikgbp5rB/x2HrkDMvkCAwEAAQ==";
    private static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAjc3AE2/xVw4lOdgouLmxoarhLF+SgKWr0vJZZegr3ixg1Zbn4aAPEpGZzTVl5vMOmUVCKSBunmsH/HYeuQMy+QIDAQABAkAy6HLUh5O1FTb4FUpJRyEmURqVu5n05YVSLf86PqfBEtAp57jZuAKRyKz836br5dsFeSFu7uzb6nAWhE6jRd6hAiEA9r862fCWssNSxUJzxz63BFfc0p35hZmrlrbkvo3AYQsCIQCTHxC6+MYzuhoGAqd3A1Gjl8x2a2Bn5komJC6F84DGiwIhAL+CuPjCpRRmSW3VH+t7H619TGUkO7CYDvfRSEUl3DT1AiB4BOfJIBnRKQkBzjh/xp1bMAMEuCQ1npDu/KVXcYakcQIhAKW7QDuOzZfB7ic9GErfLeuDrQGF3tNJyj5pALpmlqeR";

    public static void main(String[] args) {
        String source = "123456哈哈哈";
        //私钥加密，公钥解密
        String privateKeyEncrypt = RsaUtil.privateKeyEncrypt(privateKey,source);
        System.out.println("公钥加密："+ privateKeyEncrypt);
        String publicKeyDecrypt = RsaUtil.publicKeyDecrypt(publicKey,privateKeyEncrypt);
        System.out.println("公钥解密："+ publicKeyDecrypt);

        //公钥加密私钥解密
        String publicKeyEncrypt = RsaUtil.publicKeyEncrypt(publicKey,source);
        System.out.println("私钥加密：" + publicKeyEncrypt);
        String privateKeyDecrypt =  RsaUtil.privateKeyDecrypt(privateKey,publicKeyEncrypt);
        System.out.println("私钥解密：" + privateKeyDecrypt);

        // 私钥加密  公钥解密




    }
}
