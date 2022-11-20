package com.Xbrain.XbrainBackend.builder;

public class User {
    private final Long id;
    private final String email;
    private final Name name;
    private final Detail detail;

    private User(Builder builder){
        this.id = builder.id;
        this.email = builder.email;
        this.name = builder.name;
        this.detail = builder.detail;
    }

    public static class Builder{
        private Long id;
        private String email;
        private Name name;
        private Detail detail;

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder email(final String email) {
            this.email = email;
            return this;
        }
        public Builder name(final Name name) {
            this.name = name;
            return this;
        }
        public Builder detail(final Detail detail) {
            this.detail = detail;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Detail getDetail() {
        return detail;
    }
    
}
