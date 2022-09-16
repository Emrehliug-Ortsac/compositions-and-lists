package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Type the department: ");
        String department = sc.nextLine();
        System.out.println();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkLevel.valueOf(level), baseSalary, new Department(department));

        System.out.print("The worker " + name + " have contracts? (y/n): ");
        char answer = sc.next().charAt(0);
        if (answer == 'y' || answer == 'Y'){
            System.out.println();
            System.out.print("Type the quantity contracts: ");
            int n = sc.nextInt();
            for (int i = 1; i<=n;i++){
                System.out.print("Contract #" + i + " date: ");
                Date dateContract = simpleDateFormat.parse(sc.next());
                System.out.print("Value per Hour: ");
                double valuePerHour = sc.nextDouble();
                System.out.print("Time contract: ");
                Integer hours = sc.nextInt();
                System.out.println();
                HourContract hourContract = new HourContract(dateContract, valuePerHour, hours);
                worker.addContract(hourContract);
            }

            System.out.println();
            System.out.print("Enter month and year to calculate income (MM/YYYY): ");
            String monthAndYear = sc.next();
            int month = Integer.parseInt(monthAndYear.substring(0, 2));
            int year = Integer.parseInt(monthAndYear.substring(3));
            System.out.println("Name: " + worker.getName());
            System.out.println("Level: " + worker.getLevel());
            System.out.println("Department: " + worker.getDepartment().getName());
            System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        }else {
            System.out.println("Thank you!");
        }

        sc.close();
    }

}
