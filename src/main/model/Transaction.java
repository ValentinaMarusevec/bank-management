package src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {

  public enum Type{
    WITHDRAW,
    DEPOSIT
  };
  private Type type;
  private long timestamp;
  private String id;
  private double amount;

  public Transaction(Type type,long timestamp,  String id, double amount) {
      if (id == null || id.isBlank() || amount < 0) {
          throw new IllegalArgumentException("INVALID PARAMS");
      }
    this.timestamp = timestamp;
    this.type = type;
    this.id = id;
    this.amount = amount;
  }

  public Transaction(Transaction source) {
    this.type = source.type;
    this.timestamp = source.timestamp;
    this.id = source.id;
    this.amount = source.amount;
  }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Id cannot be null or blank!");
        }
        this.id = id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative!");
        }
        this.amount = amount;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String returnDate(){
        Date date = new Date(this.timestamp *1000);
        return new SimpleDateFormat("dd-MM-YYY").format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(type, transaction.type) && timestamp == transaction.timestamp && Objects.equals(id, transaction.id) && amount == transaction.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }
   

    @Override
    public String toString() {
        return (type) + "    " +
            "\t" + returnDate()+ "" +
            "\t" + id + "" +
            "\t$" + amount + "";
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }


}
