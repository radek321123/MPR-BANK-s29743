package org.pjwstk.s29743bank;

public class TransferStatus {
    private Status Status;
    private double NewAmount;

    public TransferStatus(Status status, double newAmount) {
        Status = status;
        NewAmount = newAmount;
    }

    public double getNewAmount() {
        return NewAmount;
    }

    public void setNewAmount(double newAmount) {
        NewAmount = newAmount;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }
}
