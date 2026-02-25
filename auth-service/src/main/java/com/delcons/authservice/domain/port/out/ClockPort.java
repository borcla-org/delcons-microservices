package com.delcons.authservice.domain.port.out;

import java.time.Instant;

public interface ClockPort {
    Instant now();
}
