package util;

import dao.Identifiable;

public abstract class AbstractValidator<E>{
    public abstract void validate(E entity);
}
