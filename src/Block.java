import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shion on 2018/01/15.
 */
public class Block {

    private String hash;
    private String previousHash;
    private long timeStamp;

    public Block(String previousHash, long timeStamp) {
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return new Gson().toJson(this).toString();
    }

    public static String hash(Block block) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(block.toString().getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
