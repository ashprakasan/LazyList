package com.aiswarya.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MappedList<A, B> extends ValueList<B> {
    ValueList<A> valueList;
    Function<A, B> func;

    public MappedList(ValueList<A> valueList, Function<A, B> func) {
        this.valueList = valueList;
        this.func = func;
        this.isEmpty = valueList.isEmpty;
    }

    @Override
    public <C> MappedList<A, C> map(Function<B, C> f) {
        return new MappedList<>(valueList, func.andThen(f));
    }

    @Override
    public B getHead() {
        if (valueList.isEmpty)
            return null;
        return func.apply(valueList.getHead());
    }

    @Override
    public ValueList<B> getTail() {
        if (valueList.isEmpty)
            return null;
        return new MappedList<>(valueList.getTail(), func);
    }

   @Override
    public  ValueList<B> filter(Predicate<B> f) {
        return new FilteredList<>(this,f);

    }

//
//    @Override
//    public <B1, R> B1 fold(B1 b1, BiFunction<B, B1, R> f) {
//        return null;
//    }
//
//    @Override
//    public PureList<B> take(int n) {
//        return null;
//    }
//
//    @Override
//    public PureList<B> append(B b) {
//        return null;
//    }

//    public List<B> collect() {
//        return this.recursiveCollect(new ArrayList<>());
//    }

//    private List<B> recursiveCollect(List<B> collectedList) {
//        if (valueList.isEmpty) {
//            return collectedList;
//        }
//        collectedList.add(func.apply(valueList.getHead()));
//        MappedList<A, B> tailMappedList = new MappedList<>(valueList.getTail(), func);
//        return tailMappedList.recursiveCollect(collectedList);
//    }
}
