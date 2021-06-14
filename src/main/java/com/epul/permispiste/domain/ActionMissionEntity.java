package com.epul.permispiste.domain;

import javax.persistence.*;

@Entity
@Table(name = "Action__Mission", schema = "projetPermis")
@IdClass(ActionMissionEntityPK.class)
public class ActionMissionEntity {
    private int fkAction;
    private int fkMission;
    private ActionEntity actionByFkAction;
    private MissionEntity missionByFkMission;

    @Id
    @Column(name = "fk_action", nullable = false)
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Id
    @Column(name = "fk_mission", nullable = false)
    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionMissionEntity that = (ActionMissionEntity) o;

        if (fkAction != that.fkAction) return false;
        if (fkMission != that.fkMission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fkAction;
        result = 31 * result + fkMission;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false)
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", nullable = false)
    public MissionEntity getMissionByFkMission() {
        return missionByFkMission;
    }

    public void setMissionByFkMission(MissionEntity missionByFkMission) {
        this.missionByFkMission = missionByFkMission;
    }
}
