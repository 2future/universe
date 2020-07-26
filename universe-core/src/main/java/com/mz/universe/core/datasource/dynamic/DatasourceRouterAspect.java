package com.mz.universe.core.datasource.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * @author mz
 * @version V1.0
 * @Title DatasourceRouterAspect
 * @Package com.mz.universe.core.datasource.dynamic
 * @Description 数据源切面
 * @date 2020/7/24 5:10 下午
 */
@Aspect
@Order(Integer.MIN_VALUE)
public class DatasourceRouterAspect {

    @Around("@annotation(DatasourceRouter)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        try (ContextDatasourceTypeHolder contextDatasourceTypeHolder = new ContextDatasourceTypeHolder()) {
            //获取目标类
            Class<?> targetClazz = joinPoint.getTarget().getClass();
            //获取执行的方法名
            String methodName = joinPoint.getSignature().getName();
            //获取此方法的参数列表
            Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            //获取到实际执行的方法
            Method objMethod = targetClazz.getMethod(methodName, par);
            //从执行的方法上获取注解
            DatasourceRouter annotation = objMethod.getAnnotation(DatasourceRouter.class);
            if (annotation != null) {
                //将注解上指定的数据源类型读取到
                String datasourceType = annotation.datasource().getName();
                //设置当前处理的数据源类型为注解上指定的
                contextDatasourceTypeHolder.setDatasourceName(datasourceType);
            }
            Object result = joinPoint.proceed();
            return result;
        }
    }

}