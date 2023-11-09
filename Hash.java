import java.util.Arrays;

public class Hash {
  
  byte[] data;

  public Hash(byte[] newData){
    this.data = newData;
  }

  public boolean isValid(){
    if(data.length < 3){
      return false;
    }
    return((data[0] == 0) && (data[1] == 0) && (data[2] == 0));
  }


  public String toString(){
    String holder = "";
    if(this.data == null){
      return "";
    }

    for(byte temp : this.data){
      Byte.toUnsignedInt(temp);
      holder = holder.concat(String.format("%02X", temp));
    }
    return holder;
  }

  public boolean equals(Object other){
    if(other instanceof Hash){
      Hash holder = (Hash) other;
      return Arrays.equals(this.data, holder.data);
    }
    else{
      return false;
    }
  }

}
