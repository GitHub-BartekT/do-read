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

    public Module (){}

    public Module (int id, String sentence) {
        this.id = id;
        this.sentence = sentence;
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
}
