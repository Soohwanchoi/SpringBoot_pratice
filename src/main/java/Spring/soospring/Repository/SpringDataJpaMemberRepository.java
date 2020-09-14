package Spring.soospring.Repository;

import Spring.soospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Member save(Member member);

    @Override
    Optional<Member> findByName(String name);

    @Override
    Optional<Member> findById(Long id);

    @Override
    List<Member> findAll();
}
