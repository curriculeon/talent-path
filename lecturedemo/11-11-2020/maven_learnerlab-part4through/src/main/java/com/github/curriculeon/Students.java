package com.github.curriculeon;

public final class Students extends People {
    private static final Students INSTANCE = new Students();

    private Students() {
        add(new Student(0L, "C Avalo"));
        add(new Student(1L, "Brian Loveless"));
        add(new Student(2L, "Brandt Campbell"));
        add(new Student(3L, "Trevor"));
        add(new Student(4L, "Neely Mann"));
        add(new Student(5L, "Michal"));
    }

    public static Students getInstance() {
        return INSTANCE;
    }
}

