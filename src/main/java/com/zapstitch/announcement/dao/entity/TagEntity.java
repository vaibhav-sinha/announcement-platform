package com.zapstitch.announcement.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by user-1 on 23/12/15.
 */
@Entity
@Data
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
