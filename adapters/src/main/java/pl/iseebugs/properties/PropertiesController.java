package pl.iseebugs.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moduleProperties")
class PropertiesController {
    private final Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final PropertiesFacade propertiesFacade;

    PropertiesController(PropertiesFacade propertiesFacade){this.propertiesFacade = propertiesFacade;}

    @GetMapping
    ResponseEntity<List<PropertiesDTO>> findALLModuleProperties(){
        logger.info("Get Request");
        return ResponseEntity.ok(propertiesFacade.findALL());
    }

    @PutMapping(params = {"id"})
    ResponseEntity<ModuleProperties> updateProperties (@RequestParam(value = "id") Integer id, @RequestBody PropertiesDTO propertiesDTO){
        logger.info("Put Request");
        return ResponseEntity.ok(propertiesFacade.updateProperties(id, propertiesDTO));
    }

    @PutMapping(value = "/session", params = {"id"})
    ResponseEntity<ModuleProperties> updateProperties (@RequestParam(value = "id") Integer id){
        logger.info("Put Request");
        return ResponseEntity.ok(propertiesFacade.updateProperties(id));
    }

}
