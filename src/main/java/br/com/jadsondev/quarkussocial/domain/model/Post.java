package br.com.jadsondev.quarkussocial.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@EqualsAndHashCode(callSuper = false)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_text")
    private String text;

    @Column(name = "date_time")
    private LocalDateTime dataTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        setDataTime(LocalDateTime.now());
    }
}
