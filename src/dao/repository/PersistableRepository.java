package dao.repository;

import dao.Identifiable;
import dao.Persistable;

public interface PersistableRepository<K, V extends Identifiable<K>> extends Repository<K,V>, Persistable {
}
