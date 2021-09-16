package ch.M223UI.vincent.domain;

import java.time.LocalDateTime;

public class Entry {

    private Long id;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private Category category;

    private Tag tag;

    private User creator;

    public Entry(Long id, LocalDateTime checkIn, LocalDateTime checkOut, Category category, Tag tag, User creator) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.category = category;
        this.tag = tag;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return category;
    }

    public Tag getTag() {
        return tag;
    }

    public User getCreator() {
        return creator;
    }
}