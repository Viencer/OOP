package com.company;

import com.company.command.*;
import com.company.company_structure.Company;
import com.company.enums.Projects;
import com.company.interfaces.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int variant = 0;
        int option = 0;
        int id = 0;

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

        Receiver receiver = new Receiver(company);

        Command getSubordinates = new GetSubordinates(receiver);
        Command changeDepProject = new ChangeDepProject(receiver);
        Command changeDepBoss = new ChangeDepBoss(receiver);

        Invoker invoker = new Invoker(getSubordinates, changeDepProject, changeDepBoss);

        help();
        while (true) {
            int count = 0;
            System.out.println("Main Menu");
            System.out.print("Variant: ");
            variant = Integer.parseInt(reader.readLine());
            switch (variant) {
                case 1:
                    System.out.println("Get subordinates: \n");
                    System.out.println("\n===========================================\n");
                    System.out.print("Choose employee id: ");
                    id = Integer.parseInt(reader.readLine());
                    System.out.println("\n===========================================\n");
                    invoker.getSubordinates(id, 0);
                    System.out.println("\n===========================================\n");
                    continue;
                case 2:
                    System.out.println("Change department project: \n");
                    System.out.println("\n===========================================\n");
                    System.out.print("Choose department id: ");
                    id = Integer.parseInt(reader.readLine());
                    System.out.println("\n===========================================\n");
                    for (Projects proj : Projects.values()) {
                        count++;
                        System.out.println(count + "-->" + proj);
                    }
                    System.out.print("\nChoose project id: ");
                    option = Integer.parseInt(reader.readLine());
                    System.out.println("\n===========================================\n");
                    invoker.changeDepProject(id, option);
                    System.out.println("\n===========================================\n");
                    continue;
                case 3:
                    System.out.println("Change department boss: \n");
                    System.out.println("\n===========================================\n");
                    System.out.print("Choose department id: ");
                    id = Integer.parseInt(reader.readLine());
                    System.out.println("\n===========================================\n");
                    System.out.print("\nChoose new boss id: ");
                    option = Integer.parseInt(reader.readLine());
                    System.out.println("\n===========================================\n");
                    invoker.changeDepBoss(id, option);
                    System.out.println("\n===========================================\n");
                    continue;
                case 4:
                    help();
                    continue;
                case 5:
                    return;
            }
        }
    }

    public static void help() {
        System.out.println("Choose: \n" +
                "1-->Get subordinates by employee id\n" +
                "2-->Change department project by department id\n" +
                "3-->Change department boss by department id\n" +
                "4-->Command help\n" +
                "");
    }
}
