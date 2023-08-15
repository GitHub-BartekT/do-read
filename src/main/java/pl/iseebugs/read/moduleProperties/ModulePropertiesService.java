package pl.iseebugs.read.moduleProperties;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ModulePropertiesService {
    private ModulePropertiesRepository repository;

    public ModulePropertiesService(ModulePropertiesRepository repository){
        this.repository = repository;
    }

    List<ModulePropertiesDTO> findALL(){
        return repository
                .findAll()
                .stream()
                .map(ModulePropertiesDTO::new)
                .collect(toList());
    }


    Optional<ModuleProperties> findById(Integer id) {
        return repository.findById(id);
    }

    ResponseEntity<ModuleProperties> updateProperties(int id, ModulePropertiesDTO modulePropertiesDTO){
        ModuleProperties moduleProperties = findById(id)
                .orElseThrow();

        moduleProperties.setSessionsPerDay(modulePropertiesDTO.getSessionsPerDay());
        moduleProperties.setPresentationsPerSession(modulePropertiesDTO.getPresentationsPerSession());
        moduleProperties.setNewSentencesPerDay(modulePropertiesDTO.getNewSentencesPerDay());
        moduleProperties.setActualDay(modulePropertiesDTO.getActualDay());
        moduleProperties.setNextSession(modulePropertiesDTO.getNextSession());

        return ResponseEntity.ok(repository.save(moduleProperties));
    }

    ResponseEntity<ModuleProperties> updateProperties(int id){
        ModuleProperties moduleProperties = findById(id).orElseThrow();

        if (moduleProperties.getNextSession() == moduleProperties.getSessionsPerDay()){
            moduleProperties.setActualDay(moduleProperties.getActualDay() + 1);
            moduleProperties.setNextSession(1);
        } else {
            moduleProperties.setNextSession(moduleProperties.getNextSession()+1);
        }
        return ResponseEntity.ok(repository.save(moduleProperties));
    }
}
