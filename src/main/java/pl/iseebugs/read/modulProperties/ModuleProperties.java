package pl.iseebugs.read.modulProperties;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="moduleProperties")
class ModuleProperties {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private int id;
    private int sessionsPerDay;
    private int presentationsPerSession;
    private int newSentencesPerDay;
    private int actualDay;
    private int nextSession;

    public ModuleProperties(){}

    public ModuleProperties(int id, int sessionsPerDay, int presentationsPerSession,
                            int newSentencesPerDay, int actualDay, int nextSession) {
        this.id = id;
        this.sessionsPerDay = sessionsPerDay;
        this.presentationsPerSession = presentationsPerSession;
        this.newSentencesPerDay = newSentencesPerDay;
        this.actualDay = actualDay;
        this.nextSession = nextSession;
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
        this.sessionsPerDay = sessionsPerDay;
    }

    public int getPresentationsPerSession() {
        return presentationsPerSession;
    }

    public void setPresentationsPerSession(int presentationsPerSession) {
        this.presentationsPerSession = presentationsPerSession;
    }

    public int getNewSentencesPerDay() {
        return newSentencesPerDay;
    }

    public void setNewSentencesPerDay(int newSentencesPerDay) {
        this.newSentencesPerDay = newSentencesPerDay;
    }

    public int getActualDay() {
        return actualDay;
    }

    public void setActualDay(int actualDay) {
        this.actualDay = actualDay;
    }

    public int getNextSession() {
        return nextSession;
    }

    public void setNextSession(int nextSession) {
        this.nextSession = nextSession;
    }
}
