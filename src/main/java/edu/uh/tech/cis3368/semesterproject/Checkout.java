package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Checkout {
    private int checkoutIdPk;
    private Integer checkoutCount;
    private String checkoutDate;

    @Id
    @Column(name = "checkout_id_pk", nullable = false)
    public int getCheckoutIdPk() {
        return checkoutIdPk;
    }

    public void setCheckoutIdPk(int checkoutIdPk) {
        this.checkoutIdPk = checkoutIdPk;
    }

    @Basic
    @Column(name = "checkout_count", nullable = true)
    public Integer getCheckoutCount() {
        return checkoutCount;
    }

    public void setCheckoutCount(Integer checkoutCount) {
        this.checkoutCount = checkoutCount;
    }

    @Basic
    @Column(name = "checkout_date", nullable = true, length = 10)
    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return checkoutIdPk == checkout.checkoutIdPk &&
                Objects.equals(checkoutCount, checkout.checkoutCount) &&
                Objects.equals(checkoutDate, checkout.checkoutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkoutIdPk, checkoutCount, checkoutDate);
    }
}
