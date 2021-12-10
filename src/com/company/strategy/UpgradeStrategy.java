package com.company.strategy;

import com.company.interfaces.PositionStrategy;

public class UpgradeStrategy implements PositionStrategy {

    @Override
    public String setPosition() {
        return "DepBoss";
    }
}
