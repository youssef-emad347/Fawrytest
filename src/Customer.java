public class Customer {
    private String name;
    private float balance;

    public Customer(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkBalance(float balance){
        return this.balance >= balance;
    }
}
