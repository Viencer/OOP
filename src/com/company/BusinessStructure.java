package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BusinessStructure {

    void createDepartmentWithBoss(int bossId);

    void createDataBase(String[] data);

    void getHierarchyOfCompany();

    Employee getBoss();

    Employee getEmployeeById(int id);

    Map<Integer, Employee> getDataBase();

    List<Task> getTasks();

    void addTasks(Task task);

    void setTasks(List<Task> tasks);

    ArrayList<Department> getDepartments();
}
