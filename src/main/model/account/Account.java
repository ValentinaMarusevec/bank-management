package src.main.model.account;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public abstract class Account{

    protected String id;
    protected String name;
    protected Double balance;

    public Account(String id, String name, Double balance) {
        if(id == null || name == null || id.isBlank() || name.isBlank()){
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source){
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        check(id);
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        check(name);
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void check(String param){
        if(param == null || param.isBlank()){
            throw new IllegalArgumentException("Parameter cannot be null or blank");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "    " +
            "\t" + this.getId() + "" +
            "\t" + this.getName() + "" +
            "\t$" + this.getBalance() + "";
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract Account clone();

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }

}
