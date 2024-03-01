package com.example.uuid.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date",nullable = false)
    private LocalDateTime date;

    @Column(name = "api_address",nullable = false)
    private String apiAddress;

    @Column(name = "generated_uuid",nullable = false)
    private String generateUuid;

}
