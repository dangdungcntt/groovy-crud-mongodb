package com.nddcoder.demogroovy.exception

import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@CompileStatic
class ResourceNotFoundException extends ResponseStatusException {
    ResourceNotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason)
    }
}
