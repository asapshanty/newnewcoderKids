package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Device {
    private int deviceIdPk;
    private String deviceModel;
    private String deviceSerialNumber;
    private String deviceDateAcquired;

    @Id
    @Column(name = "device_id_pk", nullable = false)
    public int getDeviceIdPk() {
        return deviceIdPk;
    }

    public void setDeviceIdPk(int deviceIdPk) {
        this.deviceIdPk = deviceIdPk;
    }

    @Basic
    @Column(name = "device_model", nullable = true, length = 100)
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Basic
    @Column(name = "device_serial_number", nullable = true, length = 100)
    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    @Basic
    @Column(name = "device_date_acquired", nullable = true, length = 10)
    public String getDeviceDateAcquired() {
        return deviceDateAcquired;
    }

    public void setDeviceDateAcquired(String deviceDateAcquired) {
        this.deviceDateAcquired = deviceDateAcquired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return deviceIdPk == device.deviceIdPk &&
                Objects.equals(deviceModel, device.deviceModel) &&
                Objects.equals(deviceSerialNumber, device.deviceSerialNumber) &&
                Objects.equals(deviceDateAcquired, device.deviceDateAcquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceIdPk, deviceModel, deviceSerialNumber, deviceDateAcquired);
    }
}
