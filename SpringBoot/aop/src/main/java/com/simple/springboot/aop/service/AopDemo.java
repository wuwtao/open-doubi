package com.simple.springboot.aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: SimpleWu
 * @date: 2019/5/27
 */
@Aspect
@Component
public class AopDemo {

    /**
     * 定义一个切入点
     *
     * @author:SimpleWu
     */
    @Pointcut(value = "execution(* com.simple.springboot.aop.DemoService.*(..))")
    public void aop() {
        System.out.println("----------------->");
    }


    /**
     * 定义一个前置通知
     *
     * @author:SimpleWu
     * @Date:2018年10月12日
     */
    @Before("aop()")
    public void aopBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("前置通知 SpringBootAspect....aopBefore");
    }

    /**
     * 定义一个后置通知
     *
     * @author:SimpleWu
     * @Date:2018年10月12日
     */
    @After("aop()")
    public void aopAfter(JoinPoint point) {
        System.out.println("@After：模拟释放资源...");

        System.out.println("@After：目标方法为：" +

                point.getSignature().getDeclaringTypeName() +

                "." + point.getSignature().getName());

        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));

        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
    }

    /**
     * 处理未处理的JAVA异常
     *
     * @author:SimpleWu
     * @Date:2018年10月12日
     */
    @AfterThrowing(pointcut = "aop()", throwing = "e")
    public void exception(Exception e) {
        System.out.println("异常通知 SpringBootAspect...exception .." + e);
    }

    /**
     * 环绕通知
     *
     * @throws Throwable
     * @author:SimpleWu
     * @Date:2018年10月12日
     */
    @Around("aop()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around：执行目标方法之前...");

        //访问目标方法的参数：

        Object[] args = point.getArgs();

        if (args != null && args.length > 0 && args[0].getClass() == String.class) {

            args[0] = "改变后的参数1";

        }

        //用改变后的参数执行目标方法

        Object returnValue = point.proceed(args);

        System.out.println("@Around：执行目标方法之后...");

        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());

        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }
}
