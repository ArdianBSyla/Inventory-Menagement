import javax.swing.*;
/** BankReader reads bank transactions from the user */
public class ProduktReader
{ private String input_line; // holds the most recent input command line
  private String emri;  // holds the name that the user gave
  private int barcode;  // holds tha barcode- an 4-digit integer 
  private int sasia;   // holds the amount of an integer
  private String emri_com; // holds the name of company

  /** Constructor BankReader initializes the input reader */
  public ProduktReader()
  { input_line = ""; 
    emri ="";
    barcode=1111;
    sasia=0;
  }

  /** readCommand reads a new command line
    * @param message - the prompt to the user
    * @return the first character of the command */
  public char readCommand(String message)
  { // read the input line, trim blanks and convert to upper case:
    input_line = JOptionPane.showInputDialog(message).trim().toUpperCase();
    return input_line.charAt(0);  // return the leading character
  }
  /** readName reads a new command line
   * @param message - the prompt to the user
   * @return the characters of the command as a name */
  public String readName(String message)
  {   emri=JOptionPane.showInputDialog(message).trim();//message;
	  return emri;
  }
  
  /** readName reads a new command line
   * @param message - the prompt to the user
   * @return the characters of the command as a name of company*/
  public String readNameCom(String message)
  {   emri_com=JOptionPane.showInputDialog(message).trim();//message;
	  return emri_com;
  }
  /** readBarcode reads a new command line
   * @param message - the prompt to the user
   * @return the integers of the command as barcode */
  
  public int readBarcode(String message)
  { 
    String s = JOptionPane.showInputDialog(message).trim();
    
    if ( s.length() > 0 )
    {  
    	while (s.length() != 4)
    	{
    	      
    		 JOptionPane.showMessageDialog(null, "Nuk e keni dhene barkodin ne rregull");
    		 s = JOptionPane.showInputDialog("Shkruani barkodin numer i plote 4 shifror");
    	 }
    	 barcode = new Integer(s).intValue();
    } 
    return barcode;
  }
  /** readSasine reads an nonnegative amount  
   * @param message - the prompt to the user
   * @return the amount of integer that the user gave */
  public int readSasine(String message)
  {   
	  String s = JOptionPane.showInputDialog(message).trim();
	  if ( s.length() > 0 ) 
	  {  while (s.length() == 0 )
		  {  
		  JOptionPane.showMessageDialog(null, "Shkruani nje vlere numerike ");
		  s = JOptionPane.showInputDialog(message).trim();//sasia = new Integer(s).intValue();
		  }
	        sasia = new Integer(s).intValue();
	        if (sasia <0)
	        {
	        	JOptionPane.showMessageDialog(null,"Keni dhene vlere negative");
	        	readSasine("Shkruani nje vere pozitive");
	        }
	  }
	  return sasia;
  }
}