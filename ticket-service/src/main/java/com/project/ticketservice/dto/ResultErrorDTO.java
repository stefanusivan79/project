package com.project.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by fani on 4/23/15.
 */
@Data
public class ResultErrorDTO {

    private String error;
    @JsonProperty("error_description")
    private String errorDescription;

    public ResultErrorDTO() {
    }

    public ResultErrorDTO(String message, String result) {
        this.errorDescription = message;
        this.error = result;
    }
}
