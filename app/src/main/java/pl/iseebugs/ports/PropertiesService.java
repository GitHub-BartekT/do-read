package pl.iseebugs.ports;

import pl.iseebugs.properties.ModuleProperties;
import pl.iseebugs.properties.PropertiesDTO;

import java.util.List;
import java.util.Optional;

public interface PropertiesService {
    List<PropertiesDTO> findALL();
    Optional<ModuleProperties> findById(Integer id);
    ModuleProperties updateProperties(int id, PropertiesDTO propertiesDTO);
    ModuleProperties updateProperties(int id);
}
