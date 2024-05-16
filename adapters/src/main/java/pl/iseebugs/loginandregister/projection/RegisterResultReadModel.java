package pl.iseebugs.loginandregister.projection;

public class RegisterResultReadModel {
    String username;
    String role;
    boolean created;

    public RegisterResultReadModel(String username, String role, boolean created){
        this.username = username;
        this.role = role;
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    String getRole() {
        return role;
    }

    public boolean isCreated() {
        return created;
    }
}
