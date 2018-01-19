import java.util.ArrayList;

/**
 * Created by shion on 2018/01/18.
 */
public class Blockchain {

    private ArrayList<Transaction> transactions;
    private ArrayList<Block> chain;

    public Blockchain() {
        transactions = new ArrayList<>();
        chain = new ArrayList<>();

        newBlock(100, "1");
    }

    public void newBlock(int proof, String previousHash) {
        Block block = new Block(chain.size() + 1, System.currentTimeMillis(), transactions, proof, previousHash);
        chain.add(block);
        transactions.clear();
    }
}
