package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer> {

    private final List<Explorer> explorers;

    public ExplorerRepository(){
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableList(this.explorers);
    }

    @Override
    public void add(Explorer entity) {
        this.explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return this.explorers.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
}
