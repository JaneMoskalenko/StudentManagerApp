package com.example.admin.studentmanager.model;

/**
 * Created by admin on 08.06.2017.
 */
public class Journal {
    private Long id;
    private Long studentID;
    private Long lessonID;
    private boolean presence;

    public Journal(Long id, Long studentID, Long lessonID, boolean presence) {
        this.id=System.currentTimeMillis();
        this.studentID = studentID;
        this.lessonID = lessonID;
        this.presence = presence;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getLessonID() {
        return lessonID;
    }

    public void setLessonID(Long lessonID) {
        this.lessonID = lessonID;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Journal)) return false;
        if (this.id != ((Journal) obj).getId()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (21+id.hashCode()*41);
    }


}
