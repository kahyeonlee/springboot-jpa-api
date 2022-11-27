package com.likelion.springjpaexercise.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
/*
두 객체 연관관계 중 외래 키를 관리하는 쪽을 주인이라 함
외래 키를 가진 테이블과 매핑한 엔티티를 보통 연관관계의 주인으로 선택
주인이 아닌 방향은 외래 키 변경 불가, 읽기만 가능
주인이 아닌 쪽은 mappedBy 속성을 사용하여 주인 필드 이름을 값으로 입력
*/

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Long id;
    private String roadNameAddress;
    private String hospitalName;

    //지연로딩 -필요한 시점에 연관된 데이터를 불러오는 것(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "hospital", fetch = FetchType .LAZY)
    private List<Review> reviews;
}