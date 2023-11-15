import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class Encrypt {
    public String stringToEncrypt(String passwordToEncrypt){
        String encryptedPassword = null;
        try {
            /* MessageDigest instance for MD5. */
            MessageDigest encryptMethod = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            encryptMethod.update(passwordToEncrypt.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = encryptMethod.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder stringToBuild = new StringBuilder();
            for(int i=0; i < bytes.length ;i++)
            {
                stringToBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedPassword = stringToBuild.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}
