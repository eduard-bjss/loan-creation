package com.bjss.accelerator.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public interface JsonSource {
    ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build().enable(SerializationFeature.INDENT_OUTPUT);;
    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JsonSource.class);

    default Optional<String> toJson() {
        try {
            return Optional.ofNullable(mapper.writeValueAsString(this));
        } catch (JsonProcessingException e) {
            log.error("Error converting Loan object to Json", e);
            return Optional.empty();
        }
    }
}
