package com.test.restclientlibrary.restclient.test.webuntis.entity.supply;

import java.util.Date;
import java.util.List;

public class WebUntisCustomTimetableOption {
    WebUntisCustomTimetableElement element;
    Date startDate;
    Date endDate;
    boolean showBooking;
    boolean showInfo;
    boolean showSubstText;
    boolean showLsText;
    boolean showLsNumber;
    boolean showStudentgroup;
    List<WebUntisCustomTimetableField> klasseFields;
    List<WebUntisCustomTimetableField> roomFields;
    List<WebUntisCustomTimetableField> subjectFields;
    List<WebUntisCustomTimetableField> teacherFields;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isShowBooking() {
        return showBooking;
    }

    public void setShowBooking(boolean showBooking) {
        this.showBooking = showBooking;
    }

    public boolean isShowInfo() {
        return showInfo;
    }

    public void setShowInfo(boolean showInfo) {
        this.showInfo = showInfo;
    }

    public boolean isShowSubstText() {
        return showSubstText;
    }

    public void setShowSubstText(boolean showSubstText) {
        this.showSubstText = showSubstText;
    }

    public boolean isShowLsNumber() {
        return showLsNumber;
    }

    public void setShowLsNumber(boolean showLsNumber) {
        this.showLsNumber = showLsNumber;
    }

    public WebUntisCustomTimetableElement getElement() {
        return element;
    }

    public void setElement(WebUntisCustomTimetableElement element) {
        this.element = element;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isShowLsText() {
        return showLsText;
    }

    public void setShowLsText(boolean showLsText) {
        this.showLsText = showLsText;
    }

    public boolean isShowStudentgroup() {
        return showStudentgroup;
    }

    public void setShowStudentgroup(boolean showStudentgroup) {
        this.showStudentgroup = showStudentgroup;
    }

    public List<WebUntisCustomTimetableField> getKlasseFields() {
        return klasseFields;
    }

    public void setKlasseFields(List<WebUntisCustomTimetableField> klasseFields) {
        this.klasseFields = klasseFields;
    }

    public List<WebUntisCustomTimetableField> getRoomFields() {
        return roomFields;
    }

    public void setRoomFields(List<WebUntisCustomTimetableField> roomFields) {
        this.roomFields = roomFields;
    }

    public List<WebUntisCustomTimetableField> getSubjectFields() {
        return subjectFields;
    }

    public void setSubjectFields(List<WebUntisCustomTimetableField> subjectFields) {
        this.subjectFields = subjectFields;
    }

    public List<WebUntisCustomTimetableField> getTeacherFields() {
        return teacherFields;
    }

    public void setTeacherFields(List<WebUntisCustomTimetableField> teacherFields) {
        this.teacherFields = teacherFields;
    }
}
