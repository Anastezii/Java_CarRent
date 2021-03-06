package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "model")
@Entity

public class Model implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idMODEL", nullable = false)
    private Long model_id;

    @Column(name = "MODEL_NAME", nullable = false)
    private String model_name;

    @OneToMany
            (fetch = FetchType.EAGER, mappedBy = "idMODEL")
    private Set<Cars> carsSet;

    public Set<Cars> getCarsSet() {
        return carsSet;
    }

    public void setCarsSet(Set<Cars> carsSet) {
        this.carsSet = carsSet;
    }



    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public Model() { }

    @Override
    public String toString() {
        return "Model{" +
                "model_id=" + model_id +
                '}';
    }
}
