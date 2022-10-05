package interfaces;

import java.util.List;

public interface  Dao<P, I> {
        void insert(P elem);
        List<P> getAll();
        P get(I id);
}
