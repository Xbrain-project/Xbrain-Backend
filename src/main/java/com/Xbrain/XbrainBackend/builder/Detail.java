package com.Xbrain.XbrainBackend.builder;

public class Detail {
    private final String phone;
    private final String photo;

    private Detail(Builder builder){
        this.phone = builder.phone;
        this.photo = builder.photo;
    }

    public static class Builder{
        private String phone;
	    private String photo;

        public Builder phone(final String phone) {
            this.phone = phone;
            return this;
        }
        public Builder photo(final String photo) {
            this.photo = photo;
            return this;
        }
        public Detail build(){
            return new Detail(this);
        }
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;
    }

}
