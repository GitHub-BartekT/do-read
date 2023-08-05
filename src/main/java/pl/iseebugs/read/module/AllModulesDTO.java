package pl.iseebugs.read.module;

class AllModulesDTO {
    private int id;
    private String module_Name;
    private boolean active;

    public AllModulesDTO(AllModules allModules) {
        this.id = allModules.getId();
        this.module_Name = allModules.getModule_Name();
        this.active = allModules.isActive();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModule_Name() {
        return module_Name;
    }

    public void setModule_Name(String module_Name) {
        this.module_Name = module_Name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
