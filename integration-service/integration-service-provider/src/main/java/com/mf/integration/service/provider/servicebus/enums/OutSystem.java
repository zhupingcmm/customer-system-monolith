package com.mf.integration.service.provider.servicebus.enums;

import lombok.Getter;

public enum OutSystem {

  SHANGHAI(1L, "shanghai_router", "shanghai_transformer"),
  BEIJING(2L, "beijing_router", "beijing_transformer"),
  HANGZHOU(3L, "hangzhou_router", "hangzhou_transformer");
  @Getter
  private Long id;
  @Getter
  private String router;

  @Getter
  private String transformer;
  OutSystem(Long id, String router, String transformer){
    this.id = id;
    this.router = router;
    this.transformer = transformer;
  }

}
