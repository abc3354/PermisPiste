package com.epul.permispiste.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Inscription", schema = "projetPermis")
public class InscriptionEntity {
    private int id;
    private int fkLearner;
    private int fkMission;
    private Date date;
    private LearnerEntity learnerByFkLearner;
    private MissionEntity missionByFkMission;
    private Collection<InscriptionActionEntity> inscriptionActionsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_learner", nullable = false)
    public int getFkLearner() {
        return fkLearner;
    }

    public void setFkLearner(int fkLearner) {
        this.fkLearner = fkLearner;
    }

    @Basic
    @Column(name = "fk_mission", nullable = false)
    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntity that = (InscriptionEntity) o;

        if (id != that.id) return false;
        if (fkLearner != that.fkLearner) return false;
        if (fkMission != that.fkMission) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkLearner;
        result = 31 * result + fkMission;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_learner", referencedColumnName = "id", nullable = false)
    public LearnerEntity getLearnerByFkLearner() {
        return learnerByFkLearner;
    }

    public void setLearnerByFkLearner(LearnerEntity learnerByFkLearner) {
        this.learnerByFkLearner = learnerByFkLearner;
    }

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", nullable = false)
    public MissionEntity getMissionByFkMission() {
        return missionByFkMission;
    }

    public void setMissionByFkMission(MissionEntity missionByFkMission) {
        this.missionByFkMission = missionByFkMission;
    }

    @OneToMany(mappedBy = "inscriptionByFkInscription")
    public Collection<InscriptionActionEntity> getInscriptionActionsById() {
        return inscriptionActionsById;
    }

    public void setInscriptionActionsById(Collection<InscriptionActionEntity> inscriptionActionsById) {
        this.inscriptionActionsById = inscriptionActionsById;
    }
}
