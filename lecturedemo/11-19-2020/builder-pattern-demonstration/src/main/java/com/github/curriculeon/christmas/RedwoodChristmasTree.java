package com.github.curriculeon.christmas;

public class RedwoodChristmasTree implements ChristmasTreeInterface {
    ChristmasTreeInterface decoration;

    public RedwoodChristmasTree(ChristmasTreeInterface decoration) {
        this.decoration = decoration;
    }

    @Override
    public void occupySpace() {
        System.out.println(toString());
        decoration.occupySpace();
    }

    @Override
    public String toString() {
        return "RedwoodChristmasTree{" +
                "decoration=" + decoration +
                '}';
    }
}
