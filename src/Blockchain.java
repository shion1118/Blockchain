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
    }
}
