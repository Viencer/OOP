package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImpl implements Employee {

    private Task task;
    private final int id;
    private int managerId;
    private final String name;
    private final String position;
    private List<Employee> subordinates;
    private Map<Integer, Employee> dataBase = new HashMap<Integer, Employee>();

    public EmployeeImpl(int id, String name, int managerId, String position) {
        this.id = id;
        this.managerId = managerId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void buildHierarchyTree(Employee emp) {
        Employee employee = emp;
        List<Employee> subs = getSubsById(employee.getId());
        employee.setSubordinates(subs);
        if (subs.size() == 0) {
            return;
        }
        for (Employee em : subs) {
            buildHierarchyTree(em);
        }
    }

    @Override
    public List<Employee> getSubsById(int managerId) {
        List<Employee> subs = new ArrayList<Employee>();
        for (Employee em : dataBase.values()) {
            if (em.getManagerId() == managerId) {
                subs.add(em);
            }
        }
        return subs;
    }

    @Override
    public String getBoss() {
        if (dataBase.get(getId()).getManagerId() == 0) {
            return "I don`t have boss because I`am boss of the company";
        }
        return "Boss of employee " + dataBase.get(getId()).getName() + " is " + dataBase.get(getManagerId()).getName();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getManagerId() {
        return managerId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public Map<Integer, Employee> getDataBase() {
        return dataBase;
    }

    @Override
    public void setDataBase(Map<Integer, Employee> dataBase) {
        this.dataBase = dataBase;
        buildHierarchyTree(dataBase.get(id));
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String report() {
        if (getManagerId() == 0) {
            return "My name is " + getName() + " and I can`t report because I`am a boss of the company";
        }
        return "My name is " + getName() + " and I report for done my task "+ getTask().getName() +" to my boss: " + getDataBase().get(getManagerId()).getName();
    }

    public Task getTask() {
        if (getManagerId() != 0) {
            return task;
        }
        System.out.println("My name is " + getName() + " and I can`t solve tasks because I`am a boss of the company");
        return task;
    }

    public void setTask(Task task) {
        if (getManagerId() == 0) {
            System.out.println("My name is " + getName() + " and I can`t solve tasks because I`am a boss of the company");
        } else {
            this.task = task;
        }

    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void addSubordinates(int idOfEmp){
        if (!getPosition().equals("Employee")){
            for (int i = 0; i < dataBase.size(); i++) {
                if (dataBase.get(i).getId() == idOfEmp && !dataBase.get(i).getPosition().equals("Boss")){
                    subordinates.add(dataBase.get(i));
                    dataBase.get(i).setManagerId(getId());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
