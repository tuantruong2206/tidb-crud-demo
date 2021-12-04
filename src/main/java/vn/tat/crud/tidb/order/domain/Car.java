package vn.tat.crud.tidb.order.domain;

import lombok.Data;

import java.time.Instant;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:48
 */
@Data
public class Car {

    private Long id;

    private String branchName;

    private String seats;

    private String note;

    @Override
    public String toString() {
        return String.format("branchName:%s seats: %s with note:", branchName, seats, note);
    }

    public void doNote(String value) {
        Instant now = Instant.now();
        note = String.format("%s now is %s", value, now.toString());
    }
}
