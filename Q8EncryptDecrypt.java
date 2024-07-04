package JavaExercises;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class Q8EncryptDecrypt {
    public static void main (String[] args){
        if (args.length < 3) {
            System.err.println("Argument format: <key> <operation> <text>");
            return;
        }

        String keyStr = args[0];
        String operation = args[1].toLowerCase();
        String text = args[2];

        try {
            SecretKey secretKey = generateKey(keyStr);

            if (operation.equals("encrypt")) {
                String encryptedText = encrypt(text, secretKey);
                System.out.println("Encrypted Text: " + encryptedText);
            } else if (operation.equals("decrypt")) {
                String decryptedText = decrypt(text, secretKey);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.err.println("Invalid operation. Use 'encrypt' or 'decrypt'.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static SecretKey generateKey(String keyStr) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(keyStr.getBytes("UTF-8"));
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static String encrypt (String text, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decrypt (String text, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
        return new String(decryptedBytes);
    }
}
