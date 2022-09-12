package veterinerProject.w34.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@Table(name = "vets")
public class Vet extends User{
}
