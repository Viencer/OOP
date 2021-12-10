package com.company;

import com.company.strategy.DowngradeStrategy;

public class DepBoss extends HumanImpl {

    public DepBoss(int id, String name, int managerId, String position) {
        super(id, name, managerId, position);
        this.positionStrategy = new DowngradeStrategy();
    }

    public DepBoss() {
    }
}
