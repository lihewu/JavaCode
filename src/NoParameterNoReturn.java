/**
 * 函数式接口，其内部只能有一个抽象方法
 */
//无返回无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
    default void prt(){
        System.out.println("函数式接口的默认实现已调用");
    }
}


//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}