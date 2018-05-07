package morthth.t3c.demo.course;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Integer lecturerId;

    private String lecturerFullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerFullName() {
        return lecturerFullName;
    }

    public void setLecturerFullName(String lecturerFullName) {
        this.lecturerFullName = lecturerFullName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lecturerId=" + lecturerId +
                ", lecturerFullName='" + lecturerFullName + '\'' +
                '}';
    }
}
