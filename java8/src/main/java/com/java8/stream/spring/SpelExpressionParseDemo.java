package com.java8.stream.spring;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelExpressionParseDemo {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 2");
        Object value = expression.getValue();
        System.out.println(value);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name","测试");
        context.setVariable("hobby", "篮球");
        Expression expression1 = parser.parseExpression("#name + 'hobby is :'+ #hobby");
        Object value1 = expression1.getValue(context);
        System.out.println(value1);
    }
}
