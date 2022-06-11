package com.kit.movie.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER", "고객"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
