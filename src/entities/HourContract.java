package entities;

import java.util.Date;

public class HourContract {

    private Date dateContract;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(){}

    public HourContract(Date dateContract, Double valuePerHour, Integer hours) {
        this.dateContract = dateContract;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDateContract() {
        return dateContract;
    }

    public void setDateContract(Date dateContract) {
        this.dateContract = dateContract;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double totalValue(){
        return valuePerHour * hours;
    }

}
