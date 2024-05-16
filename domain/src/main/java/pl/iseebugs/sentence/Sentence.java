package pl.iseebugs.sentence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "sentences")
class Sentence {
    @Id
    private UUID id;
    private String username;
    private String moduleName;
    private List<String> phrase;

    Sentence(){}

    UUID getId() {
        return id;
    }

    void setId(final UUID id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    String getUsername() {
        return username;
    }

    void setUsername(final String username) {
        this.username = username;
    }

    String getModuleName() {
        return moduleName;
    }

    void setModuleName(final String moduleName) {
        this.moduleName = moduleName;
    }

    List<String> getPhrase() {
        return phrase;
    }

    void setPhrase(final List<String> phrase) {
        this.phrase = phrase;
    }
}
