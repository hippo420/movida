package app.movida.business.entity;

import app.movida.system.util.FileCompressUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.IOException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

//    @Lob
//    @JsonIgnore
//    private byte[] photo;  // 압축 저장된 사진 데이터


}

