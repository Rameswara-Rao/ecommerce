package dev.ram.prosuctServicettseveninga.models;

import lombok.*;

import java.util.Date;

@Setter
@Getter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}