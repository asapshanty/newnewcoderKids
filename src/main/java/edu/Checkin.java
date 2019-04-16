package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Checkin {
    private int checkinIdPk;
    private Integer checkinCount;
    private String checkinDate;

    @Id
    @Column(name = "checkin_id_pk", nullable = false)
    public int getCheckinIdPk() {
        return checkinIdPk;
    }

    public void setCheckinIdPk(int checkinIdPk) {
        this.checkinIdPk = checkinIdPk;
    }

    @Basic
    @Column(name = "checkin_count", nullable = true)
    public Integer getCheckinCount() {
        return checkinCount;
    }

    public void setCheckinCount(Integer checkinCount) {
        this.checkinCount = checkinCount;
    }

    @Basic
    @Column(name = "checkin_date", nullable = true, length = 10)
    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkin checkin = (Checkin) o;
        return checkinIdPk == checkin.checkinIdPk &&
                Objects.equals(checkinCount, checkin.checkinCount) &&
                Objects.equals(checkinDate, checkin.checkinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkinIdPk, checkinCount, checkinDate);
    }
}
