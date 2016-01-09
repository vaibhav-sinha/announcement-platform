package com.zapstitch.announcement.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by user-1 on 23/12/15.
 */
@Embeddable
@Data
public class UserIdAnnouncementIdPK implements Serializable{
    private Long userId;
    private Long announcementId;
}
