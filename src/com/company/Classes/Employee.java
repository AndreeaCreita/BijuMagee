package com.company.Classes;

public class Employee {
    private String employeeName;
    private int age;
    private double salary;
    private Stall stall;
    private int workExperience;



    public Employee(String employeeName, int age, double salary, Stall stall, int workExperience) {
        this.employeeName = employeeName;
        this.age = age;
        this.salary = salary;
        this.stall = stall;
        this.workExperience = workExperience;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }


    public double increaseSalary () {
        if(workExperience >= 2 && workExperience <= 5) {
            salary += 300;
        }
        else if(workExperience > 5 && workExperience <= 9) {
            salary += 500;
        }
        else if(workExperience >= 10)
        {
            salary += 700;
        }
        return salary;
    }

    public void DisplayEmployee(){
        System.out.println("Employee " + employeeName + "with salary " + salary + " and " + workExperience + " of experience");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", stall=" + stall +
                ", workExperience=" + workExperience +
                '}';
    }
}
