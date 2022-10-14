package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    protected int id;
    protected static int nextId = 1;
    protected String value;

    protected JobField(){
        id = nextId;
        nextId++;
    }

    protected JobField(String value){
        this();
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
