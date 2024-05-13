package pl.iseebugs.loginandregister;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface OurUserRepository extends MongoRepository<OurUser, String> {
    Optional<OurUser> findByUsername(String username);
    Boolean existsByUsername(String username);
}
