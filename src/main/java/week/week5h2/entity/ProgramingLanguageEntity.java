package week.week5h2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "programing_language")
public class ProgramingLanguageEntity implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "programingLanguageEntity", fetch = FetchType.LAZY)
    private List <SubTechnologyEntity> subTechnologyEntities;





}
