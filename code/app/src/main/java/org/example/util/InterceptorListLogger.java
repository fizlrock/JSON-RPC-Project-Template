package org.example.util;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InterceptorListLogger implements ApplicationListener<ContextRefreshedEvent> {

  private List<HandlerInterceptor> chains;

  public InterceptorListLogger(List<HandlerInterceptor> chains) {
    this.chains = chains;

  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info(chains.toString());
  }

}
