package com.test.restclientlibrary.restclient.test.webuntis.entity.result;

public class WebUntisAuthenticateResult {
    public String sessionId;
    public int personType;
    public int personId;
    public int klasseId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getPersonType() {
        return personType;
    }

    public void setPersonType(int personType) {
        this.personType = personType;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getKlasseId() {
        return klasseId;
    }

    public void setKlasseId(int klasseId) {
        this.klasseId = klasseId;
    }
}
