package pl.iseebugs.read.module;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class AllModulesService {
    private AllModulesRepository repository;

    AllModulesService(AllModulesRepository repository){
        this.repository = repository;
    }

    List<AllModulesDTO> findALL(){
        return repository
                .findAll()
                .stream()
                .map(AllModulesDTO::new)
                .collect(toList());
    }

    Optional<AllModules> findById(Integer id){
        return repository.findById(id);
    }
}
