import javax.swing.*;
/** AccountController maintains the balance of products of a store-chain. */
public class AccountController {
	// fields that remember the view and model objects:
		  private ProduktReader reader;  // input-view
		  private Writer writer;  // output-view
		  private Database base;  // model

		  /** Constructor AccountController builds the controller
		    * @param r - the input-view object
		    * @param w - the output-view object
		    * @param a - the model object  */
		  public AccountController(ProduktReader r, Writer w, Database db)
		  { reader = r;
		    base = db;
		    writer = w;
		  }
		  public void processName()
		  {
			  String emri_com = reader.readNameCom("Shkruani emrin e kompanise psh: ARDI COM");
			  writer.showNameCom(emri_com);
		  }
		  public void processCommands()
		  {
			  char command =  reader.readCommand("SHKRUANE KOMANDAT"+ "\n"+ "I-Shto produkt te ri "
		  + "\n"+ "A=Shto sasine e nje produkti ekzistues" + "\n" + 
					  "S = Shit nje sasi te nje produkti" + "\n" 
		  + "D= Fshije nje produkt ekzistues " + "\n" + "Q = Per dalje nga programi ");
			  switch(command) {
              case 'I' : 
                 {   String emri = reader.readName("Shkruani emrin e produktit ");
                     int barkodi = reader.readBarcode("Shkruani barkodin 4 shifra : ");
                     int sasia = reader.readSasine("Sasia e ketij produkti: ");
                     int nr = reader.readSasine("nr:");
                	 boolean insertimi = base.insert(new Produkt(emri, sasia, new Barkodi(barkodi)));
                	 if (insertimi)
                	 {
                		 writer.showName(base.find(new Barkodi(barkodi)).getName(),nr);
                		 writer.showBarcode(base.find(new Barkodi(barkodi)).getBarcode().getInt());
               		     writer.showSasine(base.find(new Barkodi(barkodi)).getQuantity());
               		     
                	 }
                	 else
                	 {
                		JOptionPane.showMessageDialog(null, "Keni perdorur barkodin ekzistues"); 
                	 }
                	 processCommands();
                 } 
                 break;
              case 'A' : 
                 {   int barkodi = reader.readBarcode("Shkruani barkodin 4 shifra : ");
                	 boolean shtimi = base.find(new Barkodi(barkodi)).add(reader.readSasine("sasia"));
                	 if(shtimi)
                	 {   
                		 writer.showSasine(base.find(new Barkodi(barkodi)).getQuantity());
                	 }
                	 else {JOptionPane.showMessageDialog(null, "Ky produkt nuk ekziston");}
                	 processCommands();
                 } 
                 break;
              case 'S' : 
                 {   
                	 
                	 int barkodi = reader.readBarcode("Shkruani barkodin 4 shifra : ");
                	 boolean shitja = base.find(new Barkodi(barkodi)).sell(reader.readSasine("sa : "));
                	 if(shitja)
                	 {
                		 writer.showSasine(base.find(new Barkodi(barkodi)).getQuantity());
                	 }
                	 else {JOptionPane.showMessageDialog(null, "Ky produkt nuk ekziston");}
                	 processCommands();
                 } 
                 break;
              case 'D' : 
                 {   int barkodi =reader.readBarcode("Shkruani barkodin e produktit qe"
             	 		+ "deshironi ta fshini nga lista ");
                     String emri =base.find(new Barkodi(barkodi)).getName();
                	 boolean delete =base.delete(new Barkodi(barkodi));
                	 if (delete)
                	 {
                		 JOptionPane.showMessageDialog(null, "Fshirja e produktit " +emri+""
                		 		+ " eshte kryer me sukses");
                	}
                	 else 
                	 {
                		 JOptionPane.showMessageDialog(null, "Ky produkt nuk ekziston");
                	 }
                 } 
                 break;
              case 'Q' : {  } 
              break;
              default : 
                 { JOptionPane.showMessageDialog(null, "Ju lutem jepni komanden perkatese ");
                 processCommands();}
                 }
		  }
		  /** processTransactions  processes user commands until a Q is entered */
		  public void processTransactions()
		  {
			  processName();
			  processCommands();
		  }
}
