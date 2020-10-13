package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enuns.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        String depart = null;
        String name = null;
        String level = null;
        Double baseSalary = null;
        int contracts = 0 ;

        System.out.print("Enter Department's Name: ");
        depart = scanner.nextLine();
        System.out.println();
        System.out.println("Enter worker data");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Level (Junior, Mid_level or Senior): ");
        level = scanner.next();
        System.out.print("Base Salary: ");
        baseSalary = scanner.nextDouble();
        Department departament = new Department(depart);
        Worker worker = new Worker(name,WorkerLevel.valueOf(level.toUpperCase()),baseSalary,departament);

        System.out.println();
        System.out.println("How many contracts to this worker ?");
        contracts = scanner.nextInt();
        for (int i = 0; i < contracts; i++) {
            System.out.print("Enter contract #" + i + "data: ");
            System.out.println();
            System.out.print("Date DD/MM/YYYY: ");
            scanner.nextLine();
            String data = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = simpleDateFormat.parse(data);
            System.out.print("Value per hour: ");
            Double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scanner.nextInt();
            worker.addContract(new HourContract(date,valuePerHour,hours));
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");

        Calendar income = Calendar.getInstance();

        String data = scanner.next();
        int income_mounth = Integer.parseInt(data.substring(0,2));
        int income_year = Integer.parseInt(data.substring(3,7));
        System.out.println("mounth " + income_mounth + ": year " + income_year);

        System.out.println();
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for: " + data + " " + String.format("%.2f", worker.income(income_mounth, income_year)));

        scanner.close();
    }
}