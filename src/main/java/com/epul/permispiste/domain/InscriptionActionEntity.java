package com.epul.permispiste.domain;

import javax.persistence.*;

@Entity
@Table(name = "Inscription__Action", schema = "projetPermis")
public class InscriptionActionEntity {
    private int id;
    private int fkInscription;
    private int fkAction;
    private Integer sort;
    private Integer score;
    private InscriptionEntity inscriptionByFkInscription;
    private ActionEntity actionByFkAction;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_inscription", nullable = false)
    public int getFkInscription() {
        return fkInscription;
    }

    public void setFkInscription(int fkInscription) {
        this.fkInscription = fkInscription;
    }

    @Basic
    @Column(name = "fk_action", nullable = false)
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionActionEntity that = (InscriptionActionEntity) o;

        if (id != that.id) return false;
        if (fkInscription != that.fkInscription) return false;
        if (fkAction != that.fkAction) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkInscription;
        result = 31 * result + fkAction;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_inscription", referencedColumnName = "id", nullable = false)
    public InscriptionEntity getInscriptionByFkInscription() {
        return inscriptionByFkInscription;
    }

    public void setInscriptionByFkInscription(InscriptionEntity inscriptionByFkInscription) {
        this.inscriptionByFkInscription = inscriptionByFkInscription;
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false)
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }
}
