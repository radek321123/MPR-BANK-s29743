package org.pjwstk.s29743bank;

public class Client {
    private int Id;
    private double Money;

    public Client(int id, double money) {
        Id = id;
        Money = money;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }
}
