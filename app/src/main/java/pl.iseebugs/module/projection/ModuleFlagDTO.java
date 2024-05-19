package pl.iseebugs.module.projection;

import java.util.UUID;

public class ModuleFlagDTO {
    private String name;
    private String type;

    private boolean forLogUsers;
    private boolean forAllUsers;
    private boolean isActive;

    public ModuleFlagDTO(){};

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
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
}
