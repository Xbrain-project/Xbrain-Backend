package com.Xbrain.XbrainBackend.builder;

public class Name {
    private final String firstName;
	private final String lastName;


    private Name(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder{
        private String firstName;
	    private String lastName;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Name build(){
            return new Name(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
}
