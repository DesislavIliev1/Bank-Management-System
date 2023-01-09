package main.model.account;

public class Savings extends Account {
    public static final double WINDRAW_FEE = 5.00;

public Savings(String id, String name, double balance){
    super(id, name, balance);
}

public Savings(Savings source){
    super(source);
    
}

@Override
public Account clone() {
    // TODO Auto-generated method stub
    return new Savings(this);
}

@Override
public void deposit(double amount) {
    super.setBalance(super.round(super.getBalance() + amount));
    
}
@Override
public boolean withdraw(double amount) {
    super.setBalance(super.round(super.getBalance() - amount - WINDRAW_FEE));
    return true;
}

    



}
