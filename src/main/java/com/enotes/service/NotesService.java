package com.enotes.service;

import java.util.List;

import com.enotes.dto.NotesDTO;

public interface NotesService {
	
	public Boolean saveNotes(NotesDTO notesDTO);
	
	public List<NotesDTO> getAllNotes();

}
