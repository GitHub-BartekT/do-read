package pl.iseebugs.module;

public class ModuleDTO {
    private int id;
    private String sentence;
    private int module;

    public ModuleDTO(){    }

    public ModuleDTO(Module module) {
        this.id = module.getId();
        this.sentence = module.getSentence();
        this.module = module.getModule();
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
