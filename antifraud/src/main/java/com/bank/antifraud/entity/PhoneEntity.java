package com.bank.antifraud.entity;

import com.bank.antifraud.aspect.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс, описывающий подозрительные переводы по номеру телефона
 *
 * @author Makariy Petrov
 */
@Getter
@Setter
@NoArgsConstructor
@Type("phone")
@Entity
@Table(name = "suspicious_phone_transfers")
@AttributeOverride(name = "transferId", column = @Column(name = "phone_transfer_id", nullable = false, unique = true))
public class PhoneEntity extends SuspiciousTransfer {
}
