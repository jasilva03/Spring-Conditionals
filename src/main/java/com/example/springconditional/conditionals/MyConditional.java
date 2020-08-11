package com.example.springconditional.conditionals;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        boolean testProperty = Boolean.parseBoolean(conditionContext.getEnvironment().getProperty("testProperty"));
        return  testProperty;

    }

}
