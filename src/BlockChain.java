import java.security.NoSuchAlgorithmException;

public class BlockChain {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The initial value
   */
  int initial;

  /*
   * The BlockChain that will be used in the contructor
   */
  Block curBlock;

  /*
   * The dummy node at the front of the list
   */
  Node front;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a BlockChain that possess a single block the starts with the given initial amount. Note
   * that to create this block, the prevHash field should be ignored when calculating the block’s
   * own nonce and hash
   */
  public BlockChain(int initial) throws NoSuchAlgorithmException {
    Block curBlock = new Block(0, initial, null);

    this.front = new Node(null, null);
    this.front.data = curBlock;
  } // BlockChain(int initial)

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /*
   * mines a new candidate block to be added to the end of the chain. The returned Block should be
   * valid to add onto this chain.
   */
  Block mine(int amount) throws NoSuchAlgorithmException {
    // STUB
    byte[] temp = new byte[10];
    Hash temp2 = new Hash(temp);
    Block result = new Block(0, 0, temp2);
    return result;
  } // mine(int amount)

  /*
   * Returns the size of the blockchain. Note that number of the blocks provides a convenient method
   * for quickly determining the size of the chain.
   */
  public int getSize() {
    return this.curBlock.getNum() + 1;
  } // getSize()

  /*
   * Adds this block to the list, throwing an IllegalArgumentException if this block cannot be added
   * to the chain (because it is invalid wrt the rest of the blocks).
   */
  public void append(Block blk) throws IllegalArgumentException {
    // STUB
  } // append(Block blk)

  /*
   * Removes the last block from the chain, returning true. If the chain only contains a single
   * block, then removeLast does nothing and returns false.
   */
  public boolean removeLast() {
    // STUB
    return false;
  } // removeLast()

  /*
   * Returns the hash of the last block in the chain
   */
  public Hash getHash() {
    // STUB
    byte[] temp = new byte[10];
    return new Hash(temp);
  } // getHash()

  /*
   * Walks the blockchain and ensures that its blocks are consistent and valid
   */
  public boolean isValidBlockChain() {
    // STUB
    return false;
  } // isValidBlockChain()

  /*
   * Prints the balances.
   */
  public void printBalances() {
    // STUB
  } // printBalances()

  /*
   * Returns a string representation of the BlockChain which is simply the string representation of
   * each of its blocks, earliest to latest, one per line
   */
  public String toString() {
    // STUB
    return "";
  } // toString()

  // +---------------+-----------------------------------------------------
  // | Inner Classes |
  // +---------------+

  private class Node {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /*
     * The data inside the block
     */
    Block data;

    /*
     * Points to the next node, if there is one
     */
    Node next;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    public Node(Block data, Node next) {
      this.data = data;
      this.next = next;
    } // Node(Block data, Node next)

  } // Node
} // Blockchain
