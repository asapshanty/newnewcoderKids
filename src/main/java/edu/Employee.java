package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    private int empIdPk;
    private String empFirstName;
    private String empLastName;
    private String empPhone;
    private String empEmail;
    private String empAddress;
    private String empZipcode;
    private String hireDate;
    private String terminationDate;

    @Id
    @Column(name = "emp_id_pk", nullable = false)
    public int getEmpIdPk() {
        return empIdPk;
    }

    public void setEmpIdPk(int empIdPk) {
        this.empIdPk = empIdPk;
    }

    @Basic
    @Column(name = "emp_first_name", nullable = true, length = 20)
    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    @Basic
    @Column(name = "emp_last_name", nullable = true, length = 20)
    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    @Basic
    @Column(name = "emp_phone", nullable = true, length = 15)
    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Basic
    @Column(name = "emp_email", nullable = true, length = 50)
    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Basic
    @Column(name = "emp_address", nullable = true, length = 100)
    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    @Basic
    @Column(name = "emp_zipcode", nullable = true, length = 5)
    public String getEmpZipcode() {
        return empZipcode;
    }

    public void setEmpZipcode(String empZipcode) {
        this.empZipcode = empZipcode;
    }

    @Basic
    @Column(name = "hire_date", nullable = true, length = 10)
    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "termination_date", nullable = true, length = 10)
    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empIdPk == employee.empIdPk &&
                Objects.equals(empFirstName, employee.empFirstName) &&
                Objects.equals(empLastName, employee.empLastName) &&
                Objects.equals(empPhone, employee.empPhone) &&
                Objects.equals(empEmail, employee.empEmail) &&
                Objects.equals(empAddress, employee.empAddress) &&
                Objects.equals(empZipcode, employee.empZipcode) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(terminationDate, employee.terminationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empIdPk, empFirstName, empLastName, empPhone, empEmail, empAddress, empZipcode, hireDate, terminationDate);
    }
}
