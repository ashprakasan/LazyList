package com.aiswarya.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ValueList<A> implements PureList<A> {
    private A head;
    private ValueList<A> tail;
    boolean isEmpty;

    public ValueList() {
        isEmpty = true;
    }

    public A getHead() {
        return head;
    }

    public ValueList<A> getTail() {
        return tail;
    }

    public ValueList(A head, ValueList<A> tail) {
        this.head = head;
        this.tail = tail;
        isEmpty = false;
    }

    public ValueList(A head) {
        this(head, new EmptyList<>());
        isEmpty = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<A> collectedList = this.collect();
        for (A each : collectedList) {
            sb.append(each).append(", ");
        }
        return sb.toString();
    }

    @Override
    public ValueList<A> append(A val) {
        if (this.isEmpty) {
            return new ValueList<>(val, new EmptyList<>());
        }
        return new ValueList<>(val, this);
    }

    @Override
    public <B> ValueList<B> map(Function<A, B> f) {
        return new MappedList<>(this, f);
    }

    @Override
    public ValueList<A> filter(Predicate<A> f) {
        return new FilteredList<>(this, f);
    }

    @Override
    public Object fold(Object o, BiFunction f) {
        return null;
    }

    @Override
    public PureList take(int n) {
        return null;
    }

    public List<A> collect() {
        if (isEmpty)
            return new ArrayList<>();
        List<A> arrayList = new ArrayList<>();
        arrayList.add(this.getHead());
        arrayList.addAll(this.getTail().collect());
        return arrayList;
    }

}
