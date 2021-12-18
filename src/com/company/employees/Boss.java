package com.company.employees;

import com.company.pojo.Task;
import com.company.enums.Positions;
import com.company.strategy.PositionStrategy;

public class Boss extends HumanImpl {

    private static Boss instance;

    public static synchronized Boss getInstance(int id, String name, int managerId, Positions position) {
        if (instance == null) {
            instance = new Boss(id, name, managerId, position);
        }
        return instance;
    }

    private Boss(int id, String name, int managerId, Positions position) {
        super(id, name, managerId, position);
    }

    private Boss() {
        super();
    }

    @Override
    public String getBoss() {
        return "I don`t have boss because I`am boss of the company";
    }

    @Override
    public String report() {
        return "My name is " + getName() + " and I can`t report because I`am a boss of the company";
    }

    public Task getTask() {
        return null;
    }

    public void setTask(Task task) {
    }

    public void setManagerId(int managerId) {
    }

    @Override
    public void changePosition() {
        System.out.println("can`t change boss position");
    }

    @Override
    public void setPositionStrategy(PositionStrategy positionStrategy) {
        System.out.println("can`t set boss strategy");
    }
}
