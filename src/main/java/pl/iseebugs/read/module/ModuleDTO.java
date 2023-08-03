package pl.iseebugs.read.module;

class ModuleDTO {
    private int id;
    private String sentence;

    public ModuleDTO(Module module) {
        this.id = module.getId();
        this.sentence = module.getSentence();
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
