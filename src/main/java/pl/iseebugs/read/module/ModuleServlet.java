package pl.iseebugs.read.module;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        logger.info("Get Request");
        return ResponseEntity.ok(service.findOneModuleById(id));
    }
}
