package org.example.gameprogress.model;

import java.util.ArrayList;
import java.util.List;

public class GameProgress {
    private String world;
    private int level;
    private int energy;
    private List<String> skills;

    public GameProgress(String world, int level, int energy, List<String> skills) {
        this.world = world;
        this.level = level;
        this.energy = energy;
        this.skills = new ArrayList<>(skills);
    }

    public GameMemento save() {
        return new GameMemento(world, level, energy, new ArrayList<>(skills));
    }

    public void restore(GameMemento memento) {
        this.world = memento.getWorld();
        this.level = memento.getLevel();
        this.energy = memento.getEnergy();
        this.skills = new ArrayList<>(memento.getSkills());
    }

    public String getWorld() { return world; }
    public int getLevel() { return level; }
    public int getEnergy() { return energy; }
    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        return "Mundo: " + world + ", Nível: " + level + ", Energia: " + energy + ", Habilidades: " + skills;
    }
}
