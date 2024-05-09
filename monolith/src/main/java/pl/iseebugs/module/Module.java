package pl.iseebugs.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
/*

@NamedNativeQuery(  name = "Module.findWszystkie",
                    query = "SELECT m.sentence AS SENTENCE FROM module m WHERE ID = :id",
                    resultSetMapping = "Mapping.ModuleDTO")
@SqlResultSetMapping(   name = "Mapping.ModuleDTO",
                        classes = @ConstructorResult(targetClass = ModuleDTO.class,
                                columns = {@ColumnResult(name = "sentence"),
                                           @ColumnResult(name = "module")}))
*/

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
