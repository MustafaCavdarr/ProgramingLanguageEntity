package week.week5h2.business;

import week.week5h2.dto.request.ProgramingLanguageRequestDTO;
import week.week5h2.dto.response.ProgramingLanguageResponseDTO;

import java.util.List;

public interface ProgramingLanguageService {

    List<ProgramingLanguageResponseDTO> getAll();
    void add(ProgramingLanguageRequestDTO programingLanguageRequestDTO);
    String delete(int id );
    String update(ProgramingLanguageRequestDTO programingLanguageRequestDTO);




}
