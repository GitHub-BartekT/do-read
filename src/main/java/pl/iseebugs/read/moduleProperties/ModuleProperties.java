package pl.iseebugs.read.moduleProperties;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "module_Properties")
public class ModuleProperties {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private int id;
    @Column(name = "sessions_Per_Day")
    private int sessionsPerDay;
    @Column(name = "presentations_Per_Session")
    private int presentationsPerSession;
    @Column(name = "new_Sentences_Per_Day")
    private int newSentencesPerDay;
    @Column(name = "actual_Day")
    private int actualDay;
    @Column(name = "next_Session")
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
