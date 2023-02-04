package programinglanguage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import programinglanguage.business.ProgramingLanguageService;
import programinglanguage.dto.request.ProgramingLanguageRequestDTO;
import programinglanguage.dto.response.ProgramingLanguageResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/programing")
public class ProgramingLanguageController {

    @Autowired
    ProgramingLanguageService programingLanguageService;


    @GetMapping("/getall")
    public List<ProgramingLanguageResponseDTO> gelAll() {
        return programingLanguageService.getAll();
    }

    @PostMapping("/add")
    public void add(ProgramingLanguageRequestDTO programingLanguageRequestDTO){
        programingLanguageService.add(programingLanguageRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
       return programingLanguageService.delete(id);
    }

    @PostMapping("/update")
    public String update (ProgramingLanguageRequestDTO programingLanguageRequestDTO){
        return programingLanguageService.update(programingLanguageRequestDTO);
    }

}
