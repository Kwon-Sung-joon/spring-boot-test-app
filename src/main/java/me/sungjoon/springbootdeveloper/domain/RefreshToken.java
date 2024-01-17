package me.sungjoon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //아무런 매개변수가 없는 생성자를 생성하되,
                                                   //다른 패키지 소속된 클래스는 접근을 불허한다.
@Getter
@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;
    public RefreshToken(Long userId, String refreshToken){
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
    public RefreshToken update(String newRefreshToken){
        this.refreshToken = refreshToken;
        return this;
    }
}
