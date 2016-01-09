package com.zapstitch.announcement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zapstitch.announcement.dao.entity.AnnouncementEntity;
import com.zapstitch.announcement.dao.entity.UserIdAnnouncementIdPK;
import com.zapstitch.announcement.dao.entity.UserStatusMappingEntity;
import com.zapstitch.announcement.dao.repository.AnnouncementRepository;
import com.zapstitch.announcement.dao.repository.UserStatusMappingRepository;
import com.zapstitch.announcement.pojo.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/{userId}")
public class ApiController {

	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	UserStatusMappingRepository userStatusMappingRepository;

	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public List<Announcement> get(@PathVariable Long userId, @RequestParam(value = "page") Long page, @RequestParam(value = "limit") Long limit) {
		Pageable pageable = new PageRequest(page.intValue(), limit.intValue());
		Page<AnnouncementEntity> currentPage = announcementRepository.findAll(pageable);
		List<AnnouncementEntity> announcementEntityList = currentPage.getContent();
		List<Announcement> announcementList = new ArrayList<>();

		announcementEntityList.forEach(announcementEntity -> {
			UserIdAnnouncementIdPK userIdAnnouncementIdPK = new UserIdAnnouncementIdPK();
			userIdAnnouncementIdPK.setUserId(userId);
			userIdAnnouncementIdPK.setAnnouncementId(announcementEntity.getId());
			UserStatusMappingEntity userStatusMappingEntity = userStatusMappingRepository.findOne(userIdAnnouncementIdPK);

			Announcement announcement = objectMapper.convertValue(announcementEntity, Announcement.class);

			if(userStatusMappingEntity == null) {
				announcement.setStatus("UNREAD");
			}
			else {
				announcement.setStatus(userStatusMappingEntity.getStatus());
			}

			announcementList.add(announcement);
		});

		return announcementList;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/read")
	public boolean post(@PathVariable Long userId, @RequestBody List<Long> ids) {
		List<UserStatusMappingEntity> userStatusMappingEntityList = new ArrayList<>();
		ids.forEach(id -> {
			UserStatusMappingEntity userStatusMappingEntity = new UserStatusMappingEntity();
			userStatusMappingEntity.setStatus("READ");
			UserIdAnnouncementIdPK newId = new UserIdAnnouncementIdPK();
			newId.setAnnouncementId(id);
			newId.setUserId(userId);
			userStatusMappingEntity.setId(newId);
			userStatusMappingEntityList.add(userStatusMappingEntity);
		});
		userStatusMappingRepository.save(userStatusMappingEntityList);
		return true;
	}
}