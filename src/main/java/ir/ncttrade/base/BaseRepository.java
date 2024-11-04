package ir.ncttrade.base;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T extends BaseModel<ID>,ID extends Serializable> {
    T upsert(T t);
    Boolean remove(ID id);
    T findById(ID id);
    List findAll();
}
