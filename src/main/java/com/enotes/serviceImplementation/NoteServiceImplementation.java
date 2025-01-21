package com.enotes.serviceImplementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.NotesDTO;
import com.enotes.entity.Notes;
import com.enotes.repository.NotesRepository;
import com.enotes.service.NotesService;

@Service
public class NoteServiceImplementation implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveNotes(NotesDTO notesDTO) {

		// validation notes

		Notes notes = mapper.map(notesDTO, Notes.class);
		Notes savedNotes = notesRepository.save(notes);
		savedNotes.setCreatedBy(1);
		if (!ObjectUtils.isEmpty(savedNotes)) {
			return true;
		}
		return false;
	}

	@Override
	public List<NotesDTO> getAllNotes() {

		return notesRepository.findAll().stream().map(note -> mapper.map(note, NotesDTO.class)).toList();
	}

}
