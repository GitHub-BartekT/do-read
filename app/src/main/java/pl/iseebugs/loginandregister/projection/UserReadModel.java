package pl.iseebugs.loginandregister.projection;

public class UserReadModel {
    private final long id;
    private final String username;
    private final String password;
    private final String roles;

    UserReadModel(Builder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.roles = builder.roles;
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

        public UserReadModel build(){
            return new UserReadModel(this);
        }
    }
}
