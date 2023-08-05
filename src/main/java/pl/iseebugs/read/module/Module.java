package pl.iseebugs.read.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "module")
class Module {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private int id;
    private String sentence;
    private int module;

    public Module (){}

    public Module (int id, String sentence, int module) {
        this.id = id;
        this.sentence = sentence;
        this.module = module;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }
}
