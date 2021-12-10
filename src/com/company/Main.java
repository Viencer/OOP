package com.company;

import java.util.ArrayList;
import java.util.List;

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

        List<Task> tasks = new ArrayList<Task>();
        Company company = new Company(data);

        company.createDepartmentWithBoss(2);
        company.createDepartmentWithBoss(3);
        company.createDepartmentWithBoss(4);
        for (int i = 1; i < company.getDepartments().size() + 1; i++) {
            for (int j = 0; j < company.getDepartments().get(i - 1).getListOfEmp().size(); j++) {
                tasks.add(new Task(i, "task"));
            }
        }

        System.out.println(company.getEmployeeById(1).getSubordinates());
        company.getHierarchyOfCompany();

    }
}
