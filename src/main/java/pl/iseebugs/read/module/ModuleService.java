package pl.iseebugs.read.module;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import pl.iseebugs.read.moduleProperties.ModulePropertiesDTO;
import pl.iseebugs.read.moduleProperties.ModulePropertiesRepository;
import pl.iseebugs.read.moduleProperties.ModulePropertiesService;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class ModuleService {
    private ModuleRepository repository;
    private ModulePropertiesRepository modulePropertiesRepository;


    ModuleService(ModuleRepository repository, ModulePropertiesRepository modulePropertiesRepository){
        this.repository = repository;
        this.modulePropertiesRepository = modulePropertiesRepository;
    }




    List<ModuleDTO> findALL(){
        return repository
                .findAll()
                .stream()
                .map(ModuleDTO::new)
                .collect(toList());
    }

    List<ModuleDTO> findOneModuleById(Integer module){
        return repository
                .findAll()
                .stream()
                .filter(s -> s.getModule() == module)
                .map(ModuleDTO::new)
                .collect(toList());
    }

    //TODO :: starting point of each module (table id - no; "module id" - yes)

    List<ModuleDTO> nextSession(Integer module){

        int firstSentence = modulePropertiesRepository.findById(module).get().getActualDay() - 1;
        int startSentence = modulePropertiesRepository.findById(module).get().getPresentationsPerSession();
        int lastSentence = firstSentence + startSentence;
        List<ModuleDTO> list = repository
                .findWszystkie(module)
                .stream()
                .map(ModuleDTO::new)
                .collect(toList());

       return list.stream()
                .filter(i -> list.indexOf(i) >= firstSentence)
                .filter(j -> list.indexOf(j) < lastSentence)
                .collect(toList());
    }

  }
