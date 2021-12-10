package com.company;

import com.company.interfaces.BusinessStructure;
import com.company.interfaces.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company implements BusinessStructure {

    private ArrayList<Department> departments = new ArrayList<Department>();
    private Map<Integer, Human> dataBase = new HashMap<Integer, Human>();
    private List<Task> tasks = new ArrayList<Task>();
    private Human boss;

    public Company(String[] data) {
        createDataBase(data);
    }

    public Company() {
    }

    @Override
    public void createDepartmentWithBoss(int bossId) {
        if (getDataBase().get(bossId).getPosition().equals("DepBoss")) {
            departments.add(new Department(getEmployeeById(bossId), "Department"));
        } else {
            System.out.println("Boss of department cannot be person with position " + getDataBase().get(bossId).getPosition());
        }
    }

    @Override
    public void createDataBase(String[] data) {
        Human human = null;
        for (String strLine : data) {
            String[] values = strLine.split(" ");
            if (values.length >= 5) {
                if (values[4].equals("DepBoss")) {
                    human = new DepBoss(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt(values[3]), values[4]);
                } else if (values[4].equals("Employee"))
                    human = new Employee(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt(values[3]), values[4]);
            } else
                human = Boss.getInstance(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt("0"), values[3]);
            dataBase.put(human.getId(), human);
            if (human.getManagerId() == 0)
                boss = human;
        }
    }

    @Override
    public void getHierarchyOfCompany() {
        hierarchyOfCompany(getBoss(), 0);
    }

    private void hierarchyOfCompany(Human emp, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(emp.getName());
        List<Human> subs = emp.getSubordinates();
        for (Human em : subs) {
            hierarchyOfCompany(em, level + 1);
        }
    }

    @Override
    public Human getBoss() {
        dataBase.get(boss.getId()).setDataBase(dataBase);
        return boss;
    }

    @Override
    public Human getEmployeeById(int id) {
        dataBase.get(id).setDataBase(dataBase);
        return dataBase.get(id);
    }

    @Override
    public Map<Integer, Human> getDataBase() {
        return dataBase;
    }

    @Override
    public List<Task> getTasks() {
        if (tasks.isEmpty()) {
            System.out.println("tasks is missing");
        }
        return tasks;
    }

    @Override
    public void addTasks(Task task) {
        tasks.add(task);
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
