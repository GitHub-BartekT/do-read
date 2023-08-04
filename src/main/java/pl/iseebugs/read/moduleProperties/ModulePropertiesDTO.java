package pl.iseebugs.read.moduleProperties;

class ModulePropertiesDTO {
    private int id;
    private int sessionsPerDay;
    private int presentationsPerSession;
    private int newSentencesPerDay;
    private int actualDay;
    private int nextSession;

    public ModulePropertiesDTO(ModuleProperties moduleProperties) {
        this.id = moduleProperties.getId();
        this.sessionsPerDay = moduleProperties.getSessionsPerDay();
        this.presentationsPerSession = moduleProperties.getPresentationsPerSession();
        this.newSentencesPerDay = moduleProperties.getNewSentencesPerDay();
        this.actualDay = moduleProperties.getActualDay();
        this.nextSession = moduleProperties.getNextSession();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionsPerDay() {
        return sessionsPerDay;
    }

    public void setSessionsPerDay(int sessionsPerDay) {
        if (sessionsPerDay <= 0){
            this.sessionsPerDay = 1;
        }
        this.sessionsPerDay = sessionsPerDay;
    }

    public int getPresentationsPerSession() {
        return presentationsPerSession;
    }

    public void setPresentationsPerSession(int presentationsPerSession) {
        if (presentationsPerSession <= 0){
            this.presentationsPerSession = 1;
        }
        this.presentationsPerSession = presentationsPerSession;
    }

    public int getNewSentencesPerDay() {
        return newSentencesPerDay;
    }

    public void setNewSentencesPerDay(int newSentencesPerDay) {
        if (newSentencesPerDay <= 0){
            this.newSentencesPerDay = 1;
        }
        this.newSentencesPerDay = newSentencesPerDay;
    }

    public int getActualDay() {
        return actualDay;
    }

    public void setActualDay(int actualDay) {
        if (actualDay <= 0){
            this.actualDay = 1;
        }
        this.actualDay = actualDay;
    }

    public int getNextSession() {
        return nextSession;
    }

    public void setNextSession(int nextSession) {
        if (nextSession <= 0){
            this.nextSession = 1;
        }
        this.nextSession = nextSession;
    }
}
