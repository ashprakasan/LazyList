//package com.aiswarya.list;
//
//import java.util.function.BiFunction;
//
//public class ReducedList<A> extends ValueList<A> {
//
//    public ReducedList(ValueList<A> valueList, BiFunction<A, A, A> func, A seed) {
//        this.valueList = valueList;
//        this.func = func;
//        this.seed = seed;
//    }
//
//    ValueList<A> valueList;
//    BiFunction<A,A,A> func;
//    A seed;
//
//    public A getHead() {
//        A head = valueList.getHead();
//        return func.apply(seed,head);
//    }
//
//    public ValueList<A> getTail() {
//        return new ReducedList<>(valueList.getTail(), func, this.getHead());
//    }
//
//    public
//}
