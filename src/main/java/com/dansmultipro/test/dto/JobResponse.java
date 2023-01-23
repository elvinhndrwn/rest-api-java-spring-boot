package com.dansmultipro.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobResponse {
    private String id;
    private String url;
    private String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd HH:mm:ss Z yyyy")
    @JsonProperty("created_at")
    private Date createdAt;
    private String company;
    @JsonProperty("company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    @JsonProperty("company_logo")
    private String companyLogo;
}
