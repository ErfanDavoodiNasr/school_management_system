package ir.ncttrade.base;

import java.io.Serializable;

public interface BaseRepository<T extends BaseModel<ID>,ID extends Serializable> {
    ID save(T t);
    Boolean remove(ID id);
    T findById(ID id);
}
