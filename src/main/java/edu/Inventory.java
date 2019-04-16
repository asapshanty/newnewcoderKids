package edu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Inventory {
    private int inventoryIdPk;
    private Integer physicalTotalCount;

    @Id
    @Column(name = "inventory_id_pk", nullable = false)
    public int getInventoryIdPk() {
        return inventoryIdPk;
    }

    public void setInventoryIdPk(int inventoryIdPk) {
        this.inventoryIdPk = inventoryIdPk;
    }

    @Basic
    @Column(name = "physical_total_count", nullable = true)
    public Integer getPhysicalTotalCount() {
        return physicalTotalCount;
    }

    public void setPhysicalTotalCount(Integer physicalTotalCount) {
        this.physicalTotalCount = physicalTotalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryIdPk == inventory.inventoryIdPk &&
                Objects.equals(physicalTotalCount, inventory.physicalTotalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryIdPk, physicalTotalCount);
    }
}
