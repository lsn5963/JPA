package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@DiscriminatorColumn //dtype을 만들어줌 //(name = "DIS_TYPE") NAME을 DIS_TYPE로 바꿈 //단일 테이블일때는 DiscriminatorColumn없어도 자동으로 생긴다 -> 한테이블에 다 들어가있기 때문에 자동으로 dtype가 생김
//구현 클래스마다 테이블 전략은 Item이라는 클래스가 안만들어짐, DiscriminatorColumn 필요없음 이미 다 구별하기 때문에
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
