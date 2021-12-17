package com.company.company_structure;

import com.company.enums.Projects;
import com.company.interfaces.Human;
import com.company.interfaces.ProjectObserver;

import java.util.ArrayList;
import java.util.List;

public class Department extends Company implements ProjectObserver {

    private int id;
    private int bossId;
    private String name;
    private Human boss;
    private Projects project;
    private List<Human> departmentDataBase = new ArrayList<Human>();

    public Department(int id, Human boss, String name, Projects project, List<Human> dataBase) {
        this.id = id;
        this.boss = boss;
        this.bossId = boss.getId();
        this.name = name;
        this.project = project;
        this.departmentDataBase = dataBase;
        this.departmentDataBase.add(boss);
        notifyEmployees();
    }

    public Department() {
    }

    public List<Human> getListOfEmp() {
        return departmentDataBase;
    }

    public void getHierarchyOfDepartment() {
        System.out.println(boss.getName());
        for (int i = 0; i < departmentDataBase.size(); i++) {
            if (departmentDataBase.get(i).getPosition().equals("Employee")) {
                System.out.print("\t");
                System.out.println(departmentDataBase.get(i).getName());
            }
        }
    }

    public int getBossId() {
        return bossId;
    }

    public int getDepId() {
        return id;
    }

    public void setTaskToEmp(int empId, int taskId) {
        for (int i = 0; i < getTasks().size(); i++) {
            if (getTasks().get(i).getId() == taskId) {
                for (int j = 0; j < departmentDataBase.size(); j++) {
                    if (departmentDataBase.get(j).getId() == empId) {
                        departmentDataBase.get(j).setTask(getTasks().get(i));
                    }
                }
            }
        }
    }

    @Override
    public void setProject(Projects project) {
        this.project = project;
        notifyEmployees();
    }

    @Override
    public void addEmployee(Human human) {
        this.departmentDataBase.add(human);
        human.setManagerId(this.bossId);
        notifyEmployees();
    }

    @Override
    public void notifyEmployees() {
        for (Human emp : departmentDataBase) {
            emp.updateProject(this.project);
        }
    }

    @Override
    public Human getBoss() {
        return this.boss;
    }

    public List<Human> getDataBased() {
        return this.departmentDataBase;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", bossId=" + bossId +
                ", name='" + name + '\'' +
                ", dataBase=" + departmentDataBase +
                ", project=" + project +
                '}';
    }
}
