package pl.iseebugs.read.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AllModulesServlet {
    private final Logger logger = LoggerFactory.getLogger(AllModulesServlet.class);

    private AllModulesService service;


    AllModulesServlet(AllModulesService service){
        this.service = service;
    }

    @GetMapping("/allModules")
    ResponseEntity<List<AllModulesDTO>> findALL(){
        logger.info("Get Request");
        return ResponseEntity.ok(service.findALL());
    }

}
