package com.company.strategy;

import com.company.enums.Positions;

public class UpgradeStrategy implements PositionStrategy {

    @Override
    public Positions setPosition() {
        return Positions.DEP_BOSS;
    }
}
