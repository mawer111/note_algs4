package study.ss.book.algs4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
public @interface Algorithm {

    String value();

}
