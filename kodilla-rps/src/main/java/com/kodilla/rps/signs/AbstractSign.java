package com.kodilla.rps.signs;

import java.util.List;
import java.util.Objects;

public abstract class AbstractSign implements ISign {
    protected String name;
    protected List<ISign> weakerThan;
    protected List<ISign> strongerThan;

    public Boolean isStrongerThan(ISign sign) {
        if (this.weakerThan.contains(sign)) {
            return false;
        } else if (this.strongerThan.contains(sign)) {
            return true;
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSign that = (AbstractSign) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Sign: " + name;
    }

    public String getName() {
        return this.name;
    }
}
