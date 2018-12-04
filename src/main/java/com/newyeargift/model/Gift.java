package com.newyeargift.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Gift implements Serializable {

    private String name;
    private Map<Sweet, Integer> sweets;

    public Gift(String name, Map<Sweet, Integer> sweets) {
        this.name = name;
        this.sweets = sweets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Sweet, Integer> getSweets() {
        return sweets;
    }

    public void setSweets(Map<Sweet, Integer> sweets) {
        this.sweets = sweets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(name, gift.name) &&
                Objects.equals(sweets, gift.sweets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sweets);
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                ", sweets=" + sweets +
                '}';
    }
}
