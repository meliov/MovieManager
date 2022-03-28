package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.AdminRepository;
import model.entity.Admin;
import model.entity.Movie;
import model.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class AdminRepositoryImpls extends UserRepositoryImpl implements AdminRepository {
    public AdminRepositoryImpls(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Collection<Admin> findAdminByModeratedMovie(Movie movie) throws NonExistingEntityException {
      var admins =  entityMap.values()
                .stream()
                 .filter(e -> e instanceof Admin)
                 .map(Admin.class::cast)
                .filter(e ->  e.getMoviesModerated().contains(movie))
                .collect(Collectors.toList());
      if (admins.isEmpty()){
          throw new NonExistingEntityException(movie +" is not moderated by any admin. Admin not found.");
      }
      return admins;
    }

    @Override
    public Collection<Admin> findAdminByModeratedUser(User user) throws NonExistingEntityException {
        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getUsersModerated().contains(user))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException(user +" is not moderated by any admin. Admin not found.");
        }
        return admins;
    }
}
