package com.twjitm.core.common.service.rpc.server;import com.twjitm.core.common.enums.NettyGameTypeEnum;import org.jdom2.DataConversionException;import org.jdom2.Element;import java.util.BitSet;/** * @author twjitm - [Created on 2018-08-20 14:20] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */public class NettySdRpcServiceProvider {    private BitSet bitSet = new BitSet();    public void load(Element element) throws DataConversionException {        String boenumString = element.getAttribute("boenum").getValue();        NettyGameTypeEnum boEnum = NettyGameTypeEnum.valueOf(boenumString.toUpperCase());        bitSet.set(boEnum.getBoId(), true);    }    //是否世界开放    public boolean isWorldOpen(){        return bitSet.get(NettyGameTypeEnum.WORLD.getBoId());    }    public boolean isGameOpen(){        return bitSet.get(NettyGameTypeEnum.GAME.getBoId());    }    public boolean isDbOpen(){        return bitSet.get(NettyGameTypeEnum.DB.getBoId());    }    public boolean validServer(int boId){        return bitSet.get(boId);    }}