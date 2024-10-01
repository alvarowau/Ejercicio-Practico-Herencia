package org.alvarowau.ejerciciopracticoherencia.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "engineers")
public class Engineer extends Employee {

    private String specialty;
    private int experienceYears;
    private String programmingLanguages;
    private String certifications;

    public Engineer(String specialty, int experienceYears, String programmingLanguages, String certifications) {
        this.specialty = specialty;
        this.experienceYears = experienceYears;
        this.programmingLanguages = programmingLanguages;
        this.certifications = certifications;
    }

    public Engineer(Long id, String name, String lastName, String email, Address address, String specialty, int experienceYears, String programmingLanguages, String certifications) {
        super(id, name, lastName, email, address);
        this.specialty = specialty;
        this.experienceYears = experienceYears;
        this.programmingLanguages = programmingLanguages;
        this.certifications = certifications;
    }

    public Engineer() {
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "specialty='" + specialty + '\'' +
                ", experienceYears=" + experienceYears +
                ", programmingLanguages='" + programmingLanguages + '\'' +
                ", certifications='" + certifications + '\'' +
                "} " + super.toString();
    }
}
