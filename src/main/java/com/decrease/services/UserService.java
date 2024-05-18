    package com.decrease.services;

import com.decrease.EcommerceT1LpApplication;
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

    /**
     * Esta classe de serviço fornece métodos relacionados às operações de usuário.
     */
    @Service
    public class UserService {

        @Autowired
        private UserRepository repository;

        @Autowired
        private ValidatorController validator;

        /**
         * Exibe uma mensagem de erro.
         *
         * @param msg   A mensagem de erro
         * @param title O título da mensagem de erro
         */
        public void showErrorMsg(String msg, String title){
            Alerts.showErrorMessage(msg, msg, null);
        }
        
        /**
         * Busca todos os usuários.
         *
         * @return Uma lista contendo todos os usuários
         */
        public List<User> findAll() {
            return repository.findAll();
        }

        /**
         * Busca um usuário pelo seu ID.
         *
         * @param id O ID do usuário a ser buscado
         * @return O usuário encontrado, ou um Optional vazio se não encontrado
         */
        public Optional<User> findById(Long id) {
            Optional<User> obj = repository.findById(id);
            return obj;
        }

        /**
         * Insere um novo usuário no banco de dados.
         *
         * @param newUser O novo usuário a ser inserido
         * @return O usuário inserido
         * @throws CustomException Se houver um problema ao inserir o usuário
         */
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
//                Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
                showErrorMsg(e.getMessage(), "There was a Problem");
                throw e;
            }
        }
        
        /**
         * Atualiza um usuário existente.
         *
         * @param id  O ID do usuário a ser atualizado
         * @param obj O usuário com os dados atualizados
         * @return O usuário atualizado
         */
        public User update(Long id, User obj) {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }

        /**
         * Atualiza os dados de um usuário com base nos dados de outro usuário.
         * 
         * @param entity O usuário cujos dados serão atualizados.
         * @param obj O usuário com os novos dados.
         */
        private void updateData(User entity, User obj) {
            entity.setName(obj.getName());
            entity.setEmail(obj.getEmail());
            entity.setPassword(obj.getPhone());
            entity.setPhone(obj.getPhone());
        }

        /**
         * Realiza o login de um usuário.
         *
         * @param email    O email do usuário
         * @param password A senha do usuário
         * @param session  O controlador de sessão
         * @return true se o login for bem-sucedido, false caso contrário
         * @throws CustomException Se houver um problema ao realizar o login
         */
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
                        msg = EcommerceT1LpApplication.msgManager.getMessage("invalid-passoword-alert");

                    throw new CustomException(msg);
                    }

                } else {
                    msg = EcommerceT1LpApplication.msgManager.getMessage("user-not-found-alert");

                    throw new CustomException(msg);
                }

            } catch (CustomException e) {
//                Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
                showErrorMsg(e.getMessage(), "There was a Problem");
                throw e;
            }

        }

        /**
         * Retorna o usuário logado.
         *
         * @param session O controlador de sessão
         * @return O usuário logado
         */
        public User getUserLogged(SessionController session) {
            return session.getUserLogged();
        }

        /**
         * Retorna o carrinho do usuário.
         *
         * @param session O controlador de sessão
         * @return O carrinho do usuário
         */
        public Set<CartItem> getUserCart(SessionController session) {
            return session.getUserLogged().getCart().getItems();
        }

        /**
         * Retorna o endereço do usuário.
         *
         * @param session O controlador de sessão
         * @return O endereço do usuário
         */
        public Address getAddress(SessionController session) {
            return session.getUserLogged().getAddress();
        }

    }
