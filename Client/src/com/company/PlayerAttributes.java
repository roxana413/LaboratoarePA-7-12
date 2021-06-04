package com.company;

import java.util.Objects;

public class PlayerAttributes {
    private String name;

    public PlayerAttributes() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerAttributes)) return false;
        PlayerAttributes that = (PlayerAttributes) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
