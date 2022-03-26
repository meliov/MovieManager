package dao.impl;

import dao.repository.ReviewRepository;
import model.entity.Review;

public class ReviewRepositoryImpl extends AbstractRepository<Long, Review> implements ReviewRepository {
    public ReviewRepositoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }
}
