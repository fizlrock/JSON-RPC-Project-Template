package org.example.util;

import java.util.EventListener;
import java.util.stream.Collectors;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;

/**
 * ControllerListLogger
 */
@Component
@Slf4j
public class ControllerListLogger implements ApplicationListener<ContextRefreshedEvent> {

  private final RequestMappingHandlerMapping handler;

  public ControllerListLogger(RequestMappingHandlerMapping handler) {
    this.handler = handler;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    var methods = handler.getHandlerMethods();

    methods.entrySet().stream()
        .map(entry -> String.format("Finded controller %s : %s", entry.getKey(), entry.getValue()))
        .forEach(log::info);

  }
  public static int sum(int a, int b){
    return a + b;
    
  }

}
