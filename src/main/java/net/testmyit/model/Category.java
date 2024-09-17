package net.testmyit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "categories")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Language language_id;

    @OneToMany(cascade = CascadeType.DETACH,
            mappedBy = "category_id",
            fetch = FetchType.LAZY)
    private List<Question> listQuestions;
}
