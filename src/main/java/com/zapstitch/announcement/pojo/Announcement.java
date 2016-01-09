package com.zapstitch.announcement.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by user-1 on 23/12/15.
 */
@Data
public class Announcement implements Serializable {
    private Long id;
    private String heading;
    private String summary;
    private String description;
    private Boolean active;
    private Date createdAt;
    private Date updatedAt;
    private String status;
}
