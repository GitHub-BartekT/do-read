package pl.iseebugs.sentence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SentenceRepository extends MongoRepository <Sentence, String> {
}
