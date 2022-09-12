package veterinerProject.w34.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","animal","animalType","animalOwner"})
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private int photoId;

    @Column(name = "photo_url")
    private String photoUrl;

    @JsonIgnore
    @OneToOne(mappedBy = "photo", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Animal animal;

    @JsonIgnore
    @OneToOne(mappedBy = "photo", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AnimalType animalType;

    @JsonIgnore
    @OneToOne(mappedBy = "photo", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AnimalOwner animalOwner;
}
