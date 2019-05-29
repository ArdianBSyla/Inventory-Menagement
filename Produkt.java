import javax.swing.*;
public class Produkt {
	  
	  private Barkodi barkodi;       // the identification key
	  private int sasia;  // the account's balance
	  private String emri;

	  /** Constructor Record initializes the account
	    * @param initial_amount - the starting account balance, a nonnegative.
	    * @param id - the account's identification key  */
	  public Produkt(String e,int s, Barkodi id)
	  { sasia = s;
	    barkodi = id;
	    emri=e;
	  }
	  /** add adds an amount to the products.
	    * @param amount - the amount of products to be added, a nonnegative int
	    * @return true, if the deposit was successful; false, otherwise  */
	  public boolean add(int amount)
	  { boolean result = false;
	    if ( amount >= 0 )
	         { sasia = sasia + amount;
	           result = true;
	         }
	    else { JOptionPane.showMessageDialog(null,"Produkt error");
	         }
	    return result;
	  }
	  /* sell removec the amount of products from the products, if it is possible.
	   * @param amount - the amount of products to be sold, a nonnegative int
	   * @return true, if the sold was successful; false, otherwise */
	  public boolean sell(int vlera)
	  { boolean result = false;
	    if ( vlera < 0 )
	       { JOptionPane.showMessageDialog(null,"Ju lutem jepni vlere pozitive"); }
	    else if ( vlera > sasia )
	         { JOptionPane.showMessageDialog(null,
	             "Nuk keni kaq shume sasi te ketij produkti");
	         }
	    else { sasia = sasia - vlera;
	           result = true;
	         }
	    return result;
	  }

	  /** getBalance reports the current products balance
	    * @return the balance */
	  public int getQuantity() { return sasia; }

	  /** getBarcode returns the product's barcode
	    * @return the barcode */
	  public Barkodi getBarcode() { return barkodi; }
	  
	  /** getName returns the product's name
	    * @return the name */
	  public String getName() { return emri; }
}
