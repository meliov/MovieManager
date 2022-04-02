package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.AdminRepository;
import model.entity.*;

import java.util.Collection;
import java.util.stream.Collectors;

 class AdminRepositoryImpls extends UserRepositoryImpl implements AdminRepository {
    public AdminRepositoryImpls(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, fileName);
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

    @Override
    public Collection<Admin> findAdminByModeratedTicket(Ticket ticket) throws NonExistingEntityException {

        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getTicketsModerated().contains(ticket))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException("Ticket:"+ ticket.getId()+ " of user: " +ticket.getUser().getUsername()
                    +" is not moderated by any admin. Admin not found.");
        }
        return admins;
    }

    @Override
    public Collection<Admin> findAdminByModeratedDailyProgram(DailyProgram dailyProgram) throws NonExistingEntityException {
        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getProgramsModerated().contains(dailyProgram))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException(dailyProgram.getId() + " is not moderated by any admin. Admin not found.");
        }
        return admins;
    }

    @Override
    public Collection<Admin> findAdminByModeratedProjection(Projection projection) throws NonExistingEntityException {
        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getProjectionsModerated().contains(projection))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException(projection.getId() + " is not moderated by any admin. Admin not found.");
        }
        return admins;
    }

    @Override
    public Collection<Admin> findAdminByModeratedHall(Hall hall) throws NonExistingEntityException {
        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getHallsModerated().contains(hall))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException(hall.getId() + " is not moderated by any admin. Admin not found.");
        }
        return admins;
    }

    @Override
    public Collection<Admin> findAdminByModeratedReview(Review review) throws NonExistingEntityException {
        var admins =  entityMap.values()
                .stream()
                .filter(e -> e instanceof Admin)
                .map(Admin.class::cast)
                .filter(e ->  e.getReviewsModerated().contains(review))
                .collect(Collectors.toList());
        if (admins.isEmpty()){
            throw new NonExistingEntityException(review.getId() + "of user: "+ review.getPostingUser().getUsername()
                    +" is not moderated by any admin. Admin not found.");
        }
        return admins;
    }
}
