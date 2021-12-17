package com.company.employees;


import com.company.company_structure.Department;
import com.company.enums.Projects;
import com.company.pojo.Task;
import com.company.enums.Positions;
import com.company.interfaces.Human;
import com.company.interfaces.PositionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HumanImpl implements Human {

    private Task task;
    private int id;
    private int managerId;
    private String name;
    private Positions position;
    private List<Human> subordinates;
    private Map<Integer, Human> dataBase = new HashMap<Integer, Human>();
    protected PositionStrategy positionStrategy;
    protected Projects project;


    public HumanImpl(int id, String name, int managerId, Positions position) {
        this.id = id;
        this.managerId = managerId;
        this.name = name;
        this.position = position;
    }

    public HumanImpl(int id, String name, int managerId, Positions position, Department department) {
        this.id = id;
        this.managerId = managerId;
        this.name = name;
        this.position = position;
    }

    public HumanImpl() {
    }

    @Override
    public void buildHierarchyTree(Human emp) {
        Human human = emp;
        List<Human> subs = getSubsById(human.getId());
        human.setSubordinates(subs);
        if (subs.size() == 0) {
            return;
        }
        for (Human em : subs) {
            buildHierarchyTree(em);
        }
    }

    @Override
    public List<Human> getSubsById(int managerId) {
        List<Human> subs = new ArrayList<Human>();
        for (Human em : dataBase.values()) {
            if (em.getManagerId() == managerId) {
                subs.add(em);
            }
        }
        return subs;
    }

    @Override
    public String getBoss() {
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
    public List<Human> getSubordinates() {
        return subordinates;
    }

    @Override
    public void setSubordinates(List<Human> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public Map<Integer, Human> getDataBase() {
        return dataBase;
    }

    @Override
    public void setDataBase(Map<Integer, Human> dataBase) {
        this.dataBase = dataBase;
        buildHierarchyTree(dataBase.get(id));
    }

    @Override
    public Positions getPosition() {
        return position;
    }

    @Override
    public void changePosition() {
        this.position = positionStrategy.setPosition();
    }

    @Override
    public void setPositionStrategy(PositionStrategy positionStrategy) {
        this.positionStrategy = positionStrategy;
    }

    @Override
    public String report() {
        if (getManagerId() == 0) {
            return "My name is " + getName() + " and I can`t report because I`am a boss of the company";
        }
        return "My name is " + getName() + " and I report for done my task " + getTask().getName() + " to my boss: " + getDataBase().get(getManagerId()).getName();
    }

    public Task getTask() {
        if (getManagerId() != 0) {
            return task;
        }
        System.out.println("My name is " + getName() + " and I can`t solve tasks because I`am a boss of the company");
        return task;
    }

    public void setTask(Task task) {
        if (getManagerId() == 0 && getPosition().equals("Employee")) {
            System.out.println("can`t set the task");
        } else {
            this.task = task;
        }
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void addSubordinates(int idOfEmp) {
        if (!getPosition().equals("Employee")) {
            for (int i = 0; i < dataBase.size(); i++) {
                if (dataBase.get(i).getId() == idOfEmp && !dataBase.get(i).getPosition().equals("Boss")) {
                    subordinates.add(dataBase.get(i));
                    dataBase.get(i).setManagerId(getId());
                }
            }
        }
    }

    @Override
    public void updateProject(Projects project) {
        this.project = project;
        System.out.println(" Now employee " + this.name +" works on " + project);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", project='" + project + '\'' +
                '}';
    }
}
