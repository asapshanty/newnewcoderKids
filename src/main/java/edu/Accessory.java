package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Accessory {
    private int accessoryIdPk;
    private String accessoryModel;
    private String accessorySerialNumber;
    private String accessoryDateAcquired;

    @Id
    @Column(name = "accessory_id_pk", nullable = false)
    public int getAccessoryIdPk() {
        return accessoryIdPk;
    }

    public void setAccessoryIdPk(int accessoryIdPk) {
        this.accessoryIdPk = accessoryIdPk;
    }

    @Basic
    @Column(name = "accessory_model", nullable = true, length = 100)
    public String getAccessoryModel() {
        return accessoryModel;
    }

    public void setAccessoryModel(String accessoryModel) {
        this.accessoryModel = accessoryModel;
    }

    @Basic
    @Column(name = "accessory_serial_number", nullable = true, length = 100)
    public String getAccessorySerialNumber() {
        return accessorySerialNumber;
    }

    public void setAccessorySerialNumber(String accessorySerialNumber) {
        this.accessorySerialNumber = accessorySerialNumber;
    }

    @Basic
    @Column(name = "accessory_date_acquired", nullable = true, length = 10)
    public String getAccessoryDateAcquired() {
        return accessoryDateAcquired;
    }

    public void setAccessoryDateAcquired(String accessoryDateAcquired) {
        this.accessoryDateAcquired = accessoryDateAcquired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return accessoryIdPk == accessory.accessoryIdPk &&
                Objects.equals(accessoryModel, accessory.accessoryModel) &&
                Objects.equals(accessorySerialNumber, accessory.accessorySerialNumber) &&
                Objects.equals(accessoryDateAcquired, accessory.accessoryDateAcquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessoryIdPk, accessoryModel, accessorySerialNumber, accessoryDateAcquired);
    }
}
