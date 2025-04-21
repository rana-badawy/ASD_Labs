package miu.edu.cs.cs489.finalexam.exception;

import java.time.Instant;

public record ApiError(
        String message,
        String path,
        Integer httpStatusCode,
        Instant instant
) {
}
