package com.ercan.Stream.IntermediateOperations;

import com.ercan.model.User;
import com.ercan.model.UserDTO;
import com.ercan.model.User.UserMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /* EXAMPLE 1 */
        List<String> upperCaseList = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());  // [ALİCE,BOB,CHARLİE,DAVİD,EDWARD]


        /* EXAMPLE 2 */
        names.stream()
                .map(n -> n.contains("e"))
                .collect(Collectors.toList());  // [true , false , true , false , false]


        /* EXAMPLE 3 */
        List<Integer> multipleNumBy2 = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());


        /* EXAMPLE 4 */
        List<User> userList = Arrays.asList(
                new User("Alice", 12),
                new User("Charlie", 25),
                new User("Bob", 33),
                new User("David", 41));

        List<String> userNames = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());  // [Alice, Charlie, Bob, David]



        /* EXAMPLE 5 */
        List<UserDTO> userDTOList = userList.stream()
                .map(user->new UserDTO(user.getName(),user.getAge()))
                .collect(Collectors.toList());

        List<UserDTO> userDTOList1 = userList.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());




    }
}
