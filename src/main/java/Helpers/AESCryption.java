package Helpers;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
public class AESCryption {
    public static String encode(String stringToEncode, String Key, String IV) throws NullPointerException {
        try {/*  w w  w . ja va2  s  . co  m*/
            SecretKeySpec skeySpec = getKey(Key);
            byte[] clearText = stringToEncode.getBytes("utf-8");
            Cipher cipher;
            if (null != IV) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
                cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            } else {
                cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            }
            //  String encrypedValue = Base64.encodeToString(cipher.doFinal(clearText), Base64.DEFAULT);
            String encrypedValue = Base64.getEncoder().encodeToString(cipher.doFinal(clearText));
            return encrypedValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static SecretKeySpec getKey(String Key) throws UnsupportedEncodingException {
        int keyLength = 256;
        byte[] keyBytes = new byte[keyLength / 8];
        Arrays.fill(keyBytes, (byte) 0x0);
        byte[] passwordBytes = Key.getBytes("UTF-8");
        int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
        System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
    public static String Decrypt(String stringToEncode, String Key, String IV) throws Exception {
        try {/*from www  .  ja v  a 2s. c  o  m*/
            if (Key == null) {
                return null;
            }
          //  byte[] clearText = stringToEncode.getBytes("utf-8");
          //  String encoded = Base64.getEncoder().encodeToString(clearText);
            Cipher cipher;
            // byte[] encrypted1 = Base64.decode(stringToEncode, 0);
            byte[] encrypted1 = Base64.getDecoder().decode(stringToEncode);
            if (null != IV) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
                SecretKeySpec skeySpec = getKey2(Key);
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            } else {
                byte[] raw = Key.getBytes("utf-8");
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            }
            byte[] ret = cipher.doFinal(encrypted1);
            return new String(ret, "utf-8");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    private static SecretKeySpec getKey2(String Key) throws UnsupportedEncodingException {
        int keyLength = 256;
        byte[] keyBytes = new byte[keyLength / 8];
        Arrays.fill(keyBytes, (byte) 0x0);
        byte[] passwordBytes = Key.getBytes("UTF-8");
        int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
        System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
}
