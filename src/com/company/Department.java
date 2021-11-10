package com.company;

import java.util.ArrayList;
import java.util.List;

public class Department extends Company {

    private static int count = 1;
    private  int id;
    private int bossId;
    private String name;
    private Employee boss;
    private List<Employee> dataBase = new ArrayList<Employee>();

    public Department(Employee boss, String name) {
        this.id = count++;
        this.boss = boss;
        this.bossId = boss.getId();
        this.name = name + " " + id;
        this.dataBase = boss.getSubordinates();
        dataBase.add(boss);
    }

    public Department() {
    }

    public List<Employee> getListOfEmp() {
        return dataBase;
    }

    public void getHierarchyOfDepartment() {
        System.out.println(boss.getName());
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).getPosition().equals("Employee")) {
                System.out.print("\t");
                System.out.println(dataBase.get(i).getName());
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
        for (int i = 0; i <getTasks().size(); i++) {
            if (getTasks().get(i).getId() == taskId){
                for (int j = 0; j < dataBase.size(); j++) {
                    if (dataBase.get(j).getId() == empId){
                        dataBase.get(j).setTask(getTasks().get(i));
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", bossId=" + bossId +
                ", name='" + name + '\'' +
                ", dataBase=" + dataBase +
                '}';
    }
}
