package pl.iseebugs.read.module;

import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
class ModuleService {
    private ModuleRepository repository;

    ModuleService(ModuleRepository repository){
        this.repository = repository;
    }

    List<ModuleDTO> findALL(){
        return repository
                .findAll()
                .stream()
                .map(ModuleDTO::new)
                .collect(toList());
    }
}