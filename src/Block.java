import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;


public class Block {
  int num;
  int amount;
  long nonce;
  Hash prevHash;
  Hash curHash;




  public Block(int newNum, int newAmount, Hash previousHash)throws NoSuchAlgorithmException{
    MessageDigest md = MessageDigest.getInstance("sha-256");
  }



public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
  MessageDigest md = MessageDigest.getInstance("sha-256");
  md.update(msg.getBytes());
  
} // calculateHash(String)


  public int getNum() {
    return this.num;
  }

  public int getAmount() {
    return this.amount;
  }

  public long getNonce() {
    return this.nonce;
  }

  public Hash getPrevHash() {
    return this.prevHash;
  }

  public Hash getHash() {
    return this.curHash;
  }

  public String toString() {
    return ("Block " + this.num + " (Amount: " + this.amount + ", Nonce: " + this.nonce
        + ", prevHash: " + this.prevHash + ", hash" + this.curHash);
  }
}
