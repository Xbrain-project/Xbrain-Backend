//package com.Xbrain.BackendXbrain.builder;
//
//import com.Xbrain.BackendXbrain.entity.UserEntity;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.util.Optional;
//
//
//@AllArgsConstructor
//@Entity
//@Table(name = "post_commu")
//public class Post {
//
//    @Id
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
//    @Column(nullable = false, updatable = false)
//    private String id;
//    private String title;
//    private String content;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private UserEntity userEntity;
//
//
//    public Post() {
//    }
//
//    private Post(Post.Builder builder){
//        id = builder.id;
//        title = builder.title;
//        content = builder.content;
//        userEntity = builder.userEntity;
//
//    } // end of Post(builder)
//
//    public static class Builder{
//
//        private String id;
//        private String title;
//        private String content;
//
//        private UserEntity userEntity;
//
//        public Post.Builder id(String id){
//            this.id = id;
//            return this;
//        }
//        public Post.Builder title(String title){
//            this.title = title;
//            return this;
//        }
//        public Post.Builder content(String content){
//            this.content = content;
//            return this;
//        }
//
////        public Post.Builder userEntity(UserEntity userEntity){
////            this.userEntity = userEntity;
////            return this;
////        }
//
//        public Post build(){
//            return new Post(this);
//        }
//
//        public Post.Builder userEntity(Optional<UserEntity> userEntity) {
//            this.userEntity = userEntity;
//            return this;
//        }
//    } //end of Builder class
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public UserEntity getUserEntity() {
//        return userEntity;
//    }
//
//    public void setUserEntity(UserEntity userEntity) {
//        this.userEntity = userEntity;
//    }
//
//}
