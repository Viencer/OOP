package com.company.command;

import com.company.company_structure.Company;
import com.company.enums.Projects;

public class Receiver {

    Company company;

    public Receiver(Company company) {
        this.company = company;
    }

    public void getSubordinates(int id, int option) {
        System.out.println(company.getEmployeeById(id).getSubordinates());
    }

    public void changeDepProject(int id, int option) {
        int count = 0;
        for (Projects proj : Projects.values()) {
            count++;
            if (count == option) {
                company.getDepartmentById(id).setProject(proj);
            }
            else if (option > Projects.values().length || option < 0)
                System.out.println("wrong number\n");
        }
    }

    public void changeDepBoss(int id, int option) {
        company.getDepartmentById(id).changeBoss(company.getEmployeeById(option));
    }

}
