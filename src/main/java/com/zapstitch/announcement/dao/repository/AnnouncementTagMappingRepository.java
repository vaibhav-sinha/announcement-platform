package com.zapstitch.announcement.dao.repository;

import com.zapstitch.announcement.dao.entity.AnnouncementTagMappingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by user-1 on 23/12/15.
 */
public interface AnnouncementTagMappingRepository extends PagingAndSortingRepository<AnnouncementTagMappingEntity, Long> {
}
