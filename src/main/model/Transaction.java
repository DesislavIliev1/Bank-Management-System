package main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
    
    public enum Type{WINDRAW, DEPOSIT};
    private Type type;
    private long longTimestamp;
    private String id;
    private double amount;

    public Transaction(Type type,long longTimestamp, String id, double amount){
        if(id.isBlank() || id == null || amount < 0){
            throw new IllegalArgumentException("INVALID PARAMS");
        }
        this.type = type;
        this.longTimestamp = longTimestamp;
        this.id = id;
        this.amount = amount;
    }
    public Transaction(Transaction source){
        this.type = source.type;
        this.longTimestamp = source.longTimestamp;
        this.id = source.id;
        this.amount = source.amount;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public long getLongTimestamp() {
        return longTimestamp;
    }
    public void setLongTimestamp(long longTimestamp) {
        this.longTimestamp = longTimestamp;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Invalid amount");
        }
        this.amount = amount;
    }
    public String returnDate(){
        Date date = new Date(this.longTimestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
   

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(type, transaction.type) && longTimestamp == transaction.longTimestamp && Objects.equals(id, transaction.id) && amount == transaction.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, longTimestamp, id, amount);
    }
    @Override
    public int compareTo(Transaction o) {
        // TODO Auto-generated method stub
        return Double.compare(this.longTimestamp, o.longTimestamp);
    }
    @Override
    public String toString() {
        return (type) + "    " +
        "\t" + this.returnDate() + "" +
        "\t" + id + "" +
        "\t$" + amount + "";
}
    
    

  

}
