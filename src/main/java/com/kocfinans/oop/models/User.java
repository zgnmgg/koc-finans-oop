package com.kocfinans.oop.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.dto.UserDTO;
import com.kocfinans.oop.models.enumerator.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@Inheritance(
        strategy = InheritanceType.JOINED
)
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"password", "createdAt"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Timestamp createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserType type;

    public void setUnchangeableAttributes(UserDTO userDto) {
        this.setEmail(userDto.getEmail());
        this.setCreatedAt(Utils.getCurrentTimestamp());
    }

    public void setChangeableAttributes(UserDTO userDto) {
        this.setPassword(userDto.getPassword());
        this.setFullName(userDto.getFullName());
    }
}
