package pl.iseebugs.read.modulProperties;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ModulePropertiesService {
    private ModulePropertiesRepository repository;

    ModulePropertiesService(ModulePropertiesRepository repository){this.repository = repository;}

    List<ModulePropertiesDTO> findALL(){
        return repository
                .findAll()
                .stream()
                .map(ModulePropertiesDTO::new)
                .collect(toList());
    }
}
