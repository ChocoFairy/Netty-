package com.twjitm.core.utils.time.timer;/** * @author twjitm - [Created on 2018-08-31 10:36] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */public interface ExpirationListener<E> {    /**     * 过期的任务清理     *     * @param expireObject     */    void expired(E expireObject);}