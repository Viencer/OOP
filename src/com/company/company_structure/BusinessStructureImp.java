package com.company.company_structure;

import com.company.interfaces.BusinessStructure;
import com.company.interfaces.Human;
import com.company.pojo.Task;

import java.util.List;
import java.util.Map;

public class BusinessStructureImp implements BusinessStructure {

    @Override
    public void createDataBase(String[] data) {
    }

    @Override
    public void getHierarchyOfCompany() {
    }

    @Override
    public Human getBoss() {
        return null;
    }

    @Override
    public Human getEmployeeById(int id) {
        return null;
    }

    @Override
    public Map<Integer, Human> getDataBase() {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public void addTasks(Task task) {

    }

    @Override
    public void setTasks(List<Task> tasks) {

    }

    @Override
    public Map<Integer, Department> getDepartments() {
        return null;
    }
}
