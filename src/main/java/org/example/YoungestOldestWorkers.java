package org.example;

import java.sql.Date;

public class YoungestOldestWorkers {
    private String type;
    private Date birthday;

    public YoungestOldestWorkers(String type, Date birthday) {
        this.type = type;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestOldestWorkers{" +
                "type='" + type + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
