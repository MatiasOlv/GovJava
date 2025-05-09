package repository;

import entity.Emissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmissaoRepository extends JpaRepository<Emissao, Long> {
    // Métodos customizados (se precisar) aqui
}