package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company implements BusinessStructure {

    private ArrayList<Department> departments = new ArrayList<Department>();
    private Map<Integer, Employee> dataBase = new HashMap<Integer, Employee>();
    private List<Task> tasks = new ArrayList<Task>();
    private Employee boss;

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
        Employee employee = null;
        for (String strLine : data) {
            String[] values = strLine.split(" ");
            if (values.length >= 5)
                employee = new EmployeeImpl(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt(values[3]), values[4]);
            else
                employee = new EmployeeImpl(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt("0"), values[3]);
            dataBase.put(employee.getId(), employee);
            if (employee.getManagerId() == 0)
                boss = employee;
        }
    }

    @Override
    public void getHierarchyOfCompany() {
        hierarchyOfCompany(getBoss(), 0);
    }

    private void hierarchyOfCompany(Employee emp, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(emp.getName());
        List<Employee> subs = emp.getSubordinates();
        for (Employee em : subs) {
            hierarchyOfCompany(em, level + 1);
        }
    }

    @Override
    public Employee getBoss() {
        dataBase.get(boss.getId()).setDataBase(dataBase);
        return boss;
    }

    @Override
    public Employee getEmployeeById(int id) {
        dataBase.get(id).setDataBase(dataBase);
        return dataBase.get(id);
    }

    @Override
    public Map<Integer, Employee> getDataBase() {
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
