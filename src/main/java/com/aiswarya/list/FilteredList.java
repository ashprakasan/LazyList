package com.aiswarya.list;

import java.util.function.Predicate;

public class FilteredList<A> extends ValueList<A> {
    ValueList<A> valueList;
    Predicate<A> func;

    public FilteredList(ValueList<A> valueList, Predicate<A> func) {
        this.valueList = valueList;
        this.func = func;
        this.isEmpty = valueList.isEmpty;
    }

    public A getHead() {
        A head = valueList.getHead();
        valueList = valueList.getTail();
        while(!(head == null) && !func.test(head)) {
            head = this.getTail().getHead();
            valueList = this.getTail();
        }
        return head;
    }

    public FilteredList<A> getTail() {
        if(valueList.isEmpty)
            return new FilteredList<>(new EmptyList<>(),func);
        return new FilteredList<>(valueList.getTail(),func);
    }

    @Override
    public ValueList<A> filter(Predicate<A> f) {
        return new FilteredList<>(valueList,func.and(f));
    }
}
