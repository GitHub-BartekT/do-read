package pl.iseebugs.sentence;

import java.util.List;

interface SentencePort {
    List<String> findByUsernameAndModuleNameRange(Sentence sentence, String username, int at, int range);
    List<String> findByUsernameAndModuleName();
    Sentence save(Sentence sentence, String username);
    void delete(String name, String username);
    Sentence update(Sentence sentence, String username);
}
