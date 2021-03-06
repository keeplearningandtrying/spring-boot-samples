package com.ttulka.ddd.tlr.infrastructure;

import java.math.BigDecimal;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Repository
public interface TransactionEntries extends CrudRepository<TransactionEntries.TransactionEntry, String> {

    Stream<TransactionEntry> findBySenderIbanOrReceiverIban(String senderIban, String receiverIban);

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    class TransactionEntry {
        @Id
        @Column
        public String uuid;
        @Column
        public BigDecimal amount;
        @Column
        public String currency;
        @Column
        public String senderIban;
        @Column
        public String receiverIban;
    }
}
