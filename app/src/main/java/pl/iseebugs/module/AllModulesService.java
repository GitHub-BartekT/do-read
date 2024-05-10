package pl.iseebugs.module;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class AllModulesService {
    private final AllModulesRepository allModulesRepository;

    AllModulesService(AllModulesRepository allModulesRepository){
        this.allModulesRepository = allModulesRepository;
    }

    List<AllModulesDTO> findALL(){
        return allModulesRepository
                .findAll()
                .stream()
                .map(AllModulesDTO::new)
                .collect(toList());
    }

    Optional<AllModules> findById(Integer id){
        return allModulesRepository.findById(id);
    }
}
