package appsoft.com.demoandtest1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assignment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("teacher_id")
    @Expose
    private String teacherId;
    @SerializedName("assignment_class")
    @Expose
    private String assignmentClass;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("given_date")
    @Expose
    private String givenDate;
    @SerializedName("submission_date")
    @Expose
    private String submissionDate;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("attachment")
    @Expose
    private String attachment;

    /**
     * No args constructor for use in serialization
     *
     */
    public Assignment() {
    }

    /**
     *
     * @param id
     * @param assignmentClass
     * @param title
     * @param submissionDate
     * @param givenDate
     * @param description
     * @param subject
     * @param attachment
     * @param section
     * @param teacherId
     */
    public Assignment(String id, String teacherId, String assignmentClass, String section, String givenDate, String submissionDate, String subject, String title, String description, String attachment) {
        super();
        this.id = id;
        this.teacherId = teacherId;
        this.assignmentClass = assignmentClass;
        this.section = section;
        this.givenDate = givenDate;
        this.submissionDate = submissionDate;
        this.subject = subject;
        this.title = title;
        this.description = description;
        this.attachment = attachment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getAssignmentClass() {
        return assignmentClass;
    }

    public void setAssignmentClass(String assignmentClass) {
        this.assignmentClass = assignmentClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(String givenDate) {
        this.givenDate = givenDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

}