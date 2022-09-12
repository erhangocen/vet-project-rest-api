package veterinerProject.w34.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","animalBreeds"})
@Table(name = "animalTypes")
public class AnimalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private String typeName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @JsonIgnore
    @OneToMany(mappedBy = "animalType", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnimalBreed> animalBreeds;
}
