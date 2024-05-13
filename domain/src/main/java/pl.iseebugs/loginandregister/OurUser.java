package pl.iseebugs.loginandregister;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ouruser")
class OurUser {
    @Id
    private long id;
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

    long getId() {
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
        private long id;
        private String username;
        private String password;
        private String roles;

        public Builder(){}

        public Builder id(long id){
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
