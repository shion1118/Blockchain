import java.util.ArrayList;

/**
 * Created by shion on 2018/01/18.
 */
public class Blockchain {

    private int difficulty = 1;
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

    public void newTransaction(String sender, String recipient, long amount) {
        transactions.add(new Transaction(sender, recipient, amount));
    }

    public Block getLastBlock() {
        return chain.get(chain.size() - 1);
    }

    public int calculatePoW(int previousProof) {
        int proof = 0;
        while(!validProof(previousProof, proof)) {
            proof += 1;
        }
        return proof;
    }

    public boolean validProof(int previousProof, int proof) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        String guess = Utils.applySHA256(String.valueOf(previousProof * proof));
        return guess.substring(0, difficulty).equals(target);
    }

    public boolean validChain() {
        Block previousBlock, currentBlock;
        for (int i = 1; i < chain.size(); i++) {
            previousBlock = chain.get(i-1);
            currentBlock = chain.get(i);

            if (!currentBlock.getPreviousHash().equals(previousBlock.hash())) {
                return false;
            }

            if (!validProof(previousBlock.getProof(), currentBlock.getProof())) {
                return false;
            }
        }
        return true;
    }

}