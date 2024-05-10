package pl.iseebugs.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class AllModulesController {
    private final Logger logger = LoggerFactory.getLogger(AllModulesController.class);

    private final AllModulesService allModulesService;

    AllModulesController(AllModulesService allModulesService){
        this.allModulesService = allModulesService;
    }

    @GetMapping("/allModules")
    ResponseEntity<List<AllModulesDTO>> findALL(){
        logger.info("Get Request");
        return ResponseEntity.ok(allModulesService.findALL());
    }

}
