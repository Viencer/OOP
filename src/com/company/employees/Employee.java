package com.company.employees;

import com.company.employees.HumanImpl;
import com.company.enums.Positions;
import com.company.strategy.UpgradeStrategy;

public class Employee extends HumanImpl {

    public Employee(int id, String name, int managerId, Positions position) {
        super(id, name, managerId, position);
        this.positionStrategy = new UpgradeStrategy();
    }

    public Employee() {
    }
}
