package app.movida.business.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;

//    @Lob
//    @Column(columnDefinition = "LONGBLOB")
//    private byte[] photo;  // 압축 저장된 사진 데이터
}
