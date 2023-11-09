import java.nio.ByteBuffer;
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
    long tempNonce = -1;
    MessageDigest md = MessageDigest.getInstance("sha-256");
    

    while (!(this.curHash.isValid())){
        tempNonce++;
        md.update(ByteBuffer.allocate(8).putInt(this.num).array());
        md.update(ByteBuffer.allocate(8).putInt(this.amount).array());
        if(prevHash != null){
          md.update(prevHash.data);
        }
        md.update(ByteBuffer.allocate(8).putLong(tempNonce).array());
        this.curHash = new Hash(md.digest());
    }
  }

  public Block(int newNum, int newAmount, Hash previousHash, long newNonce) throws NoSuchAlgorithmException{
    MessageDigest md = MessageDigest.getInstance("sha-256");
    
    this.num = newNum;
    this.amount = newAmount;
    this.prevHash = previousHash;
    this.nonce = newNonce;

    md.update(ByteBuffer.allocate(8).putInt(this.num).array());
    md.update(ByteBuffer.allocate(8).putInt(this.amount).array());
    if(prevHash != null){
        md.update(prevHash.data);
    }
    md.update(ByteBuffer.allocate(8).putLong(this.nonce).array());
    this.curHash = new Hash(md.digest());


  }



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
