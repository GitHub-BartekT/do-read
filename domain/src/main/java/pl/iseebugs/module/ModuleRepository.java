package pl.iseebugs.module;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ModuleRepository extends MongoRepository <Module, String> {
}
