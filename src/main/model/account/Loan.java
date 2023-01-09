package main.model.account;

public class Loan extends Account{
public static final double INTEREST_RATE = 0.02;

public Loan(String id, String name, double balance){
        super(id, name, balance);
}

public Loan(Loan source){
        super(source);
        
}

@Override
public Account clone() {
    // TODO Auto-generated method stub
    return new Loan(this);
}

@Override
public void deposit(double amount) {
    super.setBalance(super.round(super.getBalance() - amount));
    
}
@Override
public boolean withdraw(double amount) {
        if(super.getBalance() + amount > 10000){
                return false;
        }
        super.setBalance(super.round(super.getBalance() + amount + (amount * INTEREST_RATE)));
        return true;
        }
}

