package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.model.Bank;
import main.model.Transaction;
import main.model.account.Chequing;

public class BankTests {

    Bank bank;

    @Before
    public void setup() {
        bank = new Bank();
        bank.addAccount(new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51));
      }
    @Test
    public void successfullTransactions(){
        this.bank.executeTransaction(new Transaction(Transaction.Type.WINDRAW, 1546905600, "f84c43f4-a634-4c57-a644-7602f8840870", 624.99));
        this.bank.executeTransaction(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 441.93));
        assertEquals(2, bank.getTransactions("f84c43f4-a634-4c57-a644-7602f8840870").length);
    }

    @Test
    public void failedTransaction(){
        this.bank.executeTransaction(new Transaction(Transaction.Type.WINDRAW, 1546905600 , "f84c43f4-a634-4c57-a644-7602f8840870", 1000000));
    }

    @Test
    public void taxDeduction(){
        this.bank.executeTransaction(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 4000));
    this.bank.deductTaxes();
    assertEquals(5374.51, bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());
    }

    @Test
    
    public void taxDeduction2() {
    this.bank.executeTransaction(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 4000));
    this.bank.executeTransaction(new Transaction(Transaction.Type.WINDRAW, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 500));

    this.bank.deductTaxes();
    assertEquals(4949.51, bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());
}
}
