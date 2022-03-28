package util;

import dao.Identifiable;
import dao.exception.ConstraintViolationException;

public abstract class EntityValidator< I,E extends Identifiable<I>>{
   private String uniqueStringIdentifier;

    public String getUniqueStringIdentifier() {
        return uniqueStringIdentifier;
    }


    public void setUniqueStringIdentifier(String uniqueStringIdentifier) {
        this.uniqueStringIdentifier = uniqueStringIdentifier;
    }

    public abstract void validate(E entity) throws ConstraintViolationException;
}
