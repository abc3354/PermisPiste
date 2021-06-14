package com.epul.permispiste.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Mission", schema = "projetPermis")
public class MissionEntity {
    private int id;
    private String wording;
    private Collection<ActionMissionEntity> actionMissionsById;
    private Collection<InscriptionEntity> inscriptionsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wording", nullable = true, length = 25)
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (id != that.id) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "missionByFkMission")
    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    @OneToMany(mappedBy = "missionByFkMission")
    public Collection<InscriptionEntity> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionEntity> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }
}
