package Helpers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Authentication {
  private static final Random random = new SecureRandom();
  private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int iterations = 10000;
  private static final int keylength = 256;

  // public static String encrypt(String str) {
  // String salt = getSalt(30);
  // }

  private static String getSalt(int length) {
    StringBuilder salt = new StringBuilder(length);
    for (int i = 0; i < length; i++)
      salt.append(characters.charAt(random.nextInt(characters.length())));

    return new String(salt);
  }

  private static byte[] hash(char[] str, byte[] salt) {
    PBEKeySpec spec = new PBEKeySpec(str, salt, iterations, keylength);
    Arrays.fill(str, Character.MIN_VALUE);
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      return skf.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new AssertionError("Error while hashing a string: " + e.getMessage(), e);
    } finally {
      spec.clearPassword();
    }

  }

  private static String getEncryptedString(String str, String salt) {
    byte[] secure = hash(str.toCharArray(), salt.getBytes());
    String encrypted = Base64.getEncoder().encodeToString(secure);
    return encrypted;
  }

  public static boolean verify(String normal, String secured, String salt) {
    return getEncryptedString(normal, salt).compareTo(secured) == 0;
  }
}
