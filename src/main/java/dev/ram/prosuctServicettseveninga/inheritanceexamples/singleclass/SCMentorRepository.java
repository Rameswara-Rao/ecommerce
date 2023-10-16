package dev.ram.prosuctServicettseveninga.inheritanceexamples.singleclass;

import dev.ram.prosuctServicettseveninga.inheritanceexamples.mappedsuperclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SCMentorRepository extends JpaRepository<User, Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
}
