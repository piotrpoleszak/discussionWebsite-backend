package com.poleszak.webApp.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subpost
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank(message = "Community name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @OneToMany(fetch = LAZY)
    @ToString.Exclude
    private List<Post> posts;
    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subpost subpost = (Subpost) o;
        return id != null && Objects.equals(id, subpost.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}