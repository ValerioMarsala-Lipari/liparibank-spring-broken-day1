package com.lipari.bank.shared.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

  private final LipariBankProperties properties;
  private final ObjectProvider<ConfigAuditEntry> auditEntryProvider;

  public ConfigController(
      LipariBankProperties properties,
      ObjectProvider<ConfigAuditEntry> auditEntryProvider
  ) {
    this.properties = properties;
    this.auditEntryProvider = auditEntryProvider;
  }

  @GetMapping
  public ConfigResponse getConfig() {
    ConfigAuditEntry auditEntry = auditEntryProvider.getObject();

    return new ConfigResponse(
        properties.bankCode(),
        properties.maxTransferAmount(),
        properties.audit(),
        auditEntry
    );
  }
}