package com.github.curriculeon.christmas;

public class LivingRoom {
    private ChristmasTreeInterface tree;

    public void insertChristmasTree(ChristmasTreeInterface tree) {
        this.tree = tree;
    }

    public boolean containsTree(ChristmasTreeInterface tree) {
        return this.tree == tree;
    }
}
