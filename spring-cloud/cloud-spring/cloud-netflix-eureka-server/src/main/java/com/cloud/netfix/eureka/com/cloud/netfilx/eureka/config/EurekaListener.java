package com.cloud.netfix.eureka.com.cloud.netfilx.eureka.config;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * Eureka事件监听
 * @author SimpleWu
 */
@Component
public class EurekaListener {

    private final  Logger log = LoggerFactory.getLogger(EurekaListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.debug(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.debug(instanceInfo.getAppName() + "进行注册");
    }
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.debug(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.debug("注册中心 启动");
    }
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.debug("Eureka Server 启动");
    }
}
