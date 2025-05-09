package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMI_CARBONO")
@Data // Lombok já cria getters, setters, equals, hashCode, toString
@NoArgsConstructor
@AllArgsConstructor
public class Emissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emissao")
    private Long id;

    @NotNull
    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @NotNull
    @Column(name = "setor")
    private String setor;

    @NotNull
    @Positive
    @Column(name = "quantidade_toneladas")
    private BigDecimal quantidadeToneladas;

    @NotNull
    @Column(name = "id_empresa")
    private Long idEmpresa;

}
