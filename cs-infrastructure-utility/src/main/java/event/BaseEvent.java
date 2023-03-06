package event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mf.projects.cs.infrastructure.base.BaseBean;

import java.util.Date;
import java.util.UUID;

public abstract class BaseEvent extends BaseBean {

    private String eventId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date eventTime;


    public BaseEvent () {
        this.eventId = "Event" + UUID.randomUUID().toString().toLowerCase();
        this.eventTime = new Date();
    }


}
