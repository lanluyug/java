package com.lanluyug.java8.ch04;

import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {

    @Test
    public void test(){

        Optional<String> a = Optional.of("a");
        assert a.get().equals("a");

        Optional<String> emptyOptional = Optional.empty();

        Optional alsoEmpty = Optional.ofNullable(null);

        assert emptyOptional.isPresent() == false;

        assert a.isPresent();

        assert "b".equals(emptyOptional.orElse("b"));

        assert "c".equals(emptyOptional.orElseGet(()->"c"));
    }
}
