import java.util.Arrays;

public class Hash {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  byte[] data;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Constructs a new Hash object that contains the given hash (as an array of bytes)
   */
  public Hash(byte[] data) {
    this.data = data;
  } // Hash(byte[] data)

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /*
   * Returns the hash contained in this object
   */

  public byte[] getData() {
    return this.data;
  } // getData()

  /*
   * Returns true if this hash meets the criteria for validity, i.e., its first three indices
   * contain zeroes
   */
  public boolean isValid() {
    if (data.length < 3) {
      return false;
    }

    return ((data[0] == 0) && (data[1] == 0) && (data[2] == 0));
  } // isValid()

  /*
   * Returns the string representation of the hash as a string of hexadecimal digits, 2 digits per
   * byte
   */
  public String toString() {
    if (this.data == null) {
      return "";
    }

    String holder = "";
    for (byte temp : this.data) {
      Byte.toUnsignedInt(temp);
      holder = String.format(holder + "%s", temp);
    }

    return holder;
  } // toString()

  /*
   * Returns true if this hash is structurally equal to the argument
   */
  public boolean equals(Object other) {
    if (other instanceof Hash) {
      Hash holder = (Hash) other;
      return Arrays.equals(this.data, holder.data);
    } else {
      return false;
    }
  } // equals(Object other)

} // Hash
