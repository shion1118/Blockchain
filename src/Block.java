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
}
