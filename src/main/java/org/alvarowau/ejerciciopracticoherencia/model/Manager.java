package org.alvarowau.ejerciciopracticoherencia.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private int teamSize;
    private String department;
    private double budget;
    private int reports;

    public Manager() {
    }

    public Manager(Long id, String name, String lastName, String email, Address address, int teamSize, String department, double budget, int reports) {
        super(id, name, lastName, email, address);
        this.teamSize = teamSize;
        this.department = department;
        this.budget = budget;
        this.reports = reports;
    }

    public Manager(int teamSize, String department, double budget, int reports) {
        this.teamSize = teamSize;
        this.department = department;
        this.budget = budget;
        this.reports = reports;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "teamSize=" + teamSize +
                ", department='" + department + '\'' +
                ", budget=" + budget +
                ", reports=" + reports +
                "} " + super.toString();
    }
}
