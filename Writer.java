import java.awt.*;
import javax.swing.*;
/** BankWriter writes bank transactions */
public class Writer extends JPanel
{ private int WIDTH = 600;  // width and depth of displayed window
  private int DEPTH = 500;
  private Database base;  // the address of the bank account displayed
  private String last_transaction = ""; // the transaction that is displayed
  private String emri ="";
  private int barcode;
  private int sasia;
  private int i = 1;
  
  /** Constructor BankAccount initializes the writer
    * @param title - the title bar's text
    * @param b - the (address of) the bank account displayed by the Writer */
  public Writer(String title,Database db)
  { base = db;
    JFrame my_frame = new JFrame();
    my_frame.getContentPane().add(this);
    my_frame.setTitle(title);
    my_frame.setSize(WIDTH, DEPTH);
    my_frame.setVisible(true);
    
  }

  public void paintComponent(Graphics g)
  { g.setColor(Color.white);
    g.fillRect(0, 0, WIDTH, DEPTH);  // paint the background
    g.setColor(Color.black);
    int text_margin = 50;
    int text_baseline = 50;
    int hapesira = 100;
   g.drawString(last_transaction, 20, 20);
   g.drawString("Emri i produktit" , text_margin, text_baseline);
   g.drawString("Barkodi " , text_margin+hapesira, text_baseline);
   g.drawString("Sasia" , text_margin+(hapesira+50), text_baseline);
   
   
   //g.drawString(emri, text_margin, text_baseline+20*i);
   //g.drawString(barcode+"", text_margin+hapesira, text_baseline+20*i);
   //g.drawString(sasia+"",text_margin +(hapesira+50), text_baseline+20*i);
   this.repaint();
   
   drawProduktet(emri, barcode, sasia, g);
   //drawProduktet(emri, barcode, sasia, g);
   
   //this.repaint();
   
   }
 /** public void showProduktin(String emri, int barcode, int sasia)
  {
	  this.emri=emri;
	  this.barcode=barcode;
	  this.sasia=sasia;
	  this.repaint();
  }*/
  public void drawProduktet(String emri, int barcode, int sasia,Graphics g)
  {    int text_margin = 50;
       int text_baseline = 50;
       int hapesira = 100;
       
	   g.drawString(emri+"", text_margin, text_baseline+20*i);
	   g.drawString(barcode+"", text_margin+hapesira, text_baseline+20*i);
	   g.drawString(sasia+"",text_margin +(hapesira+50), text_baseline+20*i);
       
	   
	  
  }

  /** showTransaction displays the result of a monetary bank transation
   * @param message - the transaction
   * @param amount - the amount of the transaction */
  public void showName(String message, int i)
  {   this.i=i;
	  emri=message;
	  this.repaint();
  }
  public void showSasine(int message)
  {   sasia= message;
	  this.repaint();
  }
  public void showBarcode(int message)
  {   barcode=message;
	  this.repaint();
  }
 public void showTransaction(String message)
 { last_transaction = message + " " ;//+ unconvert(amount);
   this.repaint();
 }

 /** showTransaction displays the result of a bank transation
   * @param message - the transaction */
 public void showNameCom(String message)
 { last_transaction = message;
   this.repaint();
 }
 
}