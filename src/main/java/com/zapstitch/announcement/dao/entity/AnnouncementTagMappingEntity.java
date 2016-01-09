package com.zapstitch.announcement.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by user-1 on 23/12/15.
 */
@Entity
@Data
@Table(name = "announcement_tag_mapping")
public class AnnouncementTagMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long announcementId;
    private Long tagId;
}
