package popj;

public class Account {
    private String username;
    private String password;
    private double money;
    private int CardNumber;

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", CardNumber=" + CardNumber +
                '}';
    }
}
