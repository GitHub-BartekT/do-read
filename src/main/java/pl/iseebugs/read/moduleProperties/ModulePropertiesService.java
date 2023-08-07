package pl.iseebugs.read.moduleProperties;

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

    public Optional <ModulePropertiesDTO> findById(int id){
       return repository.findById(id).map(ModulePropertiesDTO::new);
    }
}
