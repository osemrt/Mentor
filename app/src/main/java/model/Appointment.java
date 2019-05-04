package model;

import java.util.Date;

public class Appointment {
    private User consumerUser;
    private User hostUser;
    private Date timeStamp;
    private boolean isCreationCompeted;
    private boolean isCanceled;

    public Appointment(User consumerUser, User hostUser, Date timeStamp) {
        this.consumerUser = consumerUser;
        this.hostUser = hostUser;
        this.timeStamp = timeStamp;
    }

    public User getConsumerUser() {
        return consumerUser;
    }

    public void setConsumerUser(User consumerUser) {
        this.consumerUser = consumerUser;
    }

    public User getHostUser() {
        return hostUser;
    }

    public void setHostUser(User hostUser) {
        this.hostUser = hostUser;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isCreationCompeted() {
        return isCreationCompeted;
    }

    public void setCreationCompeted(boolean creationCompeted) {
        isCreationCompeted = creationCompeted;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
