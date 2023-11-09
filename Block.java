import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;


public class Block {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  int num;
  int amount;
  long nonce;
  Hash prevHash;
  Hash curHash;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new block from the specified parameters, performing the mining operation to discoverm
   * the nonce and hash for this block given these parameters
   */
  public Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;

    long tempNonce = -1;
    MessageDigest md = MessageDigest.getInstance("sha-256");

    do {
      tempNonce++;
      md.update(ByteBuffer.allocate(8).putInt(this.num).array());
      md.update(ByteBuffer.allocate(8).putInt(this.amount).array());
      if (prevHash != null) {
        md.update(prevHash.getData());
      }
      md.update(ByteBuffer.allocate(8).putLong(tempNonce).array());
      this.curHash = new Hash(md.digest());
      this.nonce = tempNonce;
    }  while (!(this.curHash.isValid()));

  } // Block(int newNum, int newAmount, Hash previousHash)

  /*
   * Creates a new block from the specified parameters, using the provided nonce and additional
   * parameters to generate the hash for the block. Because the nonce is provided, this constructor
   * does not need to perform the mining operation; it can compute the hash directly.
   */
  public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;

    md.update(ByteBuffer.allocate(8).putInt(this.num).array());
    md.update(ByteBuffer.allocate(8).putInt(this.amount).array());

    if (prevHash != null) {
      md.update(prevHash.getData());
    }

    md.update(ByteBuffer.allocate(8).putLong(this.nonce).array());
    this.curHash = new Hash(md.digest());

  } // Block(int num, int amount, Hash prevHash, long nonce)

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /*
   * Returns the number of this block
   */
  public int getNum() {
    return this.num;
  } // getNum()

  /*
   * Returns the amount transferred that is recorded in this block
   */
  public int getAmount() {
    return this.amount;
  } // getAmount()

  /*
   * Returns the nonce of this block
   */
  public long getNonce() {
    return this.nonce;
  } // getNonce()

  /*
   * Returns the hash of the previous block in the blockchain
   */
  public Hash getPrevHash() {
    return this.prevHash;
  } // getPrevHash

  /*
   * Returns the hash of this block
   */
  public Hash getHash() {
    return this.curHash;
  } // getHash()

  /*
   * Returns a string representation of the block
   */
  public String toString() {
    return ("Block " + this.num + " (Amount: " + this.amount + ", Nonce: " + this.nonce
        + ", prevHash: " + this.prevHash + ", hash: " + this.curHash);
  } // toString

  /*
   * Calculates a hash based off some given form of data.
   */
  public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());

    byte[] hash = md.digest();
    return hash;
  } // calculateHash(String)

} // block
