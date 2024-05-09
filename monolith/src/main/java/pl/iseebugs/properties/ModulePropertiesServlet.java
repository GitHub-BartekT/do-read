package pl.iseebugs.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moduleProperties")
public class ModulePropertiesServlet {
    private final Logger logger = LoggerFactory.getLogger(ModulePropertiesServlet.class);

    private ModulePropertiesService service;

    ModulePropertiesServlet(ModulePropertiesService service){this.service = service;}

    @GetMapping
    ResponseEntity<List<ModulePropertiesDTO>> findALLModuleProperties(){
        logger.info("Get Request");
        return ResponseEntity.ok(service.findALL());
    }

    @PutMapping(params = {"id"})
    ResponseEntity<ModuleProperties> updateProperties (@RequestParam(value = "id") Integer id, @RequestBody ModulePropertiesDTO modulePropertiesDTO){
        logger.info("Put Request");
        return service.updateProperties(id, modulePropertiesDTO);
    }

    @PutMapping(value = "/session", params = {"id"})
    ResponseEntity<ModuleProperties> updateProperties (@RequestParam(value = "id") Integer id){
        logger.info("Put Request");
        return service.updateProperties(id);
    }

}
