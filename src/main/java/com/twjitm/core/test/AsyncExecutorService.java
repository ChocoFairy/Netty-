package com.twjitm.core.test;import com.twjitm.core.player.entity.GameNettyPlayer;import org.springframework.scheduling.annotation.Async;import org.springframework.stereotype.Service;/** * spring 异步任务 * * @author twjitm - [Created on 2018-08-31 16:45] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */@Servicepublic class AsyncExecutorService {     @Async    public  void saveUser(GameNettyPlayer player){         try {             Thread.sleep(2000);         } catch (InterruptedException e) {             e.printStackTrace();         }         System.out.println("async insert db");     }}