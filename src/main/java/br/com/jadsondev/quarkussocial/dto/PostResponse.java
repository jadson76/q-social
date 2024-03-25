package br.com.jadsondev.quarkussocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostResponse {

    private String text;
    private LocalDateTime dataTime;

}
