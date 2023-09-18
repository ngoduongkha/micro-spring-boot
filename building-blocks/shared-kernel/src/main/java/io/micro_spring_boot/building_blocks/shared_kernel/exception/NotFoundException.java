package io.micro_spring_boot.building_blocks.shared_kernel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
