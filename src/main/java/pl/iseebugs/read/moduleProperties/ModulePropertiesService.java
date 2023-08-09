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

    ResponseEntity<ModuleProperties> updateProperties(ModulePropertiesDTO modulePropertiesDTO){
        ModuleProperties moduleProperties = new ModuleProperties();
        moduleProperties.setId(modulePropertiesDTO.getId());
        moduleProperties.setSessionsPerDay(modulePropertiesDTO.getSessionsPerDay());
        moduleProperties.setPresentationsPerSession(modulePropertiesDTO.getPresentationsPerSession());
        moduleProperties.setNewSentencesPerDay(modulePropertiesDTO.getNewSentencesPerDay());
        moduleProperties.setActualDay(modulePropertiesDTO.getActualDay());
        moduleProperties.setNextSession(modulePropertiesDTO.getNextSession());
       return ResponseEntity.ok(repository.save(moduleProperties));
    }
}
