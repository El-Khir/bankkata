package org.example.domain;

import java.util.Objects;

public abstract class AbstractWrapper<T>  {

    protected final T value;

    public AbstractWrapper(T value) {
        checkValidity(value);
        this.value = value;
    }

    private void checkValidity(T value) {
        if(!isValid(value)) {
            throw new IllegalArgumentException("Value must not be null");
        }
    }

    private boolean isValid(T value) {
        return value != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWrapper<?> that = (AbstractWrapper<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
