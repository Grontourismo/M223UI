package ch.M223UI.vincent.domain;

public class Category {

    private Long id;

    private String name;

    private String description;

    private User creator;

    public Category(Long id, String name, String description, User creator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getCreator() {
        return creator;
    }
}
