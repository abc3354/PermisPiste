package com.epul.permispiste.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Action", schema = "projetPermis")
public class ActionEntity {
    private int id;
    private Integer fkAction;
    private String wording;
    private Integer scoreMinimum;
    private ActionEntity actionByFkAction;
    private Collection<ActionEntity> actionsById;
    private Collection<ActionMissionEntity> actionMissionsById;
    private Collection<IndicatorEntity> indicatorsById;
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
    @Column(name = "fk_action", nullable = true)
    public Integer getFkAction() {
        return fkAction;
    }

    public void setFkAction(Integer fkAction) {
        this.fkAction = fkAction;
    }

    @Basic
    @Column(name = "wording", nullable = true, length = 25)
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Basic
    @Column(name = "scoreMinimum", nullable = true)
    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (id != that.id) return false;
        if (fkAction != null ? !fkAction.equals(that.fkAction) : that.fkAction != null) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;
        if (scoreMinimum != null ? !scoreMinimum.equals(that.scoreMinimum) : that.scoreMinimum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkAction != null ? fkAction.hashCode() : 0);
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (scoreMinimum != null ? scoreMinimum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id")
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<IndicatorEntity> getIndicatorsById() {
        return indicatorsById;
    }

    public void setIndicatorsById(Collection<IndicatorEntity> indicatorsById) {
        this.indicatorsById = indicatorsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<InscriptionActionEntity> getInscriptionActionsById() {
        return inscriptionActionsById;
    }

    public void setInscriptionActionsById(Collection<InscriptionActionEntity> inscriptionActionsById) {
        this.inscriptionActionsById = inscriptionActionsById;
    }
}
