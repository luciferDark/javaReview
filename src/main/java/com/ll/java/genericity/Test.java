package com.ll.java.genericity;

import com.ll.java.utils.Log;

import java.util.*;

public class Test<T> {
    public void run(){
        A<D> stringA = new A<D>();
        stringA.run(new D());

        Log.log(stringA.getClass().toString());

        List<TestA> testAList = new ArrayList<TestA>();
        List<TestB> testBList = new ArrayList<TestB>();

        TestA testa = new TestA();
        TestB testb = new TestB();

        testAList.sort(testa);
//        testAList.sort(testb);

        testBList.sort(testa);
        testBList.sort(testb);

         Test<B> test1 = new Test<>();

         Test<? extends A> test2 = test1;
         Test<? extends B> test3 = test1;
         Test<? super B> test4 = test1;
    }

    public void set(T t){

    }

    public T get(){
        return null;
    }

    class A<T extends B>{
        public void run(T arg){
            Log.log(arg.getClass().toString());
        }
    }

    class B extends A implements E{

    }

    class C extends A implements F{

    }

    class D extends B{

    }

    interface E{}

    interface F<T> extends E{}

    class TestA<T>implements Comparator<T>{

        @Override
        public int compare(T o1, T o2) {
            return 0;
        }
    }


    class TestB extends TestA<TestB> implements Comparator<TestB>{

        @Override
        public int compare(TestB o1, TestB o2) {
            return 0;
        }
    }

}
