package dev.ram.prosuctServicettseveninga.inheritanceexamples.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentor")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}