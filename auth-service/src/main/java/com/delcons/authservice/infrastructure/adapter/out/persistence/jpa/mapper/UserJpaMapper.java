package com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.mapper;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.PasswordHash;
import com.delcons.authservice.domain.model.valueobject.Username;
import com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserJpaMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "passwordHash", source = "passwordHash")
    UserEntity toEntity(User user);

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "passwordHash", source = "passwordHash")
    User toDomain(UserEntity userEntity);

    // ValueObjects <-> String
    default String map(Email v) {
        return v == null ? null : v.value();
    }

    default Email mapEmail(String v) {
        return v == null ? null : new Email(v);
    }

    default String map(Username v) {
        return v == null ? null : v.value();
    }

    default Username mapUsername(String v) {
        return v == null ? null : new Username(v);
    }

    default String map(PasswordHash v) {
        return v == null ? null : v.value();
    }

    default PasswordHash mapPasswordHash(String v) {
        return v == null ? null : new PasswordHash(v);
    }
}
