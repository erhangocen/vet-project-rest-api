package veterinerProject.w34.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@Table(name = "admins")
public class Admin extends User{
}
