/** AccountManager starts the application that maintains a bank account. 
  * Inputs:  a series of commands of the forms,
  *   D dd.cc  (deposit),
  *   W dd.cc  (withdraw), or
  *   Q        (quit),  where  dd.cc  is a dollars-cents amount
  * Outputs: a display of the results of the transactions */
public class AccountManager
{ public static void main(String[] args)
  { // create the application's objects:
    ProduktReader reader = new ProduktReader();
    Database base = new Database(4);
    Writer writer = new Writer("BankWriter", base);
    AccountController controller =
               new AccountController(reader, writer, base);
    // start the controller:
    controller.processTransactions();
  }
}