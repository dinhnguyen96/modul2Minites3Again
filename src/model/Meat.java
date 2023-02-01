package model;

import java.time.LocalDate;

public class Meat extends Material
{
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight)
    {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return this.getCost() * this.getWeight();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney()
    {
        LocalDate expiryDate = this.getExpiryDate();
        LocalDate now = LocalDate.now();
        if (expiryDate.minusDays(2).isBefore(now)){
            return this.getCost() * 0.7;
        }else {
            return this.getCost() *  0.9;
        }
    }
}
