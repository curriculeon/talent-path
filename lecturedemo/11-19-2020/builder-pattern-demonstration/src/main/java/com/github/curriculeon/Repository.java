package com.github.curriculeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<SomeType extends Identifiable> {
    private List<SomeType> someTypeList;

    public Repository(SomeType... someTypeList) {
        this.someTypeList = new ArrayList<>(Arrays.asList(someTypeList));
    }

    public Repository(List<SomeType> someTypeList) {
        this.someTypeList = someTypeList;
    }

    public Repository() {
        this(new ArrayList<>());
    }

    public void add(SomeType something) {
        someTypeList.add(something);
    }

    public SomeType findById(Serializable id) {
        return this.filter(someType -> someType.getId() == id).get(0);
    }

    public void delete(SomeType something) {
        someTypeList.remove(something);
    }

    public List<SomeType> filter(Predicate<SomeType> predicate) {
        return someTypeList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
