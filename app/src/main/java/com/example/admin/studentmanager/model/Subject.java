package com.example.admin.studentmanager.model;

/**
 * Created by admin on 08.06.2017.
 */
public class Subject {
    private Long id;
    private String subjectName;

    public Subject(Long id, String sublectName) {
        this.id=System.currentTimeMillis();
        this.subjectName = sublectName;
    }

    public Long getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Subject)) return false;
        if (this.id != ((Subject) obj).getId()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (21+id.hashCode()*41);
    }

}
