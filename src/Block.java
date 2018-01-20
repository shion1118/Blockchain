import com.google.gson.Gson;

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

    public String hash() {
        return Utils.applySHA256(this.toString());
    }
}
