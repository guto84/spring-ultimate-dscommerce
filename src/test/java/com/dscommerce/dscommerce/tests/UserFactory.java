package com.dscommerce.dscommerce.tests;

import com.dscommerce.dscommerce.entities.Role;
import com.dscommerce.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {
    public static User createClientUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Maria");
        user.setEmail("maria@gmail.com");
        user.setPhone("988888888");
        user.setBirthDate(LocalDate.parse("2001-07-25"));
        user.setPassword("$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Alex");
        user.setEmail("alex@gmail.com");
        user.setPhone("977777777");
        user.setBirthDate(LocalDate.parse("1987-12-13"));
        user.setPassword("$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        user.addRole(new Role(1L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomClientUser(Long id, String username) {
        User user = new User();
        user.setId(id);
        user.setName(username);
        user.setEmail("maria@gmail.com");
        user.setPhone("988888888");
        user.setBirthDate(LocalDate.parse("2001-07-25"));
        user.setPassword("$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createCustomAdminUser(Long id, String username) {
        User user = new User();
        user.setId(id);
        user.setName(username);
        user.setEmail("alex@gmail.com");
        user.setPhone("977777777");
        user.setBirthDate(LocalDate.parse("1987-12-13"));
        user.setPassword("$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        user.addRole(new Role(1L, "ROLE_ADMIN"));
        return user;
    }
}
