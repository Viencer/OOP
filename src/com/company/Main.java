package com.company;

import com.company.company_structure.Company;
import com.company.enums.Projects;

public class Main {

    public static void main(String[] args) {
        String[] data = {
                "1 Oleg Mikitchik Boss",
                "2 Martin Bones 1 DepBoss",
                "3 Martin Luter 1 DepBoss",
                "4 Frederick Monak 1 DepBoss",
                "5 Jersy Pichford 2 Employee",
                "6 Elon Cost 3 Employee",
                "7 Andrew Frutman 3 Employee",
                "8 Gordon Freeman 3 Employee",
                "9 Bob Ford 4 Employee",
                "10 Mike Potter 4 Employee",
                "11 Tom Fox 4 Employee"
        };

        String[] departments = {
                "1 Department_1 2 PROJECT_1",
                "2 Department_2 3 PROJECT_2",
                "3 Department_3 4 PROJECT_3",
        };

        Company company = new Company(data);

        company.createDepartments(departments);

        System.out.println("\n");
        company.getDepartmentById(2).setProject(Projects.PROJECT_4);
        System.out.println("\n");
        company.getDepartmentById(2).addEmployee(company.getEmployeeById(9));
        System.out.println(company.getEmployeeById(9));

    }
}
