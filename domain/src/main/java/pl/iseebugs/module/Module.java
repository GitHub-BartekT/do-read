package pl.iseebugs.module;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "modules")
class Module {
    @Id
    private UUID id;
    private String username;
    private String name;

    private boolean forLogUsers;
    private boolean forAllUsers;

    private boolean isActive;
    private int sessionsPerDay;
    private int presentationsPerSession;
    private int newUnitsPerDay;
    private int actualModuleDay;
    private int nextSessionDuringDay;

    UUID getId() {
        return id;
    }

    void setId(final UUID id) {
        this.id = id;
    }

    String getUsername() {
        return username;
    }

    void setUsername(final String username) {
        this.username = username;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    boolean isForLogUsers() {
        return forLogUsers;
    }

    void setForLogUsers(final boolean forLogUsers) {
        this.forLogUsers = forLogUsers;
    }

    boolean isForAllUsers() {
        return forAllUsers;
    }

    void setForAllUsers(final boolean forAllUsers) {
        this.forAllUsers = forAllUsers;
    }

    boolean isActive() {
        return isActive;
    }

    void setActive(final boolean active) {
        isActive = active;
    }

    int getSessionsPerDay() {
        return sessionsPerDay;
    }

    void setSessionsPerDay(final int sessionsPerDay) {
        this.sessionsPerDay = sessionsPerDay;
    }

    int getPresentationsPerSession() {
        return presentationsPerSession;
    }

    void setPresentationsPerSession(final int presentationsPerSession) {
        this.presentationsPerSession = presentationsPerSession;
    }

    int getNewUnitsPerDay() {
        return newUnitsPerDay;
    }

    void setNewUnitsPerDay(final int newUnitsPerDay) {
        this.newUnitsPerDay = newUnitsPerDay;
    }

    int getActualModuleDay() {
        return actualModuleDay;
    }

    void setActualModuleDay(final int actualModuleDay) {
        this.actualModuleDay = actualModuleDay;
    }

    int getNextSessionDuringDay() {
        return nextSessionDuringDay;
    }

    void setNextSessionDuringDay(final int nextSessionDuringDay) {
        this.nextSessionDuringDay = nextSessionDuringDay;
    }
}
