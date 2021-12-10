package com.company;

public class Boss extends EmployeeImpl {

    private static Boss instance;

    public static synchronized Boss getInstance(int id, String name, int managerId, String position) {
        if (instance == null) {
            instance = new Boss(id, name, managerId, position);
        }
        return instance;
    }

    private Boss(int id, String name, int managerId, String position) {
        super(id, name, managerId, position);
    }

    private Boss () {
        super();
    }
}
