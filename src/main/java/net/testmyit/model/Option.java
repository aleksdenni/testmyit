package net.testmyit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "option", nullable = false)
    private String option;

    @Column(name = "isCorrect", nullable = false)
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Question question;
}
