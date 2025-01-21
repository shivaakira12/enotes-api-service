package com.enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.dto.NotesDTO;
import com.enotes.service.NotesService;
import com.enotes.util.CommonUtil;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@PostMapping("/save-notes")
	public ResponseEntity<?> saveNotes(@RequestBody NotesDTO notesDto) {
		Boolean savedNotes = notesService.saveNotes(notesDto);
		if (savedNotes) {
			return CommonUtil.createBuildResponse(savedNotes, HttpStatus.OK);
		} else {
			return CommonUtil.createErrorResponseMessage("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-all-notes")
	public ResponseEntity<?> getAllNotes() {
		List<NotesDTO> getAllNotes = notesService.getAllNotes();

		if (CollectionUtils.isEmpty(getAllNotes)) {
			return ResponseEntity.noContent().build();
		} else {
			return CommonUtil.createBuildResponse(getAllNotes, HttpStatus.OK);
		}
	}
}
