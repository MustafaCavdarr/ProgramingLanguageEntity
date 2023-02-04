package week.week5h2.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week.week5h2.dto.request.ProgramingLanguageRequestDTO;
import week.week5h2.dto.response.ProgramingLanguageResponseDTO;
import week.week5h2.dto.response.SubTechnologyResponseDTO;
import week.week5h2.entity.ProgramingLanguageEntity;
import week.week5h2.entity.SubTechnologyEntity;
import week.week5h2.repository.ProgramingLanguageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService{
    @Autowired
    ProgramingLanguageRepository programingLanguageRepository;

    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
        this.programingLanguageRepository = programingLanguageRepository;
    }

    @Override
    public List<ProgramingLanguageResponseDTO> getAll() {

        List<ProgramingLanguageEntity> all = programingLanguageRepository.findAll();

        /*   ObjectMapper mapper =new ObjectMapper();
        JavaType javaType=mapper.getTypeFactory().constructCollectionType(List.class,ProgramingLanguageDTO.class);
        return mapper.convertValue(all, javaType);*/

        List<ProgramingLanguageResponseDTO> programingLanguageResponseDTOS =new ArrayList<>();
        for (ProgramingLanguageEntity prop:all) {
            ProgramingLanguageResponseDTO programingLanguageResponseDTO =new ProgramingLanguageResponseDTO();
            List<SubTechnologyResponseDTO> subTechnologyResponseDTOS =new ArrayList<>();
            for (SubTechnologyEntity subTechnologyEntity:prop.getSubTechnologyEntities()){
                SubTechnologyResponseDTO subTechnologyResponseDTO =new SubTechnologyResponseDTO();
                subTechnologyResponseDTO.setId(subTechnologyEntity.getId());
                subTechnologyResponseDTO.setName(subTechnologyEntity.getName());
                subTechnologyResponseDTOS.add(subTechnologyResponseDTO);
            }
            programingLanguageResponseDTO.setId(prop.getId());
            programingLanguageResponseDTO.setName(prop.getName());
            programingLanguageResponseDTO.setSubTechnologyResponseDTOS(subTechnologyResponseDTOS);
            programingLanguageResponseDTOS.add(programingLanguageResponseDTO);
        }
        return programingLanguageResponseDTOS;
    }
    @Override
    public void add(ProgramingLanguageRequestDTO programingLanguageRequestDTO) {
        ProgramingLanguageEntity entity=new ProgramingLanguageEntity();
        entity.setName(programingLanguageRequestDTO.getName());
        programingLanguageRepository.save(entity);
    }
    @Override
    public String delete(int id ) {
        ProgramingLanguageEntity entity=new ProgramingLanguageEntity();
        entity.setId(id);
        Optional<ProgramingLanguageEntity> byId = programingLanguageRepository.findById(id);
        if (byId.isPresent()){
            programingLanguageRepository.delete(entity);
            return "Silme işlemi tamamlandı...";
        }

        return "Veritabanında kayıt bulunamadı...";

    }

    @Override
    public String update(ProgramingLanguageRequestDTO programingLanguageRequestDTO) {
        ProgramingLanguageEntity entity=new ProgramingLanguageEntity();
        entity.setName(programingLanguageRequestDTO.getName());
        entity.setId(programingLanguageRequestDTO.getId());

        Optional<ProgramingLanguageEntity> byId = programingLanguageRepository.findById(entity.getId());
        if (byId.isPresent()){
            programingLanguageRepository.save(entity);
            return "Güncellleme işlemi tamamlandı...";
        }

        return "Veritabanında kayıt bulunamadı...";


    }


}
