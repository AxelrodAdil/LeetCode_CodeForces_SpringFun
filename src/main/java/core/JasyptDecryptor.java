package core;

import org.jasypt.util.text.BasicTextEncryptor;

import java.util.HashMap;
import java.util.Map;

public class JasyptDecryptor {

    private static final Object LOCK = new Object();
    private static final Map<String, BasicTextEncryptor> DECRYPTOR_MAP = new HashMap<>();


//    public static void main(String[] args) {
//        String jasyptCode = "text";
//        String password = "key";
//
//        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
//        decryptor.setAlgorithm("PBEWithMD5AndTripleDES");
//        decryptor.setPassword(password);
//
//        try {
//            String plaintext = decryptor.decrypt(jasyptCode);
//            System.out.println(plaintext);
//        } catch (EncryptionOperationNotPossibleException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//    }

//    public static void main(String[] args) {
//        String jasyptCode = "text";
//        String password = "key";
//        StrongTextEncryptor strongDecryptor = new StrongTextEncryptor();
//        strongDecryptor.setPassword(password);
//        try {
//            String plaintext = strongDecryptor.decrypt(jasyptCode);
//            System.out.println(plaintext);
//        } catch (Exception ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//    }

    public static String decrypt(String encryptedText, String passEnv) {
        BasicTextEncryptor decryptor;
        synchronized (LOCK) {
            decryptor = DECRYPTOR_MAP.get(passEnv);
            if (decryptor == null) {
                decryptor = new BasicTextEncryptor();
                String pass = System.getenv(passEnv);
                if (pass == null || pass.isBlank()) {
                    throw new RuntimeException("No environment variable provided: " + passEnv);
                }
                decryptor.setPassword(pass);
                DECRYPTOR_MAP.put(passEnv, decryptor);
            }
        }
        return decryptor.decrypt(encryptedText);
    }

    public static void main(String[] args) {
        System.out.println(decrypt("text", "key"));
    }
}
