package programinglanguage.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "sub_technology")
public class SubTechnologyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "programming_language_id")
    private ProgramingLanguageEntity programingLanguageEntity;
}
