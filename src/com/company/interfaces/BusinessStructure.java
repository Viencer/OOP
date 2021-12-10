package com.company.interfaces;

import com.company.Department;
import com.company.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BusinessStructure {

    void createDepartmentWithBoss(int bossId);

    void createDataBase(String[] data);

    void getHierarchyOfCompany();

    Human getBoss();

    Human getEmployeeById(int id);

    Map<Integer, Human> getDataBase();

    List<Task> getTasks();

    void addTasks(Task task);

    void setTasks(List<Task> tasks);

    ArrayList<Department> getDepartments();
}
