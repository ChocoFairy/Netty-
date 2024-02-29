package com.twjitm.core.common.factory;import com.twjitm.core.common.netstack.entity.rpc.NettyRpcRequestMessage;import com.twjitm.core.utils.logs.LoggerUtils;import org.apache.log4j.Logger;import org.springframework.stereotype.Service;import java.util.UUID;/** * rpc请求消息工厂。主要用于rpc请求消息的生产。 * * @author twjitm - [Created on 2018-08-20 14:49] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */public class NettyRpcRequestFactory {    private Logger logger = LoggerUtils.getLogger(NettyRpcRequestFactory.class);    /**     * 创建一个rpc 请求消息，     *     * @param className  请求类名称     * @param methodName 方法名称     * @param args       方法参数     * @return     */    public NettyRpcRequestMessage createNettyRpcRequestMessage(String className, String methodName, Object[] args) {        NettyRpcRequestMessage request = new NettyRpcRequestMessage();        request.setRequestId(UUID.randomUUID().toString());        request.setClassName(className);        request.setMethodName(methodName);        request.setParameters(args);        Class[] parameterTypes = new Class[args.length];        // 获得参数类型        for (int i = 0; i < args.length; i++) {            parameterTypes[i] = getClassType(args[i]);        }        request.setParameterTypes(parameterTypes);        //日志        if (logger.isDebugEnabled()) {            logger.debug(methodName);            logger.debug(className);            logger.info(args);            for (int i = 0; i < parameterTypes.length; ++i) {                logger.debug(parameterTypes[i].getName());            }            for (int i = 0; i < args.length; ++i) {                logger.debug(args[i].toString());            }        }        return request;    }    /**     * 根据参数类获取参数类型     *     * @param arg     * @return     */    private Class getClassType(Object arg) {        Class<?> classType = arg.getClass();        String typeName = classType.getName();        switch (typeName) {            case "java.lang.Integer":                return Integer.TYPE;            case "java.lang.Long":                return Long.TYPE;            case "java.lang.Float":                return Float.TYPE;            case "java.lang.Double":                return Double.TYPE;            case "java.lang.Character":                return Character.TYPE;            case "java.lang.Boolean":                return Boolean.TYPE;            case "java.lang.Short":                return Short.TYPE;            case "java.lang.Byte":                return Byte.TYPE;        }        return classType;    }}