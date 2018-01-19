import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by shion on 2018/01/15.
 */
public class Block {

    private int index;
    private long timeStamp;
    private ArrayList<Transaction> transactions;
    private int proof;
    private String previousHash;

    public Block(int index, long timeStamp, ArrayList<Transaction> transactions, int proof, String previousHash) {
        this.index = index;
        this.timeStamp = timeStamp;
        this.transactions = transactions;
        this.proof = proof;
        this.previousHash = previousHash;
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
