package org.example.gameprogress.model;

import java.util.List;

public class GameMemento {
    private final String world;
    private final int level;
    private final int energy;
    private final List<String> skills;

    public GameMemento(String world, int level, int energy, List<String> skills) {
        this.world = world;
        this.level = level;
        this.energy = energy;
        this.skills = skills;
    }

    public String getWorld() { return world; }
    public int getLevel() { return level; }
    public int getEnergy() { return energy; }
    public List<String> getSkills() { return skills; }
}
