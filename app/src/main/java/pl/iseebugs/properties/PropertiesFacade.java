package pl.iseebugs.properties;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.iseebugs.ports.PropertiesService;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class PropertiesFacade implements PropertiesService {
    private final ModulePropertiesRepository modulePropertiesRepository;

    public PropertiesFacade(ModulePropertiesRepository modulePropertiesRepository){
        this.modulePropertiesRepository = modulePropertiesRepository;
    }

    @Override
    public List<PropertiesDTO> findALL(){
        return modulePropertiesRepository
                .findAll()
                .stream()
                .map(PropertiesDTO::new)
                .collect(toList());
    }

    @Override
    public Optional<ModuleProperties> findById(Integer id) {
        return modulePropertiesRepository.findById(id);
    }

    @Override
    public ModuleProperties updateProperties(int id, PropertiesDTO propertiesDTO){
        ModuleProperties moduleProperties = findById(id)
                .orElseThrow();

        moduleProperties.setSessionsPerDay(propertiesDTO.getSessionsPerDay());
        moduleProperties.setPresentationsPerSession(propertiesDTO.getPresentationsPerSession());
        moduleProperties.setNewSentencesPerDay(propertiesDTO.getNewSentencesPerDay());
        moduleProperties.setActualDay(propertiesDTO.getActualDay());
        moduleProperties.setNextSession(propertiesDTO.getNextSession());

        return modulePropertiesRepository.save(moduleProperties);
    }

    @Override
    public ModuleProperties updateProperties(int id){
        ModuleProperties moduleProperties = findById(id).orElseThrow();

        if (moduleProperties.getNextSession() == moduleProperties.getSessionsPerDay()){
            moduleProperties.setActualDay(moduleProperties.getActualDay() + 1);
            moduleProperties.setNextSession(1);
        } else {
            moduleProperties.setNextSession(moduleProperties.getNextSession()+1);
        }
        return modulePropertiesRepository.save(moduleProperties);
    }
}
