package entities;

import enums.WorkLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkLevel level;
    private Double baseSalary;
    private List<HourContract> contracts = new ArrayList<>();
    private Department department;

    public Worker(){}

    public Worker(String name, WorkLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkLevel getLevel() {
        return level;
    }

    public void setLevel(WorkLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }


    public List<HourContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar calendar = Calendar.getInstance();
        for (HourContract hourContract: contracts){
            calendar.setTime(hourContract.getDateContract());
            int calendar_year = calendar.get(Calendar.YEAR);
            int calendar_month = 1 + calendar.get(Calendar.MONTH);
            if (year == calendar_year && month == calendar_month){
                sum += hourContract.totalValue();
            }
        }
        return sum;
    }


}
