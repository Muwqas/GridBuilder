package io.shapez.game;

import java.util.HashMap;
import java.util.Map;

public class HubGoals {
    private final GameRoot root;
    int level = 1;
    HashMap<String, Integer> gainedRewards = new HashMap<>();
    HashMap<String, Integer> storedShapes = new HashMap<>();
    final HashMap<String, Integer> upgradeLevels = new HashMap<>();
    final HashMap<String, Integer> upgradeImprovements = new HashMap<>();

    public HubGoals(final GameRoot root) {
        this.root = root;
        final HashMap<String, GameMode.UpgradeTiers> upgrades = this.root.gameMode.getUpgrades();
        for (final Map.Entry<String, GameMode.UpgradeTiers> entry : upgrades.entrySet()) {
            upgradeLevels.put(entry.getKey(), 0);
            upgradeImprovements.put(entry.getKey(), 1);
        }
    }

    public int getBeltBaseSpeed() {
        return GlobalConfig.beltSpeedItemsPerSecond * this.upgradeImprovements.get("belt");
    }

    public int undergroundBeltBaseSpeed() {
        return GlobalConfig.beltSpeedItemsPerSecond * this.upgradeImprovements.get("miner");
    }
}
