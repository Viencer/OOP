package com.company.company_structure;

import com.company.enums.Projects;
import com.company.pojo.Task;
import com.company.employees.Boss;
import com.company.employees.DepBoss;
import com.company.employees.Employee;
import com.company.enums.Positions;
import com.company.interfaces.BusinessStructure;
import com.company.interfaces.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company implements BusinessStructure {

    private Map<Integer, Human> dataBase = new HashMap<Integer, Human>();
    private Map<Integer, Department> departments = new HashMap<Integer, Department>();
    private List<Task> tasks = new ArrayList<Task>();
    private Human boss;

    public Company(String[] data) {
        createDataBase(data);
    }

    public Company() {
    }

    public void createDepartment(int id, int bossId, String name, Projects project) {
        Department department = new Department(id, getEmployeeById(bossId),
                name, project, getEmployeeById(bossId).getSubordinates());
            departments.put(id, department);
    }

    public void createDepartments(String[] data) {
        Department department = null;
        for (String strLine : data) {
            String[] values = strLine.split(" ");
            department = new Department(Integer.parseInt(values[0]), getEmployeeById(Integer.parseInt(values[2])),
                    values[1], Projects.valueOf(values[3]), getEmployeeById(Integer.parseInt(values[2])).getSubordinates());
            departments.put(Integer.parseInt(values[0]), department);
        }
    }

    @Override
    public void createDataBase(String[] data) {
        Human human = null;
        for (String strLine : data) {
            String[] values = strLine.split(" ");
            if (values.length >= 5) {
                if (values[4].equals("DepBoss")) {
                    human = new DepBoss(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt(values[3]), Positions.DEP_BOSS);
                } else if (values[4].equals("Employee"))
                    human = new Employee(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt(values[3]), Positions.EMPLOYEE);
            } else
                human = Boss.getInstance(Integer.parseInt(values[0]), values[1] + " " + values[2], Integer.parseInt("0"), Positions.BOSS);
            dataBase.put(human.getId(), human);
            if (human.getManagerId() == 0)
                boss = human;
        }
    }

    @Override
    public void getHierarchyOfCompany() {
        dataBase.get(1).setDataBase(dataBase);
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
    public Map<Integer, Department> getDepartments() {
        return departments;
    }

    public Department getDepartmentById(int id) {
        return departments.get(id);
    }

}
