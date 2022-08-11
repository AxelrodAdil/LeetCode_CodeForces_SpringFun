package spring.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.test.entity.SearchObject;
import spring.test.entity.SearchOperation;
import spring.test.entity.User;
import spring.test.repository.UserRepository;
import spring.test.repository.impl.UserSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final List<SearchObject> SEARCH_OBJECT_LIST =
            List.of(new SearchObject("username", "Curry", SearchOperation.EQUAL),
                    new SearchObject("userAge", 20L, SearchOperation.NOT_EQUAL));

    public List<?> getAllUsers() {
        return userRepository.findAll();
    }

    public List<?> getAllUsersByFunctionalInterface() {
        UserSpecification userSpecification = new UserSpecification();
        SEARCH_OBJECT_LIST.stream().map(e -> new SearchObject(e.getKey(), e.getValue(), e.getOperation())).forEach(userSpecification::add);
        List<User> userList = userRepository.findAll(userSpecification);
        userList.forEach(System.out::println);
        return userList;
    }
}
