package com.zapstitch.announcement.dao.repository;

import com.zapstitch.announcement.dao.entity.AnnouncementEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by user-1 on 23/12/15.
 */
public interface AnnouncementRepository extends PagingAndSortingRepository<AnnouncementEntity, Long> {
}
