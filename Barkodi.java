
/** Barkodi models an integer key */
public class Barkodi
{ private int k;  // the integer barcode

  /** Constructor  Barkodi  constructs the Barcode 
    * @param i - the integer that uniquely defines the barcode */
  public Barkodi(int i) {  k = i; }

  /** equals  compares this Barcode to another for equality
    * @param c - the other key
    * @return true, if this key equals k's; return false, otherwise */
  public boolean equals(Barkodi c)
  { return  ( k == c.getInt() ); }

  /** getInt returns the integer value held within this key */
  public int getInt() { return k; }
}
