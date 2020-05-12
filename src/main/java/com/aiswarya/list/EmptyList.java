package com.aiswarya.list;

public class EmptyList<A> extends ValueList<A> {
    public EmptyList() {
        isEmpty = true;
    }

    @Override
    public A getHead() {
        return null;
    }

    @Override
    public ValueList<A> getTail() {
        return null;
    }

    public ValueList<A> append(A val) {
        return new ValueList<>(val, this);
    }
}
