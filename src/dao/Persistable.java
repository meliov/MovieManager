package dao;

public interface Persistable {

    /**
     * load persisted data from external storage
     */
    void load();

    /**
     * Persists data to external storage
     */
    void save();
}
