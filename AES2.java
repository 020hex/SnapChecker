package javaapplication4;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



    class AES2 {
      private static final String ALGO = "AES";
      private byte[] KeyValue;
    
      public  AES(String key){
         KeyValue = key.getBytes();
      }
    
    public String encrypt(String Data) throws Exception{
           Key key = generateKey();
           Cipher c = Cipher.getInstance(ALGO);
           c.init(Cipher.ENCRYPT_MODE, key);
           byte[] encVal = c.doFinal(Data.getBytes());
           String encryptedValue = new BASE64Encoder().encode(encVal);
           return encryptedValue;
    }
    
    public String decrypt(String encryptedData) throws Exception{
           Key key = generateKey();
           Cipher c = Cipher.getInstance(ALGO);
           c.init(Cipher.DECRYPT_MODE, key);
           byte [] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
           byte[] decValue = c.doFinal(decordedValue);
           String decryptedValue = new String(decValue);
           return decryptedValue;
    }
    
    private Key generateKey() throws Exception{
           Key key = new SecretKeySpec(KeyValue, ALGO);
           return key;
    }
    public static void main(String[] args)  {
            try {
                AES2 aes = new AES("1234567890123456"); // in AES the password have to be 16 char
                String x = aes.encrypt("Hi I'm hEx");
                System.out.println(x);
                String y = aes.decrypt("sH+3VLKKjrgoTIxnn6aQUQ==");
                System.out.println(y);
                
        } catch (Exception e) {
            System.out.println("Error in main class ");
        }
    }
 
}