package com.twjitm.core.common.check;import com.twjitm.core.common.config.global.GlobalConstants;import com.twjitm.core.common.config.global.NettyGameServiceConfigService;import com.twjitm.core.common.service.IService;import com.twjitm.core.spring.SpringServiceManager;import com.twjitm.core.utils.time.timer.PollTimer;import org.springframework.stereotype.Service;/** * 生命周期检测 * * @author twjitm - [Created on 2018-08-31 10:21] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */@Servicepublic class NettyLifeCycleCheckService implements IService {    /**     * 周期时间轮询器     */    private PollTimer<Integer> pollTimer;    /**     * 是否开放     */    private boolean open;    @Override    public String getId() {        return NettyLifeCycleCheckService.class.getSimpleName();    }    @Override    public void startup() throws Exception {        NettyGameServiceConfigService config = SpringServiceManager.getSpringLoadService()                .getNettyGameServiceConfigService();        open = config.getNettyGameServiceConfig().isLifeCycleOpen();        if (open) {            pollTimer = new PollTimer<>(                    GlobalConstants.PollTimer.tickDuration, GlobalConstants.PollTimer.timeUnit,                    GlobalConstants.PollTimer.ticksPerPoll);            pollTimer.start();        }    }    @Override    public void shutdown() throws Exception {        if (open) {            pollTimer.stop();        }    }}