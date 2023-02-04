package programinglanguage.business;

import programinglanguage.dto.request.ProgramingLanguageRequestDTO;
import programinglanguage.dto.response.ProgramingLanguageResponseDTO;

import java.util.List;

public interface ProgramingLanguageService {

    List<ProgramingLanguageResponseDTO> getAll();
    void add(ProgramingLanguageRequestDTO programingLanguageRequestDTO);
    String delete(int id );
    String update(ProgramingLanguageRequestDTO programingLanguageRequestDTO);




}
