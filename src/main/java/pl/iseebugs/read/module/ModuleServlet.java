package pl.iseebugs.read.module;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleServlet{
    private final Logger logger = LoggerFactory.getLogger(ModuleServlet.class);

    private ModuleService service;

    ModuleServlet(ModuleService service){
        this.service = service;
    }

    @GetMapping("/module")
    ResponseEntity<List<ModuleDTO>> findALLModule(){
        logger.info("Get Request");
        return ResponseEntity.ok(service.findALL());
    }


    @GetMapping (value = "/module", params = {"id"})
        ResponseEntity<List<ModuleDTO>> findModuleSentences(@RequestParam("id") Integer id){
        logger.info("Get Request param: id " + id);
        return ResponseEntity.ok(service.findOneModuleById(id));
    }

    @GetMapping (value = "/module", params = {"module"})
        ResponseEntity<List<ModuleDTO>> showNextSession(@RequestParam("module") Integer module){
        logger.info("Get Request param: module " + module);
        return ResponseEntity.ok(service.nextSession(module));
    }

    @PostMapping("/module")
    ResponseEntity<Module> createSentence(@RequestBody ModuleDTO moduleDTO){
        return service.saveSentence(moduleDTO);
    }

}
