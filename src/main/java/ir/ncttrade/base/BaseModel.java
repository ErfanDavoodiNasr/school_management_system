package ir.ncttrade.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@MappedSuperclass
public class BaseModel<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
}
