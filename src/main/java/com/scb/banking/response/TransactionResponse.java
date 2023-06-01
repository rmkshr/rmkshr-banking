package com.scb.banking.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    List<TransactionDetails> transactionDetailsList;

    @JsonProperty("currentBalance")
    private long currentBalance;

    @JsonProperty("availableBalance")
    private long availableBalance;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionResponse{");
        sb.append("transactionDetailsList=").append(transactionDetailsList);
        sb.append(", currentBalance=").append(currentBalance);
        sb.append(", availableBalance=").append(availableBalance);
        sb.append('}');
        return sb.toString();
    }
}
