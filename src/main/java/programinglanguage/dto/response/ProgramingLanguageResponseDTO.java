package programinglanguage.dto.response;

import lombok.Data;
import java.util.List;
@Data
public class ProgramingLanguageResponseDTO {

    private int id;
    private String name;
    private List<SubTechnologyResponseDTO> subTechnologyResponseDTOS;
}
