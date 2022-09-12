package veterinerProject.w34.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","animals"})
@Table(name = "animalBreeds")
public class AnimalBreed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "breed_name")
    private String breedName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private AnimalType animalType;

    @JsonIgnore
    @OneToMany(mappedBy = "animalBreed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animals;
}
