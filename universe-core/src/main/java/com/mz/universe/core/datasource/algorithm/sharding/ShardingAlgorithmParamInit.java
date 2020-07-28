package com.mz.universe.core.datasource.algorithm.sharding;

import com.mz.universe.properties.datasource.ShardingAlgorithmParamProperties;
import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingAlgorithmParamInit
 * @Package com.mz.universe.core.datasource.algorithm.sharding
 * @Description ShardingAlgorithm类内部参数初始化
 * @date 2020/7/28 10:46 上午
 */
public class ShardingAlgorithmParamInit {

    public void initTableCountParam(ShardingAlgorithmParamProperties properties) throws NotFoundException,
            CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        //获取class
        CtClass ctClass = pool.get("com.mz.universe.core.datasource.algorithm.sharding.DefaultDatabaseShardingAlgorithm");
        ///添加一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "initParam", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        //调用被代理类的方法
        ctMethod.setBody("{ databaseShardingCount=" + properties.getDatabaseShardingCount() + "; }");
        ctClass.addMethod(ctMethod);
        Object sourceProxy = ctClass.toClass().newInstance();
        //运行
        Method testRunMethod = sourceProxy.getClass().getDeclaredMethod("initParam");
        testRunMethod.invoke(sourceProxy);
    }

    public void initDatasourceCountParam(ShardingAlgorithmParamProperties properties) throws NotFoundException,
            CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        //获取class
        CtClass ctClass = pool.get("com.mz.universe.core.datasource.algorithm.sharding.DefaultTablePreciseShardingAlgorithm");
        ///添加一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "initParam", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        //调用被代理类的方法
        ctMethod.setBody("{ tableShardingCount=" + properties.getTableShardingCount() + "; }");
        ctClass.addMethod(ctMethod);
        Object sourceProxy = ctClass.toClass().newInstance();
        //运行
        Method testRunMethod = sourceProxy.getClass().getDeclaredMethod("initParam");
        testRunMethod.invoke(sourceProxy);
    }

}