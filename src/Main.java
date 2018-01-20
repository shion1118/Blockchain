public class Main {

    public static Blockchain blockchain;

    public static void main(String[] args) {
        blockchain = new Blockchain();
        mine();
        System.out.println(blockchain.getChain());
        System.out.println(blockchain.validChain());
    }

    public static void mine() {
        Block laskBlock = blockchain.getLastBlock();
        int lastProof = laskBlock.getProof();

        blockchain.newTransaction("0", "1", (long)1.0);
        int proof = blockchain.calculatePoW(lastProof);
        blockchain.newBlock(proof, laskBlock.hash());
    }
}