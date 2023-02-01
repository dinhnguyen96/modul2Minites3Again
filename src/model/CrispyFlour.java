package model;

import java.time.LocalDate;

public class CrispyFlour extends Material
{
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity)
    {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.getQuantity() * this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusYears(1L);
    }

    @Override
    public double getRealMoney()
    {
        if (this.getExpiryDate().minusMonths(2).isBefore(LocalDate.now())){
            return getCost() *  0.6;
        } else if (this.getExpiryDate().minusMonths(4).isBefore(LocalDate.now())) {
            return getCost() *  0.8;
        } else {
            return getCost() *  0.95;
        }
    }
}
