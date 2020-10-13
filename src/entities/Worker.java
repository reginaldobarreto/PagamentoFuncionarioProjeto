package entities;

import enuns.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract>contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
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

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract (HourContract contract){
        contracts.add(contract);
    }

    public void removeContract (HourContract contract){
        contracts.remove(contract);
    }

    public Double income (int mouth, int year){
        double bonus = 0;
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getDate().getMonth() == mouth && contracts.get(i).getDate().getYear() == year){
                bonus += contracts.get(i).totalValue();
            }
        }
        return baseSalary + bonus;
    }

    public Double income1 (int mount, int year){

        Calendar calendar = Calendar.getInstance();
        for (HourContract obj :contracts) {
            calendar.setTime(obj.getDate());
            int mount = 
        }
    }

}