package com.fiktionmaps.fiktionmaps.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterestDTO {
    private Long id;
    private Long userId;
    private Long fictionId;
    private Date createdAt;
} 