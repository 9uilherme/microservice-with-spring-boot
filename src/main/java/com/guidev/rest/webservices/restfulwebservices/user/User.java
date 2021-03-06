package com.guidev.rest.webservices.restfulwebservices.user;

import com.guidev.rest.webservices.restfulwebservices.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@ApiModel(description = "Info about User")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name has to be bigger than 1 character")
    @ApiModelProperty(notes="Name has to be bigger than 1 character")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth Date has to be in the past")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User(){}

    public User(Integer id, String name, Date birthDate){
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return String.format("User {id: %s, name: %s, birthDate: %s}", id, name, birthDate);
    }
}
