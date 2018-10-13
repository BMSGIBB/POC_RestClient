package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableCode;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableId;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableLessonType;

import java.util.Date;
import java.util.List;

public class WebUntisCustomTimetableResult {
    int id;
    Date date;
    int startTime;
    int endTime;
    WebUntisTimetableLessonType lstype;
    WebUntisTimetableCode code;
    String info;
    String substText;
    int lsnumber;
    String statflags;
    String sg;
    String bgRemark;
    String bkText;
    List<WebUntisTimetableId> kl;
    List<WebUntisTimetableId> te;
    List<WebUntisTimetableId> su;
    List<WebUntisTimetableId> ro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public WebUntisTimetableLessonType getLstype() {
        return lstype;
    }

    public void setLstype(WebUntisTimetableLessonType lstype) {
        this.lstype = lstype;
    }

    public WebUntisTimetableCode getCode() {
        return code;
    }

    public void setCode(WebUntisTimetableCode code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSubstText() {
        return substText;
    }

    public void setSubstText(String substText) {
        this.substText = substText;
    }

    public int getLsnumber() {
        return lsnumber;
    }

    public void setLsnumber(int lsnumber) {
        this.lsnumber = lsnumber;
    }

    public String getStatflags() {
        return statflags;
    }

    public void setStatflags(String statflags) {
        this.statflags = statflags;
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getBgRemark() {
        return bgRemark;
    }

    public void setBgRemark(String bgRemark) {
        this.bgRemark = bgRemark;
    }

    public String getBkText() {
        return bkText;
    }

    public void setBkText(String bkText) {
        this.bkText = bkText;
    }

    public List<WebUntisTimetableId> getKl() {
        return kl;
    }

    public void setKl(List<WebUntisTimetableId> kl) {
        this.kl = kl;
    }

    public List<WebUntisTimetableId> getTe() {
        return te;
    }

    public void setTe(List<WebUntisTimetableId> te) {
        this.te = te;
    }

    public List<WebUntisTimetableId> getSu() {
        return su;
    }

    public void setSu(List<WebUntisTimetableId> su) {
        this.su = su;
    }

    public List<WebUntisTimetableId> getRo() {
        return ro;
    }

    public void setRo(List<WebUntisTimetableId> ro) {
        this.ro = ro;
    }
}
