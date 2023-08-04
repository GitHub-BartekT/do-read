package pl.iseebugs.read.moduleProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModulePropertiesServlet {
    private final Logger logger = LoggerFactory.getLogger(ModulePropertiesServlet.class);

    private ModulePropertiesService service;

    ModulePropertiesServlet(ModulePropertiesService service){this.service = service;}

    @GetMapping("/moduleProperties")
    ResponseEntity<List<ModulePropertiesDTO>> findALLModuleProperties(){
        logger.info("Get Request");
        return ResponseEntity.ok(service.findALL());
    }
}
