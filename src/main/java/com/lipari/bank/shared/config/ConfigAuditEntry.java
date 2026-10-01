package com.lipari.bank.shared.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@Scope("prototype")
public class ConfigAuditEntry {

  private final String id;
  private final Instant timestamp;

  public ConfigAuditEntry() {
    this.id = UUID.randomUUID().toString();
    this.timestamp = Instant.now();
  }

  public String getId() {
    return id;
  }

  public Instant getTimestamp() {
    return timestamp;
  }
}