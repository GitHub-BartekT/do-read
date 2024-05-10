package pl.iseebugs.module;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.iseebugs.ports.PropertiesService;

import java.util.List;

@RestController
@RequestMapping("/api")
class ModuleController {
    private final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    private final ModuleService moduleService;

    ModuleController(ModuleService moduleService){
        this.moduleService = moduleService;
    }

    @GetMapping("/module")
    ResponseEntity<List<ModuleDTO>> findALLModule(){
        logger.info("Get Request");
        return ResponseEntity.ok(moduleService.findALL());
    }


    @GetMapping (value = "/module", params = {"id"})
        ResponseEntity<List<ModuleDTO>> findModuleSentences(@RequestParam("id") Integer id){
        logger.info("Get Request param: id " + id);
        return ResponseEntity.ok(moduleService.findOneModuleById(id));
    }

    @GetMapping (value = "/module", params = {"module"})
        ResponseEntity<List<ModuleDTO>> showNextSession(@RequestParam("module") Integer module){
        logger.info("Get Request param: module " + module);
        return ResponseEntity.ok(moduleService.nextSession(module));
    }

    @PostMapping("/module")
    ResponseEntity<Module> createSentence(@RequestBody ModuleDTO moduleDTO){
        return moduleService.saveSentence(moduleDTO);
    }

}
