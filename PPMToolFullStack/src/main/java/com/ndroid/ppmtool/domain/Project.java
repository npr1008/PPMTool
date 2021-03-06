package com.ndroid.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter
@Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @NotBlank(message = "Project Name Should not be blank")
    private String projectName;
    @NotBlank(message = "Project Identifier Should not be blank")
    @Size(min = 4, max = 5, message = "Project Identifier should be between 4 - 5 Characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Description should not be blank")
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    private Date created_at;
    private Date updated_at;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "project")
    private Backlog backlog;
    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

    @PrePersist
    private void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        this.updated_at = new Date();
    }
}
