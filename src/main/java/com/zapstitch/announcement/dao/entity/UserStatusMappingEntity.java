package com.zapstitch.announcement.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by user-1 on 23/12/15.
 */
@Entity
@Data
@Table(name = "user_status_mapping")
public class UserStatusMappingEntity {

    @EmbeddedId
    private UserIdAnnouncementIdPK id;
    private String status;
}
