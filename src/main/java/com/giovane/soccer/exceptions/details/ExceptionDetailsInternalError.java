package com.giovane.soccer.exceptions.details;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.time.Instant;

@SuperBuilder
@Data
public class ExceptionDetailsInternalError {
    private Integer status;
    private String title;
    private Instant timestamp;
    private String details;
    private String developerMessage;
}
