package com.company;

import com.company.strategy.DowngradeStrategy;

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

        System.out.println(company.getEmployeeById(6));
        company.getEmployeeById(6).changePosition();
        System.out.println(company.getEmployeeById(6));
        company.getEmployeeById(6).setPositionStrategy(new DowngradeStrategy());
        company.getEmployeeById(6).changePosition();
        company.getEmployeeById(1).setPositionStrategy(new DowngradeStrategy());
        company.getEmployeeById(1).changePosition();

    }
}
