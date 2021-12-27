package com.java8.stream.lamda;

import com.java8.stream.lamda.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 Function：一个入参，一个返回值。
 Consumer：一个入参，无返回值。
 Supplier：无入参，有返回值。
 Predicate：一个入参，返回boolean。
 UnaryOperator：一个入参，入参和返回值的类型相同。
 */
public class LambdaTest {

    public List<User> filter(List<User> list, Predicate<User> filterFun) {
        ArrayList<User> temp = new ArrayList<>();
        list.forEach(user -> {
            if (filterFun.test(user)) {
                temp.add(user);
            }
        });
        return temp;
    }

    public static void main(String[] args) {
        List<String> lists = new ArrayList<String>();
        lists.forEach(e-> {System.out.println(e); System.out.println(Double.NaN);});
//        MyFunctional reuslt = (a,b)-> {return a +b;};
//        int myaccept = reuslt.myaccept(1, 2);
//        System.out.println(myaccept);
//
//        MyFunctionalImpl myFunctional = new MyFunctionalImpl();
//        int myaccept1 = myFunctional.myaccept(2, 3);
//        System.out.println(myaccept1);

//        System.out.println("Function 类测试");
//        Function<Date, String> dateConvert = e -> {return new SimpleDateFormat("yyyy-MM-dd").format(e);};
//        String dateStr = dateConvert.apply(new Date());
//        System.out.println(dateStr);

//        System.out.println("Consumer 类测试");
//        Consumer<String> consumerTest = e -> {
//            System.out.println(e);
//        };
//        consumerTest.accept("测试");

//        Supplier<Integer> random = () -> {
//            return new Random().nextInt();
//        };
//        System.out.println(random.get());

//        Predicate<Integer> compare = e -> {
//            return e > 5;
//        };
//        System.out.println(compare.test(6));

//        UnaryOperator<Integer> plus = e -> {
//            return e + e;
//        };
//        System.out.println(plus.apply(10));

        LambdaTest lambdaTest = new LambdaTest();

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("test" + i);
            user.setDeptNo(new Random().nextInt());
            users.add(user);
        }
        System.out.println("================过滤前=============");
        users.stream().forEach(e-> System.out.println(e));
//        List<User> filter = lambdaTest.filter(users, e -> {
//            return e.getAge() > 4;
//        });
        List<User> filter = users.stream().filter(e-> {return e.getAge() > 4;}).collect(Collectors.toList());
        System.out.println("================筛选后=============");
        filter.forEach(e-> System.out.println(e));
    }


}
