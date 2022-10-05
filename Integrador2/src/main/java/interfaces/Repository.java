package interfaces;

import java.util.List;

public interface Repository<P, I> {
        void insert(P elem);
        List<P> getAll();
        P get(I id);
}
