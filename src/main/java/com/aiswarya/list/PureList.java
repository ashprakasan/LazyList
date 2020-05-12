package com.aiswarya.list;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface PureList<A> {
    <R> PureList<R> map(Function<A,R> f);
    PureList<A> filter(Predicate<A> f);
    <B,R> B fold (B b, BiFunction<A,B,R> f);
    PureList<A> take(int n);
    PureList<A> append(A a);
    List<A> collect();
}
