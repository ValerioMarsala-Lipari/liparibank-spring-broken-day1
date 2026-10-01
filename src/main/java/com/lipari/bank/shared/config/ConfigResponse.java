package com.lipari.bank.shared.config;

import java.math.BigDecimal;

public record ConfigResponse(
    String bankCode,
    BigDecimal maxTransferAmount,
    LipariBankProperties.Audit audit,
    ConfigAuditEntry auditEntry
) {
}