    package com.decrease.services;

    import com.decrease.controller.SessionController;
    import com.decrease.controller.ValidatorController;
    import com.decrease.entities.Address;
    import com.decrease.entities.CartItem;
    import com.decrease.entities.User;
    import com.decrease.model.Alerts;
    import com.decrease.model.CustomException;
    import com.decrease.repositories.UserRepository;
    import java.util.List;
    import java.util.Optional;
    import java.util.Set;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        @Autowired
        private UserRepository repository;

        @Autowired
        private ValidatorController validator;

        public List<User> findAll() {
            return repository.findAll();
        }

        public Optional<User> findById(Long id) {
            Optional<User> obj = repository.findById(id);
            return obj;
        }

        public User insert(User newUser) throws CustomException {
            boolean sameUsername = repository.existsByName(newUser.getName());
            boolean sameEmail = repository.existsByEmail(newUser.getEmail());
            boolean validEmailFormat = validator.isValidEmail(newUser.getEmail());
            String msg;

            try {
                if (!sameUsername && !sameEmail) {
                    if (validEmailFormat) {
                        return repository.save(newUser);
                    } else {
                        throw new CustomException("Invalid email format");
                    }

                } else {
                    if (sameUsername) {
                        msg = """
                        Username provided is already in use.
                        Try again
                        """;

    //                    throw new CustomException(msg);
                          throw new CustomException(msg);
                    } else {
                        msg = """
                        Email provided is already in use.
                        Try again
                        """;

                       throw new CustomException(msg);
                    }
                }

            } catch (CustomException e) {
                Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
                throw e;
            }
        }
        
        public User update(Long id, User obj) {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }

        private void updateData(User entity, User obj) {
            entity.setName(obj.getName());
            entity.setEmail(obj.getEmail());
            entity.setPassword(obj.getPhone());
            entity.setPhone(obj.getPhone());
        }

        public boolean logIn(String email, String password, SessionController session) throws CustomException {
            Optional<User> userOptional = repository.findByEmail(email);
            String msg;

            try {

                if (userOptional.isPresent()) {
                    User findedUser = userOptional.get();

                    if (findedUser.getPassword().equals(password)) {
                        session.logIn(findedUser);
                        return true;
                    } else {
                        msg = """
                        Invalid password!
                        """;

                    throw new CustomException(msg);
                    }

                } else {
                    msg = """
                        User not found!
                        """;

                    throw new CustomException(msg);
                }

            } catch (CustomException e) {
                Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
                throw e;
            }

        }

        public User getUserLogged(SessionController session) {
            return session.getUserLogged();
        }

        public Set<CartItem> getUserCart(SessionController session) {
            return session.getUserLogged().getCart().getItems();
        }

        public Address getAddress(SessionController session) {
            return session.getUserLogged().getAddress();
        }

    }
