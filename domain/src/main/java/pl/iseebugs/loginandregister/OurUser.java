package pl.iseebugs.loginandregister;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "ouruser")
class OurUser {
    @Id
    private UUID id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String roles;

    OurUser(){}

    OurUser(Builder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.roles = builder.roles;
    }

    UUID getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getRoles() {
        return roles;
    }

    public static class Builder{
        private UUID id;
        private String username;
        private String password;
        private String roles;

        public Builder(){}

        public Builder id(UUID id){
            this.id = id;
            return this;
        }


        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder roles(String roles){
            this.roles = roles;
            return this;
        }

        OurUser build(){
            return new OurUser(this);
        }
    }
}
